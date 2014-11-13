package sharesport

class Message {

    User editor
    String content
    Date date


    static belongsTo = [editor:User, timeline: Timeline]

    static constraints = {
        content blank: false
    }
}
