package sharesport


import grails.test.mixin.*
import spock.lang.*
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus

@TestFor(UserController)
@Mock(User)
class UserControllerSpec extends Specification {

    UserService userTestService = new UserService()

    def setup() {
        userTestService.transactionManager = Mock(PlatformTransactionManager) {
            getTransaction(_) >> Mock(TransactionStatus)
        }
        controller.userService = userTestService
    }

    def populateValidParams(params) {
        assert params != null
        params["email"] = "email@gmail.com"
        params["login"] = "login"
        params["password"] = "password"
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.userInstanceList
        model.userInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.userInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        def user = new User()
        user.validate()
        controller.save(user)

        then: "The create view is rendered again with the correct model"
        model.userInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        user = new User(params)

        controller.save(user)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/user/show/1'
        controller.flash.message != null
        User.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def user = new User(params)
        controller.show(user)

        then: "A model is populated containing the domain instance"
        model.userInstance == user
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def user = new User(params)
        controller.edit(user)

        then: "A model is populated containing the domain instance"
        model.userInstance == user
    }

    void "Test the update action performs an update on a valid domain instance"() {

        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/user/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def user = new User()
        user.validate()
        controller.update(user)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.userInstance == user

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        user = new User(params).save(flush: true)
        controller.update(user)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/user/show/$user.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/user/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def user = new User(params).save(flush: true)

        then: "It exists"
        User.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(user)

        then: "The instance is deleted"
        User.count() == 0
        response.redirectedUrl == '/user/index'
        flash.message != null
    }

    void "Test de l'inscription d'un utilisateur valide"() {

        when: "Appel de l'inescription avec des parametres d'inscription valides"
        controller.params.email = "toto@toto.fr"
        controller.params.login = "toto"
        controller.params.password = "totototo"
        controller.inscription()

        then: "Réponse positive"
        response.json.toString() == "{\"emailError\":\"\",\"succeed\":\"true\",\"loginError\":\"\"}"
    }

    void "Test de l'inscription d'un utilisateur non valide"() {

        when: "Appel de l'inescription avec des parametres d'inscription non valides"
        controller.params.email = "toto"
        controller.params.login = "toto"
        controller.params.password = "totototo"
        controller.inscription()

        then: "Réponse negative"
        response.json.toString() == "{\"emailError\":\"\",\"succeed\":\"false\",\"loginError\":\"\"}"
    }

    void "Test de l'inscription d'un utilisateur avec login et email deja utilisé"() {

        User user = new User()
        user.email = "toto@toto.fr"
        user.login = "toto"
        user.password = "totototo"
        user.save(flush: true)

        when: "Appel de l'inescription avec des parametres d'inscription déjà utilisés"
        controller.params.email = "toto@toto.fr"
        controller.params.login = "toto"
        controller.params.password = "totototo"
        controller.inscription()

        then: "Réponse negative"
        response.json.toString() == "{\"emailError\":\"Email déjà utilisé\",\"succeed\":\"false\",\"loginError\":\"Login déjà utilisé\"}"
    }

    void "Test de mise a jour des champs d'un utilisateur"(){
        given: "un utilisateur"
        User user = new User(
                email: "toto@toto.fr",
                login: "toto",
                password: ("totototo").encodeAsMD5(),
                score: 4
        )
        user.save(flush: true)
        int idUser = user.getId()

        when: "informations d'un utilisateur est modifie"
        user.email = emailTest
        user.login = loginTest
        user.password = passwordTest
        user.score = scoreTest
        controller.update(user)
        User userModel  = User.get(idUser)

        then: "tous les chmaps dans model doivent être modifiés"
        userModel.login == loginTest
        userModel.email == emailTest
        userModel.score == scoreTest
        userModel.password == passwordTest.encodeAsMD5()

        where:
        emailTest   |   loginTest   |   passwordTest    |   scoreTest
        "abc@abc.fr"|   "abcde"     |   "12345678"      |   4
    }

    void "Test du login d'un utilisateur valide"() {

        User user = new User()
        user.email = "toto@toto.fr"
        user.login = "toto"
        user.password = "totototo"
        user.save(flush: true)

        when: "Appel du login avec des identifiants corrects"
        controller.params.email = "toto@toto.fr"
        controller.params.password = "totototo"
        controller.login()

        then: "Réponse positive"
        response.json.toString() == "{\"succeed\":\"true\",\"url\":\"user/index\"}"
    }

    @Unroll
    void "Test du login d'un utilisateur avec mauvais identifiants"() {

        User user = new User()
        user.email = "toto@toto.fr"
        user.login = "toto"
        user.password = "totototo"
        user.isActive = aIsActive
        user.save(flush: true)

        when: "Appel du login avec des identifiants incorrects"
        controller.params.email = aEmail
        controller.params.password = aPassword
        controller.login()

        then: "Réponse négative"
        response.json.toString() == "{\"succeed\":\"false\",\"url\":\"\"}"

        where:
        aIsActive | aEmail         | aPassword
        true      | "tata@toto.fr" | "titititi"
        true      | "tata@toto.fr" | "totototo"
        true      | null           | "totototo"
        true      | "toto@toto.fr" | null
        true      | null           | null
        false     | "toto@toto.fr" | "totototo"
        false     | "tata@toto.fr" | "titititi"
        false     | "tata@toto.fr" | "totototo"
        null      | "tata@toto.fr" | "tititi"
        null      | "tata@toto.fr" | "totototo"
        null      | "toto@toto.fr" | "titititi"
        null      | "toto@toto.fr" | "totototo"
    }

    void "Test du login d'un utilisateur inactif"() {

        User user = new User()
        user.email = "toto@toto.fr"
        user.login = "toto"
        user.password = "totototo"
        user.isActive = false
        user.save(flush: true)

        when: "Appel du login avec des identifiants incorrects"
        controller.params.email = "toto@toto.fr"
        controller.params.password = "totototo"
        controller.login()

        then: "Réponse négative"
        response.json.toString() == "{\"succeed\":\"false\",\"url\":\"\"}"
    }

}
