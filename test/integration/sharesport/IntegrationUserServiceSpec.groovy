package sharesport


import spock.lang.*

/**
 *
 */
class IntegrationUserServiceSpec extends Specification {

    UserService userService
    def setup() {

    }

    def cleanup() {
    }

    void "test d'inscription d'un utilisateur"() {
        given: "un utilisateur"
        User user = new User(username: "abcdef", enabled: true, password: "12345678", email: "abc@abc.com", score: 0,
                accountExpired: true)

        when: "utilisateur s'inscrit"
        def result = userService.signUpUser(user)

        then: "inscription success"
        result['succeed'] == "true"
    }

    void "test d'invalidation d'un utilisateur pendant l'inscription"(){
        given: "un utilisateur ayant un mot de pass vide"
        User user = new User(username: "abcdef", enabled: true, password: "", email: "abc@abc.com", score: 0,
                accountExpired: true)

        when: "utilisateur s'inscrit"
        def result = userService.signUpUser(user)

        then: "inscription échoué"
        result['succeed'] == "false"
    }

    void "test de duplication de nom d'utilisateur pendant l'inscription"(){
        given: "un utilisateur ayant meme nom que celui d'un autre utilisateur"
        User user = new User(username: "admin", enabled: true, password: "12345678", email: "abc@abc.com", score: 0,
                accountExpired: true)

        when: "utilisateur s'inscrit"
        def result = userService.signUpUser(user)

        then: "inscription échoué"
        result['succeed'] == "false"
        result['loginError'] == "Login déjà utilisé"
    }

    void "test de duplication de mail d'utilisateur pendant l'inscription"(){
        given: "un utilisateur ayant meme email que celui d'un autre utilisateur"
        User user = new User(username: "abcdef", enabled: true, password: "12345678", email: "admin@admin.fr", score: 0,
                accountExpired: true)

        when: "utilisateur s'inscrit"
        def result = userService.signUpUser(user)

        then: "inscription échoué"
        result['succeed'] == "false"
        result['emailError'] == "Email déjà utilisé"
    }

    void "test de sauvegarde d'un utilisateur"(){
        given: "un utilisateur"
        User user = new User(username: "abcdef", enabled: true, password: "12345678", email: "abc@abc.com", score: 0,
                accountExpired: true)

        when: "sauvegarde l'utilisateur"
        def result = userService.saveUser(user)

        then: "sauvegarde success"
        result != null
    }

    void "test d'invalidation d'un utilisateur"(){
        given: "un utilisateur ayant le mot de passe vide"
        User user = new User(username: "abcdef", enabled: true, password: "", email: "abc@abc.com", score: 0,
                accountExpired: true)

        when: "sauvegarde l'utilisateur"
        def result = userService.saveUser(user)

        then: "sauvegarde échoué"
        result == null
    }
}
