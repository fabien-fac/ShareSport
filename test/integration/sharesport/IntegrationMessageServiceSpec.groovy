package sharesport

import sharesport.User
import spock.lang.*

import java.sql.Time

/**
 *
 */
class IntegrationMessageServiceSpec extends Specification {

    MessageService messageService

    def setup() {
    }

    def cleanup() {
    }

    void "test de creation de message"() {
        given: "un evenement"
        User user = new User(username: 'totototo', enabled: true, password: 'adminadmin', email: "toto@toto.fr").save(flush: true)
        Sport cyclisme = new Sport(name: "Cyclisme").save(flush: true)
        def timelineTourDeFrance = new Timeline(dateCreated: new Date()).save(flush: true)
        Event event = new Event(sport: cyclisme, timeline: timelineTourDeFrance, begin_date: new Date(), titre: "Tournoi des VI nations", auteur: user)
        event.save(flush: true)

        when: "un message est créé"
        Message msg = new Message(editor: user, content: "abc", date: new Date())
        messageService.create(msg, event)
        Timeline timelineResult = Timeline.listOrderByDateCreated(max: 1, order: "desc").getAt(0)
        then: "message est sauvegardé avec un timeline et evenement"
        timelineResult.getMessages().contains(msg)
    }
}
