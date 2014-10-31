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

    SecureRoleService secureRoleService

    def signUpUser(User user) {

        String result = ""
        String emailError = ""
        String loginError = ""
        if(!user.validate()){

            if(User.findByUsername(user.username)){
                loginError = "Login déjà utilisé"
            }
            if(User.findByEmail(user.email)){
                emailError = "Email déjà utilisé"
            }

            result = "false"
        }
        else{
            User u = user.save()
            UserSecureRole.create u, secureRoleService.getRoleUser(), true
            result = "true"
        }

        ['succeed': result, 'emailError': emailError, 'loginError': loginError]
    }

    def saveUser(User user){
        user.save()
    }
}
