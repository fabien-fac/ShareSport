package sharesport

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Timeline)
class TimelineSpec extends Specification {

    Timeline timeline

    def setup() {
        timeline = new Timeline()
    }

    def cleanup() {
    }
/*
    void "test la date de creation de timeline"() {
        when: "timeline est créé"
        timeline = new Timeline()

        Date now = new Date()
        Date createdDateTimeline = timeline.dateCreated

        then: "date de création de timeline est la meme que la date courante"
        createdDateTimeline.getTimeString() == now.getTimeString()
    }
    */

}
