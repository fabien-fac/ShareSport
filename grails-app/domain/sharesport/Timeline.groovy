package sharesport

class Timeline {

    static hasMany = [messages:Message]

    static constraints = {

    }

    static mapping = {
        autoTimestamp true
    }
}
