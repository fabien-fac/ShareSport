package sharesport


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class HashtagController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Hashtag.list(params), model: [hashtagInstanceCount: Hashtag.count()]
    }

    def show(Hashtag hashtagInstance) {
        respond hashtagInstance
    }

    def create() {
        respond new Hashtag(params)
    }

    @Transactional
    def save(Hashtag hashtagInstance) {
        if (hashtagInstance == null) {
            notFound()
            return
        }

        if (hashtagInstance.hasErrors()) {
            respond hashtagInstance.errors, view: 'create'
            return
        }

        hashtagInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hashtag.label', default: 'Hashtag'), hashtagInstance.id])
                redirect hashtagInstance
            }
            '*' { respond hashtagInstance, [status: CREATED] }
        }
    }

    def edit(Hashtag hashtagInstance) {
        respond hashtagInstance
    }

    @Transactional
    def update(Hashtag hashtagInstance) {
        if (hashtagInstance == null) {
            notFound()
            return
        }

        if (hashtagInstance.hasErrors()) {
            respond hashtagInstance.errors, view: 'edit'
            return
        }

        hashtagInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Hashtag.label', default: 'Hashtag'), hashtagInstance.id])
                redirect hashtagInstance
            }
            '*' { respond hashtagInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Hashtag hashtagInstance) {

        if (hashtagInstance == null) {
            notFound()
            return
        }

        hashtagInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Hashtag.label', default: 'Hashtag'), hashtagInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hashtag.label', default: 'Hashtag'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
