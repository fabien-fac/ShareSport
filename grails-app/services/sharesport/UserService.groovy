package sharesport

import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsHttpSession
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest
import org.springframework.web.context.request.RequestContextHolder

/**
 * Created by fabien on 23/10/14.
 */

@Transactional
class UserService {

    def inscriptionUser(Map params) {
        String result = ""
        String emailError = ""
        String loginError = ""

        User user = new User()
        user.login = params.login
        user.email = params.email
        user.password = params.password

        if(!user.validate()){
            if(User.findByLogin(params.login)){
                loginError = "Login déjà utilisé"
            }
            if(User.findByEmail(params.email)){
                emailError = "Email déjà utilisé"
            }

            result = "false"
        }
        else{
            user.save()
            result = "true"
        }

        ['succeed': result, 'emailError': emailError, 'loginError': loginError]
    }

    def login(Map params) {

        boolean loginSuccess = false
        String paramsEmail = params.email
        GrailsWebRequest request = RequestContextHolder.currentRequestAttributes()
        GrailsHttpSession session = request.session

        User user = User.findByEmail(paramsEmail)
        if (user != null) {
            if (user.password == params.password && user.isActive == true) {
                session["userId"] = user.id;
                loginSuccess = true
            }
        }

        loginSuccess
    }

    def updateUser(User user){
        user.save()
    }
}
