package sharesport


import spock.lang.*

/**
 *
 */
class IntegrationTimelineSpec extends Specification {

    Timeline timeline

    def setup() {
        timeline = new Timeline()
    }

    def cleanup() {
    }

    void "test d'insertion des messages a timeline"() {
        given: "des messages"
        Message msg1 = new Message()
        Message msg2 = new Message()

        when: "un utilisateur crée des messages sur le timeline"
        timeline.addToMessages(msg1)
        timeline.addToMessages(msg2)

        then: "timeline contient ces messages"
        timeline.getMessages().contains(msg1)
        timeline.getMessages().contains(msg2)
    }

    void "test de suppression de timeline"(){
        given: "des messages dans timeline"
        User user = User.findByUsername("admin")
        Message msg1 = new Message(editor: user, content: "abc", date: new Date())
        Message msg2 = new Message(editor: user, content: "abc", date: new Date())
        timeline.addToMessages(msg1)
        timeline.addToMessages(msg2)
        timeline.save(flush: true)

        when: "un utilisateur supprimme le timeline"
        timeline.delete(flush: true)

        then: "les messages dans le timeline sont supprimmé"
        Message.findByContent("abc") == null

    }
}
