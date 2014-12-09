package sharesport

import grails.web.JSONBuilder

class Message {

    String content
    Date date = new Date()
    User editor
    Timeline timeline

    static constraints = {
        content blank: false
    }

    static mapping = {
        content type: 'text'
    }

    def getJson() {

        JSONBuilder json = new JSONBuilder();
        def res = json.build {
            mId = id
            mMessage = content
            mDate = date
            mAuteur = editor.username
        }

        return res
    }

    def beforeInsert(){
        content = content.encodeAsHTML();
    }
}
