package sharesport

class Sport {
    String name

    static constraints = {
        name blank: false
        name unique: true
    }
}
