import sharesport.User

class BootStrap {

    def init = { servletContext ->
        if(!User.count()){
            new User(email: "abc@abc.com", password: "12345678",login: "abcde", score: 0).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
