import sharesport.SecureRole
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
    }
    def destroy = {
    }
}
