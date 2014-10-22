package sharesport

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    User user
    static String longString = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"

    def setup() {
        user = new User();
    }

    def cleanup() {
    }

    @Unroll
    void "test contrainte d'un user valide : #aPseudo"() {

        given: "pour un utilisateur valide"
        user.email = aEmail
        user.password = aPassword
        user.login = aPseudo

        when: "sauvegarde de l'utilisateur dans la base de données"
        def res = user.validate()

        then: "la validation doit fonctionner"
        res == true
        !user.hasErrors()
        user.isActive == true
        user.isAdmin == false

        where:
        aEmail               | aPassword                   | aPseudo
        "login@gmail.fr"     | "motdepassevalide"          | "login"
        "toto.titi@yahoo.fr" | "autre!mot_de-PAsse1valide" | "toto-titi"

    }

    @Unroll
    void "test contraintes d'un user non valide : #aPseudo"() {

        given: "pour un utilisateur non valide"
        user.email = aEmail
        user.password = aPassword
        user.login = aPseudo
        user.score = aScore

        when: "sauvegarde de l'utilisateur dans la base de données"
        def res = user.validate()

        then: "la validation doit fonctionner"
        res == false
        user.hasErrors()

        where:
        aEmail               | aPassword          | aPseudo          | aScore
        "test"               | "motdepassevalide" | "emailnonvalide" | 0
        ""                   | "motdepassevalide" | "emailvide"      | 1
        null                 | "motdepassevalide" | "emailnull"      | 2
        "toto@gmail.com"     | "1234"             | "passwordShort"  | 3
        "toto@gmail.com"     | longString         | "passwordlong"   | 4
        "toto@gmail.com"     | null               | "passwordnull"   | 5
        "toto.titi@yahoo.fr" | "motdepassevalide" | ""               | 6
        "toto.titi@yahoo.fr" | "motdepassevalide" | null             | 7
        "toto.titi@yahoo.fr" | "motdepassevalide" | "123"            | 8
        "toto.titi@yahoo.fr" | "motdepassevalide" | longString       | 9
        "toto.titi@yahoo.fr" | "motdepassevalide" | "score negatif"  | -2

    }

    void "test contraintes email unique"() {

        given: "pour 2 utilisateurs ayant le même email"
        user.email = "toto@gmail.com"
        user.login = "toto"
        user.password = "oiuadzojoadzja"
        User user2 = new User()
        user2.email = "toto@gmail.com"
        user2.login = "titi"
        user2.password = "fijojfezojefz"
        user.save(flush: true)


        when: "sauvegarde du 2eme utilisateur"
        def res = user2.validate()

        then: "la validation ne doit pas fonctionner"
        res == false
        user2.hasErrors()
    }

    void "test contraintes login unique"() {

        given: "pour 2 utilisateurs ayant le même login"
        user.email = "toto@gmail.com"
        user.login = "toto"
        user.password = "oiuadzojoadzja"
        User user2 = new User()
        user2.email = "titi@gmail.com"
        user2.login = "toto"
        user2.password = "fijojfezojefz"
        user.save(flush: true)


        when: "sauvegarde du 2eme utilisateur"
        def res = user2.validate()

        then: "la validation ne doit pas fonctionner"
        res == false
        user2.hasErrors()
    }

}
