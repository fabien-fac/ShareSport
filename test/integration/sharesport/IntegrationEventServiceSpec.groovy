package sharesport

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by fabien on 14/11/14.
 */
class IntegrationEventServiceSpec extends Specification {

    Sport rugby, cyclisme
    User user1, user2
    Event event1, event2
    EventService eventService

    def setup() {

        /* Création d'users */
        user1 = new User(username: 'totototo', enabled: true, password: 'adminadmin', email: "toto@toto.fr").save(flush: true)
        user2 = new User(username: 'titititi', enabled: true, password: 'adminadmin', email: "titi@titi.fr").save(flush: true)

        /* Création de timelines */
        def timelineTournoiVInations = new Timeline(dateCreated: new Date()).save(flush: true)
        def timelineTourDeFrance = new Timeline(dateCreated: new Date()).save(flush: true)

        /* Création de sports */
        rugby = new Sport(name: "Rugby").save(flush: true)
        cyclisme = new Sport(name: "Cyclisme").save(flush: true)

        /* Création d'events */
        event1 = new Event(sport: rugby, timeline: timelineTournoiVInations, begin_date: new Date(), titre: "Tournoi des VI nations", auteur: user1).save(flush: true)
        event2 = new Event(sport: cyclisme, timeline: timelineTourDeFrance, begin_date: new Date(), titre: "Tour de France", auteur: user2).save(flush: true)
    }

    @Unroll
    void "test de recuperation d event en fonction de criteria"() {

        given: "On reçoit des parametres"
        Map params = new HashMap()
        params["titre"] = aTitre
        params["sport"] = aSport
        params["auteur"] = aAuteur

        when: "on lance une recherche"
        def res = eventService.serviceGetEvents(params)

        then: "on doit obtenir les résultats attendus"
        res.eventInstanceCount == aSize

        where:
        aTitre    | aSport | aAuteur | aSize
        ""        | ""     | ""      | 2
        "tournoi" | ""     | ""      | 1
        ""        | "cycl" | ""      | 1
        "machin"  | ""     | ""      | 0
        "tour"    | "cycl" | ""      | 1
        "tour"    | "cycl" | "machi" | 0

    }
}
