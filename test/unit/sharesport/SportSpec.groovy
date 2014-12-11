package sharesport

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Sport)
class SportSpec extends Specification {

    Sport sport

    def setup() {
        sport = new Sport()
    }

    def cleanup() {
    }

    @Unroll
    void "test contrainte nom de sport valide : #aName"() {

        given: "Un nom de sport"
        sport.name = aName

        when: "Sauvegarde du nom dans la base de données"
        def res = sport.validate()

        then: "La validation doit fonctionner"
        res == true
        !sport.hasErrors()

        where:
        aName        | _
        "Vélo"       | _
        "Basket"     | _
        "Bask3t"     | _
        "Rugby15"    | _
        "50Papillon" | _
    }

    @Unroll
    void "test contrainte nom de sport non valide : #aName"() {

        given: "Un nom de sport"
        sport.name = aName

        when: "Sauvegarde du nom dans la base de données"
        def res = sport.validate()

        then: "La validation doit fonctionner"
        res == false
        sport.hasErrors()

        where:
        aName  | _
        null   | _
        "    " | _
        ""     | _
    }
}
