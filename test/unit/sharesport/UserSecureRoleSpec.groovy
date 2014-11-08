package sharesport

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(UserSecureRole)
@Mock([SecureRole, User])
class UserSecureRoleSpec extends Specification {

    UserSecureRole secureRole1
    UserSecureRole secureRole2

    def setup() {
        secureRole1 = new UserSecureRole()
        secureRole2 = new UserSecureRole()
    }

    def cleanup() {
    }

    void "Test equals du SecureRole"() {
        given:"on compare un SecureRole"
        secureRole1.secureRole = Mock(SecureRole)
        secureRole1.save()

        when:"on compare le SecureRole à lui meme"
        def res = secureRole1.equals(secureRole1)

        then:"le resultat doit être vrai"
        res == true
    }

    void "Test equals valide de deux SecureRole"() {
        given:"on a deux SecureRole"
        SecureRole role1 = Mock(SecureRole){
            getId() >> 1
        }
        SecureRole role2 = Mock(SecureRole){
            getId() >> 1
        }

        User user1 = Mock(User){
            getId() >> 1
        }
        User user2 = Mock(User){
            getId() >> 1
        }

        secureRole1.secureRole = role1
        secureRole2.secureRole = role2
        secureRole1.user = user1
        secureRole2.user = user2

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être vrai"
        res == true
    }

    void "Test equals non valide de deux SecureRole"() {
        given:"on a deux SecureRole"
        SecureRole role1 = Mock(SecureRole){
            getId() >> 1
        }
        SecureRole role2 = Mock(SecureRole){
            getId() >> 2
        }

        User user1 = Mock(User){
            getId() >> 1
        }
        User user2 = Mock(User){
            getId() >> 2
        }

        secureRole1.secureRole = role1
        secureRole2.secureRole = role2
        secureRole1.user = user1
        secureRole2.user = user2

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être faux"
        res == false
    }

    void "Test equals non valide de deux SecureRole bis"() {
        given:"on a deux SecureRole"
        SecureRole role1 = Mock(SecureRole){
            getId() >> 1
        }
        SecureRole role2 = Mock(SecureRole){
            getId() >> 1
        }

        User user1 = Mock(User){
            getId() >> 1
        }
        User user2 = Mock(User){
            getId() >> 2
        }

        secureRole1.secureRole = role1
        secureRole2.secureRole = role2
        secureRole1.user = user1
        secureRole2.user = user2

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être faux"
        res == false
    }

    void "Test equals non valide de deux SecureRole ter"() {
        given:"on a deux SecureRole"
        SecureRole role1 = Mock(SecureRole){
            getId() >> 1
        }
        SecureRole role2 = Mock(SecureRole){
            getId() >> 2
        }

        User user1 = Mock(User){
            getId() >> 1
        }
        User user2 = Mock(User){
            getId() >> 1
        }

        secureRole1.secureRole = role1
        secureRole2.secureRole = role2
        secureRole1.user = user1
        secureRole2.user = user2

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être faux"
        res == false
    }

    void "Test equals non valide de deux SecureRole 4"() {
        given:"on a deux SecureRole"
        SecureRole role1 = Mock(SecureRole){
            getId() >> 1
        }
        SecureRole role2 = Mock(SecureRole){
            getId() >> 2
        }

        User user1 = Mock(User){
            getId() >> 1
        }


        secureRole1.secureRole = role1
        secureRole2.secureRole = role2
        secureRole1.user = user1
        secureRole2.user = null

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être faux"
        res == false
    }

    void "Test equals non valide de deux SecureRole 5"() {
        given:"on a deux SecureRole"
        SecureRole role1 = Mock(SecureRole){
            getId() >> 1
        }


        User user1 = Mock(User){
            getId() >> 1
        }
        User user2 = Mock(User){
            getId() >> 2
        }


        secureRole1.secureRole = role1
        secureRole2.secureRole = null
        secureRole1.user = user1
        secureRole2.user = user2

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être faux"
        res == false
    }

    void "Test equals non valide de deux SecureRole 6"() {
        given:"on a deux SecureRole"

        User user1 = Mock(User){
            getId() >> 1
        }
        User user2 = Mock(User){
            getId() >> 2
        }


        secureRole1.secureRole = null
        secureRole2.secureRole = null
        secureRole1.user = user1
        secureRole2.user = user2

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être faux"
        res == false
    }

    void "Test equals valide de deux SecureRole 6 bis"() {
        given:"on a deux SecureRole"

        User user1 = Mock(User){
            getId() >> 1
        }
        User user2 = Mock(User){
            getId() >> 1
        }


        secureRole1.secureRole = null
        secureRole2.secureRole = null
        secureRole1.user = user1
        secureRole2.user = user2

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être vrai"
        res == true
    }

    void "Test equals non valide de deux SecureRole 7"() {
        given:"on a deux SecureRole"
        SecureRole role1 = Mock(SecureRole){
            getId() >> 1
        }
        SecureRole role2 = Mock(SecureRole){
            getId() >> 2
        }

        secureRole1.secureRole = role1
        secureRole2.secureRole = role2
        secureRole1.user = null
        secureRole2.user = null

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être faux"
        res == false
    }

    void "Test equals valide de deux SecureRole 7 bis"() {
        given:"on a deux SecureRole"
        SecureRole role1 = Mock(SecureRole){
            getId() >> 1
        }
        SecureRole role2 = Mock(SecureRole){
            getId() >> 1
        }

        secureRole1.secureRole = role1
        secureRole2.secureRole = role2
        secureRole1.user = null
        secureRole2.user = null

        when:"on compare le SecureRole à l'autre SecureRole"
        def res = secureRole1.equals(secureRole2)

        then:"le resultat doit être vrai"
        res == true
    }

    void "Test equals avec objet d'autre insance"(){
        given:"on a un SecureRole et un objet d'un autre instance"
        secureRole1.secureRole = Mock(SecureRole)
        secureRole1.save()

        when:"on compare le SecureRole à lui meme"
        def res = secureRole1.equals(new String("toto"))

        then:"le resultat doit être faux"
        res == false
    }

    void "Test equals avec objet null"(){
        given:"on a un SecureRole et un objet d'un autre instance"
        secureRole1.secureRole = Mock(SecureRole)
        secureRole1.save()

        when:"on compare le SecureRole à lui meme"
        def res = secureRole1.equals(null)

        then:"le resultat doit être faux"
        res == false
    }
}
