package sharesport

import sharesport.User

/**
 * Created by fabien on 23/10/14.
 */


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

    def update(User user){
        user.password = user.password.encodeAsMD5()
        user.save()
    }
}
