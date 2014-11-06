package sharesport

import grails.test.mixin.Mock

/**
 * Created by fabien on 06/11/14.
 */
import grails.test.mixin.TestFor
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

@TestFor(SecureRoleService)
@Mock([SecureRole])
class SecureRoleServiceSpec extends Specification{
    SecureRoleService secureRoleService

    def setup() {
        secureRoleService = new SecureRoleService()
        secureRoleService.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }
    }

    def "test de récuperation d'un role securisé utilisateur"(){
        given: ""

        when: "on essaie de récuperer un role user"
        def role = secureRoleService.getRoleUser()

        then: "le role est un rôle user"
        role.authority == "ROLE_USER"
    }

    def "test de récuperation d'un role securisé admin"(){
        given: ""

        when: "on essaie de récuperer un role admin"
        def role = secureRoleService.getRoleAdmin()

        then: "le role est un rôle admin"
        role.authority == "ROLE_ADMIN"
    }

    def "test de récuperation de plusieurs roles securisés utilisateur"(){
        given: ""

        when: "on essaie de récuperer deux roles user"
        def role = secureRoleService.getRoleUser()
        def role2 = secureRoleService.getRoleUser()

        then: "le role est un rôle user"
        role.authority == "ROLE_USER"
        role2.authority == "ROLE_USER"
    }

}
