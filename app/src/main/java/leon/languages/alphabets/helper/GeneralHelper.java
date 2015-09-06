package leon.languages.alphabets.helper;

import android.content.Context;
import android.util.Log;

import leon.languages.alphabets.database.DatabaseHelper;

/**
 * Created by Leon on 8/24/2015.
 */
public class GeneralHelper {

    private static String LOG_TAG = GeneralHelper.class.getSimpleName();

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

/*    public static void addToReviewBook(Context context, String languageIdentifier, String alphabetLetter) {
        Log.v(LOG_TAG, "addToReviewBook(), GeneralHelper executed.");
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        dbHelper.addToReviewNoteBook(languageIdentifier, alphabetLetter);
    }

    public static void removeFromReviewBook(Context context, String languageIdentifier, String alphabetLetter){
        Log.v(LOG_TAG, "removeFromReviewBook(), GeneralHelper executed.");
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        dbHelper.removeFromReviewBook(languageIdentifier, alphabetLetter);
    }*/
}
