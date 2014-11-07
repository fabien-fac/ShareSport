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
}
