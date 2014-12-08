package sharesport


import sharesport.User
import sharesport.Message
import spock.lang.*

/**
 *
 */
class IntegrationMessageSpec extends Specification {

    User editor
    Message message

    def setup() {
        editor = new User(username: "boby", password: "passpass1", email:"aa@aa.com").save(failOnError: true, flush: true)
        message = new Message(editor: editor, content: "test").save(failOnError: true, flush: true)
        editor.addToMessages(message).save(flush: true)
    }

    def cleanup() {
    }

    void "test de la suppression en cascade"() {
        when: "l'utilisateur est supprimé"
        editor.delete(failOnError: true, flush: true)

        then: "le message est supprimé de la base"
        Message.get(message.id) == null

        and: "l'utilisateur est supprimé aussi"
        User.get(editor.id) == null
    }
}
