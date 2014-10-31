package sharesport



import spock.lang.*

/**
 *
 */
class IntegrationMessageSpec extends Specification {

    User editor
    Message message
    Date date

    def setup() {
    }

    def cleanup() {
    }

    void "test de la suppression en cascade"() {

        given: "un message avec un editeur"
        editor = new User(email: "test@test.fr", login: "test", password: "testtest")
        date = new Date()
        message = new Message(editor: editor, content: "voici un test", date: date)

        when: ""
    }
}
