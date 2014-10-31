package sharesport

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(User userInstance) {
        respond userInstance
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new User(params)
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'create'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(User userInstance) {
        respond userInstance
    }

    @Secured(['ROLE_ADMIN'])
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userService.saveUser(userInstance)
        flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Utilisateur \""+userInstance.username+"\" est modifié"
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def delete(User userInstance) {

        if (userInstance == null) {
            notFound()
            return
        }

        userInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def signUp (){
        User user = new User()
        user.username = params.username
        user.email = params.email
        user.password = params.password
        def result = userService.signUpUser(user)
        render(contentType: 'text/json', encoding: "UTF-8") {
            ['succeed': result.succeed, 'emailError' : result.emailError, 'loginError':  result.loginError]
        }
    }

    def login() {
        Boolean result = userService.login(params)
        String urlToRedirect = ""
        if(result){
            urlToRedirect = "user/index"
        }

        render(contentType: 'text/json', encoding: "UTF-8") {['succeed': result.toString(), 'url': urlToRedirect] }
    }

    def logout() {
        Boolean result = userService.logout()
        String urlToRedirect = ""
        if(result)
        {
            redirect(uri:'/')
        }

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
