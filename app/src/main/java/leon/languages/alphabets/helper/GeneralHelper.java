package leon.languages.alphabets.helper;

/**
 * Created by Leon on 8/24/2015.
 */
public class GeneralHelper {

    public static int languageIdentifierToIndex(String languageIdentifier) {
        int index = 0;
        switch (languageIdentifier) {
            case "Arabic":
                index = 0;
                break;
            case "German":
                index = 1;
                break;
            case "English":
                index = 2;
                break;
            case "Spanish":
                index = 3;
                break;
            case "French":
                index = 4;
                break;
            case "Hebrew":
                index = 5;
                break;
            case "Greek":
                index = 6;
                break;
            case "Korean":
                index = 7;
                break;
            case "Hindi":
                index = 8;
                break;
            case "Japanese":
                index = 9;
                break;
            case "Russian":
                index = 10;
                break;
        }
        return index;
    }
    
}
