import sharesport.Event
import sharesport.SecureRole
import sharesport.Sport
import sharesport.Timeline
import sharesport.User
import sharesport.UserSecureRole

class BootStrap {

    def init = { servletContext ->
        /*
        if(!User.count()){
            new User(email: "abc@abc.com", password: "12345678",login: "abcde", score: 0).save(failOnError: true)
        }
        */
        def adminRole = new SecureRole(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new SecureRole(authority: 'ROLE_USER').save(flush: true)

        def testUser = new User(username: 'admin', enabled: true, password: 'adminadmin', email: "admin@admin.fr")
        testUser.validate()
        println(testUser.errors)
        testUser.save(flush: true)

        UserSecureRole.create testUser, adminRole, true

        assert User.count() == 1
        assert SecureRole.count() == 2
        assert UserSecureRole.count() == 1

        /* Création de timelines */
        def timelineTournoiVInations = new Timeline(dateCreated: new Date()).save(flush: true)
        def timelineTourDeFrance = new Timeline(dateCreated: new Date()).save(flush: true)

        /* Création de sports */
        def rugby = new Sport(name: "Rugby").save(flush: true)
        def cyclisme = new Sport(name: "Cyclisme").save(flush: true)

        /* Création d'events */
        def tournoiVInations = new Event(sport: rugby, timeline: timelineTournoiVInations, begin_date: new Date(), titre: "Tournoi des VI nations", auteur: testUser).save(flush: true)
        def tourDeFrance = new Event(sport: cyclisme, timeline: timelineTourDeFrance, begin_date: new Date(), titre: "Tour de France", auteur: testUser).save(flush: true)


    }
    def destroy = {
    }
}
