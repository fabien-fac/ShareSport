package sharesport

import grails.web.JSONBuilder

class Message {

    User editor
    String content
    Date date


    static belongsTo = [editor:User, timeline: Timeline]

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
