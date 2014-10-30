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

    def signUpUser(User user) {
        String result = ""
        String emailError = ""
        String loginError = ""
        if(!user.validate()){

            if(User.findByLogin(user.login)){
                loginError = "Login déjà utilisé"
            }
            if(User.findByEmail(user.email)){
                emailError = "Email déjà utilisé"
            }

            result = "false"
        }
        else{
            saveUser(user)
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

    def logout() {

        boolean logoutSuccess = false
        GrailsWebRequest request = RequestContextHolder.currentRequestAttributes()
        GrailsHttpSession session = request.session

        long userId = session["userId"]

        if (userId != null) {
            session.invalidate()
            logoutSuccess = true
        }
        logoutSuccess
    }

    def saveUser(User user){
        user.save()
    }
}
