package sharesport

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Event)
@Mock([User,Sport,Timeline])
class EventSpec extends Specification {

    Event event

    def setup() {
        event = new Event()
    }

    def cleanup() {
    }

    @Unroll
    void "creation d'un event valide : #aTitre"() {

        given: "pour un event valide"
        event.titre = aTitre
        event.auteur = Mock(User)
        event.begin_date = new Date()
        event.sport = Mock(Sport)
        event.timeline = Mock(Timeline)

        when: "on test de valider l'event"
        def res = event.validate()

        then: "le résultat doit être valide"
        res == true

        where:
        aTitre   | _
        "event1" | _
    }

    @Unroll
    void "creation d'un event non valide : #aTitre"() {

        given: "pour un event non valide"
        event.titre = aTitre
        event.auteur = Mock(User)
        event.begin_date = new Date()
        event.sport = Mock(Sport)
        event.timeline = Mock(Timeline)

        when: "on test de valider l'event"
        def res = event.validate()

        then: "le résultat ne doit pas être valide"
        res == false

        where:
        aTitre   | _
        "" | _
        null | _
    }


}
