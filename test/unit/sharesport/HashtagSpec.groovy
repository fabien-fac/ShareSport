package sharesport

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Hashtag)
class HashtagSpec extends Specification {

    Hashtag hashtag

    def setup() {
        hashtag = new Hashtag()
    }

    def cleanup() {
    }

    @Unroll
    void "test contrainte hashtag valide : aLabel"() {

        given: "pour un hashtag donné"
        hashtag.label = aLabel

        when: "sauvegarde du hashtag dans la base de données"
        def res = hashtag.validate()

        then: "la validation doit fonctionner"
        res == true
        !hashtag.hasErrors()

        where:
        aLabel    | _
        "test"    | _
        "hashtag" | _
        "test123" | _
        "1234"    | _
        "TEST"    | _
        "T2r3"    | _
    }

    @Unroll
    void "test contrainte hashtag non valide : #aLabel"() {

        given: "pour un hashtag donné"
        hashtag.label = aLabel

        when: "sauvegarde du hashtag dans la base de données"
        def res = hashtag.validate()

        then: "la validation ne doit pas fonctionner"
        res == false
        hashtag.hasErrors()

        where:
        aLabel | _
        ""     | _
        "1"    | _
        "un"   | _
        null   | _
        "#"    | _
        "''"   | _
    }

    @Unroll
    void "test supression accent : #aLabel"() {

        given: "pour un hashtag donné"
        hashtag.label = aLabel

        when: "sauvegarde du hashtag dans la base de données"
        hashtag.save(flush: true)

        then: "les accents doivent être supprimés"
        hashtag.label == "#"+aResult

        where:
        aLabel | aResult
        "éléphant"     | "elephant"
        "étanche"    | "etanche"
        "maison"   | "maison"
        "éèêëùüûôöà"   | "eeeeuuuooa"
    }

    @Unroll
    void "test supression caracteres spéciaux : #aLabel"() {

        given: "pour un hashtag donné"
        hashtag.label = aLabel

        when: "sauvegarde du hashtag dans la base de données"
        hashtag.save(flush: true)

        then: "les accents doivent être supprimés"
        hashtag.label == "#"+aResult

        where:
        aLabel | aResult
        "_éléphant"     | "elephant"
        "étanche."    | "etanche"
        "mai-@son"   | "maison"
        "éèêëùü#ûôöà"   | "eeeeuuuooa"
    }
}
