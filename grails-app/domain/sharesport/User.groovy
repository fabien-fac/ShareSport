package sharesport

class User {

    String email
    String password
    String login
    Integer score = 0
    Boolean isAdmin = false
    Boolean isActive = true

    static constraints = {
        email email: true
        email blank: false
        email unique: true
        password minSize: 8
        password maxSize: 50
        password blank: false
        password password: true
        login minSize: 4
        login maxSize: 20
        login blank: false
        login unique: true
        score min: 0
    }

    /*
    *   return true if the user is desactived
     */
    Boolean suppressUser ()
    {
        isActive = false
        !isActive
    }
}
