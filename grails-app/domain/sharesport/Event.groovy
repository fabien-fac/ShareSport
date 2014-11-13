package sharesport

class Event {

    Sport sport
    Timeline timeline
    Date begin_date
    String titre
    User auteur

    static hasMany = [hashtags:Hashtag]


    static constraints = {
        titre blank: false
    }

    static mapping = {
        autoTimestamp true
    }
}
