package sharesport

class Message {

    String content
    Date date = new Date()


    static belongsTo = [editor:User, timeline: Timeline]

    static constraints = {
        content blank: false
    }
}
