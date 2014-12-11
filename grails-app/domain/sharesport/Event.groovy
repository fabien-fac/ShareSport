package sharesport

class Event {

    Sport sport
    Date begin_date
    String titre
    User auteur
    Timeline timeline
    def hashtags = []
    static hasMany = [hashtags:Hashtag]


    static constraints = {
        titre blank: false
        hashtags nullable: true
    }

    static mapping = {
        autoTimestamp true
    }
}
