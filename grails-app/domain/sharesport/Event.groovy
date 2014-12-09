package sharesport

class Event {

    Sport sport
    Date begin_date
    String titre
    User auteur
    Timeline timeline
    static hasMany = [hashtags:Hashtag]


    static constraints = {
        titre blank: false
    }

    static mapping = {
        autoTimestamp true
    }
}
