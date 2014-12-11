package sharesport

import grails.converters.JSON
import grails.test.mixin.TestFor
import grails.web.JSONBuilder
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Message)
class MessageSpec extends Specification {

    Message message

    def setup() {
    }

    def cleanup() {
    }

    void "test des contraintes pour un message valide"() {

        given: "pour un message valide"
        User editor = Mock(User)
        Timeline timeline = Mock(Timeline)
        message = new Message(editor: editor, date: new Date(), content: "test", timeline: timeline)

        when: "lors de la validation du message"
        def res = message.validate()

        then: "le message ne comporte pas d'erreurs"
        res == true
        !message.hasErrors()
    }

    @Unroll
    void "test des contraintes pour un message non valide [#anEditor, #aContent]"() {

        given: "pour un message non valide"
        message = new Message(editor: anEditor, date: new Date(), content: aContent, timeline: aTimeline)

        when: "lors de la validation du message"
        def res = message.validate()

        then: "le message ne comporte pas d'erreurs"
        res == false
        message.hasErrors()

        where:

        anEditor | aContent | aTimeline
        null     | ""       | null
        null     | null     | null
    }

    void "test de recuperation de json"() {
        given: "pour un message non valide"
        def date = new Date()
        User editor = Mock(User){
            getUsername() >> "toto"
            getId() >> 1
        }
        JSONBuilder json = new JSONBuilder();
        def res = json.build {
            mId = 1
            mMessage = "content"
            mDate = date
            mAuteur = "toto"
        }

        Timeline timeline = Mock(Timeline)
        message = new Message(editor: editor, date: date, content:"content", timeline: timeline)

        when: "on recupere le json de l'objet"
        def res2 = message.getJson()

        then: "on test le resultat"
        res == res
    }
}
