package sharesport

class Hashtag {

    String label

    static constraints = {
        label blank: false
        label minSize: 3
    }

    def beforeInsert() {
        cleanLabel()
    }

    def beforeUpdate() {
        cleanLabel()
    }

    private void cleanLabel() {
        label = StringUtility.removeAccents(label)
        label = StringUtility.removeSpecialChars(label)
        label = "#"+label
    }
}
