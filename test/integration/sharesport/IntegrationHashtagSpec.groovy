package sharesport


import spock.lang.*

/**
 *
 */
class IntegrationHashtagSpec extends Specification {

    Hashtag hashtag

    def setup() {

    }

    def cleanup() {

    }

    void "test de proprete de texte de hashtag pendant sa creation"() {
        given: "texte avec des accents et caractères spéciaux"
        Event event = Event.findByTitre("Tournoi des VI nations")
        hashtag = new Hashtag(label: textDirty, event: event)

        when: "un hashtag est sauvegardé"
        Hashtag hastagSave = hashtag.save(flush: true)

        then: "le texte propre doit être sauvegardé"
        hastagSave.getLabel() == textClean

        where:
        textDirty           |   textClean
        "Vélo è &*()#%"     |   "#Veloe"

    }

    void "test de proprete de texte de hashtag pendant la mise a jour"() {
        given: "texte avec des accents et caractères spéciaux"
        Event event = Event.findByTitre("Tournoi des VI nations")
        hashtag = new Hashtag(label: "abcaaa", event: event)
        hashtag.save(flush: true)

        when: "un hashtag est mis à jour"
        hashtag.setLabel(textDirty)
        Hashtag hastagSave = hashtag.save(flush: true)

        then: "le texte propre doit être sauvegardé"
        hastagSave.getLabel() == textClean

        where:
        textDirty           |   textClean
        "Vélo è &*()#%"     |   "#Veloe"

    }
}
