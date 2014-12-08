package sharesport

class Event {

    Sport sport
    Date begin_date
    String titre
    User auteur

    static hasMany = [hashtags:Hashtag, timelines: Timeline]


    static constraints = {
        titre blank: false
    }

    static mapping = {
        autoTimestamp true
    }
}
