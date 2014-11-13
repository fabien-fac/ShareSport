package sharesport

import grails.transaction.Transactional

@Transactional
class EventService {

    def serviceGetEvents(Map params) {

        def listeTotal = getEventWithCriteria(params)
        [ eventInstanceList:listeTotal, eventInstanceCount:listeTotal.totalCount ]
    }

    private def getEventWithCriteria(Map params) {
        String titreEvent = params.titre
        String sportTitreEvent = params.sport
        String hashtagEvent = params.hashtag
        String auteurEvent = params.auteur

        int offsetP
        if (!params.offset) {
            offsetP = 0
        } else {
            offsetP = Integer.valueOf(params.offset)
        }

        int maxRes
        if (!params.max) {
            maxRes = 0
        } else {
            maxRes = Integer.valueOf(params.max)
        }

        def criteria = Event.createCriteria()
        def results = criteria.list (offset: offsetP, max: maxRes){
            if(titreEvent){
                ilike('titre', "%$titreEvent%")
            }
            if(sportTitreEvent){
                sport{
                    ilike('name', "%$sportTitreEvent%")
                }
            }
            if(hashtagEvent){
                hashtags{
                    ilike('label', "%$hashtagEvent%")
                }
            }
            if(auteurEvent){
                auteur{
                    ilike('username', "%$auteurEvent%")
                }
            }
            if(params.sort && params.order){
                order(params.sort, params.order)
            }
        }

        results
    }
}