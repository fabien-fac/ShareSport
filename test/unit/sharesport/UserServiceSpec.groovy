package sharesport

/**
 * Created by kana on 24/10/14.
 */
import grails.test.mixin.*
import grails.util.GrailsWebUtil
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import spock.lang.*
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@TestFor(UserService)
@Mock([User])
class UserServiceSpec extends Specification{
    UserService userService
    User userTest

    def setup() {
        userService = new UserService()
        userService.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }
        userTest = Mock(User)

        mockDomain(User, [
                [email: "abc@abc.com", password: "12345678",username: "abcde", score: 0]
        ])
    }

    def "test parametre d'insription d'utilisateur invalide"(){
        given: "identifiant et email"
        def username = "abcde"
        def email = "abc@abc.com"
        def password = "12345678"
        userTest.username >> username
        userTest.email >> email
        userTest.password >> password
        userTest.score >> 0
        //userTest.save(flush: true, failOnError:true)

        when: "identifiant et email souhaite par utilisateur sont deja utilise"
        def result = userService.signUpUser(userTest)

        then: "le compte ne peut pas etre cree"
        result.succeed == "false"

    }

}
