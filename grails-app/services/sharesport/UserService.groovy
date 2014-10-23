package sharesport

import grails.transaction.Transactional

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

        User user = User.findByEmail(paramsEmail)
        if(user != null){
            if(user.password == params.password && user.isActive == true){
                loginSuccess = true
            }
        }

        loginSuccess
    }
}
