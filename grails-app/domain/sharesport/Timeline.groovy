package sharesport

class Timeline {

    static hasMany = [messages:Message]

    Date dateCreated

    static constraints = {

    }

    static mapping = {
        autoTimestamp true
    }
}
