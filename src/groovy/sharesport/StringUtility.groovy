package sharesport

import java.text.Normalizer
import java.text.Normalizer.Form

/**
 * Created by fabien on 30/10/14.
 */

class StringUtility {

    static String removeAccents(String stringWithAccents){
        Normalizer
                .normalize(stringWithAccents, Form.NFD)
                .replaceAll(/\p{InCombiningDiacriticalMarks}+/, '')
    }

    static String removeSpecialChars(String stringWithSpecialChars){
        stringWithSpecialChars.replaceAll("[^a-zA-Z0-9]+",'')
    }
}