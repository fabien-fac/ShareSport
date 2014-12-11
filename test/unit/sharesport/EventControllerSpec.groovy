package sharesport



import grails.test.mixin.*
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.*

@TestFor(EventController)
@Mock([Event, Sport, Timeline, User])
class EventControllerSpec extends Specification {

    EventService eventTestService = new EventService()

    def setup() {
        eventTestService.transactionManager = Mock(PlatformTransactionManager) {
            getTransaction(_) >> Mock(TransactionStatus)
        }
        controller.eventService = eventTestService
    }

    def populateValidParams(params) {
        assert params != null
        params["sport"] = Mock(Sport)
        params["timeline"] = Mock(Timeline)
        params["begin_date"] = new Date()
        params["titre"] = 'GP F1 Abu Dhabi'
        params["auteur"] = Mock(User)
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.eventInstanceList
        model.eventInstanceCount == null
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        model.eventInstance!= null
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == 404

        when:"A domain instance is passed to the show action"
        populateValidParams(params)
        def event = new Event(params)
        controller.show(event)

        then:"A model is populated containing the domain instance"
        model.eventInstance == event
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404

        when:"A domain instance is passed to the edit action"
        populateValidParams(params)
        def event = new Event(params)
        controller.edit(event)

        then:"A model is populated containing the domain instance"
        model.eventInstance == event
    }


}
