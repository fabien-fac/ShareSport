package sharesport

class Message {

    User editor
    String content
    Date date

    static belongsTo = [editor:User]

    static constraints = {
        content blank: false
    }
}
