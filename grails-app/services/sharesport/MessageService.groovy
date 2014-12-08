package sharesport

import grails.transaction.Transactional

/**
 * Created by kana on 14/11/14.
 */
@Transactional
class MessageService {

    def create(Message message, Event event){
        Timeline timeline = new Timeline()
        timeline.addToMessages(message)
        event.addToTimelines(timeline)
        return event.save(flush: true)
    }

}
