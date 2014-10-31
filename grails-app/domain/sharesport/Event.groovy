package sharesport

class Event {

    Sport sport
    Timeline timeline
    Date begin_date

    static hasMany = [hastags:Hashtag]


    static constraints = {
    }

    static mapping = {
        autoTimestamp true
    }
}
