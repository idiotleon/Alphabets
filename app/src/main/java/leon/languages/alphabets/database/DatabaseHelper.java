package leon.languages.alphabets.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import leon.languages.alphabets.helper.GeneralHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String LOG_TAG = DatabaseHelper.class.getSimpleName();

    private static String DATABASE_NAME = "language_info";
    private static int VERSION = 1;

    public static String ARABIC_ALPHABET_TABLE_NAME = "arabic_alphabet_table";
    public static String ARABIC_ALPHABET_ID = "arabic_alphabet_id";
    public static String ARABIC_ALPHABET_LETTER = "arabic_alphabet_letter";
    public static String ARABIC_ALPHABET_ADDED_TIMES = "arabic_alphabet_added_times";

    public static String GERMAN_ALPHABET_TABLE_NAME = "german_alphabet_table";
    public static String GERMAN_ALPHABET_ID = "german_alpahbet_id";
    public static String GERMAN_ALPHABET_LETTER = "german_alpahbet_letter";
    public static String GERMAN_ALPHABET_ADDED_TIMES = "german_alpahbet_added_times";

    public static String ENGLISH_ALPHABET_TABLE_NAME = "english_alphabet_table";
    public static String ENGLISH_ALPHABET_ID = "english_alphabet_id";
    public static String ENGLISH_ALPHABET_LETTER = "english_alphabet_letter";
    public static String ENGLISH_ALPHABET_ADDED_TIMES = "english_alphabet_added_times";

    public static String SPANISH_ALPHABET_TABLE_NAME = "spanish_alphabet_table";
    public static String SPANISH_ALPHABET_ID = "spanish_alphabet_id";
    public static String SPANISH_ALPHABET_LETTER = "spanish_alphabet_letter";
    public static String SPANISH_ALPHABET_ADDED_TIMES = "spanish_alphabet_added_times";

    public static String FRENCH_ALPHABET_TABLE_NAME = "french_alphabet_table";
    public static String FRENCH_ALPHABET_ID = "french_alphabet_id";
    public static String FRENCH_ALPHABET_LETTER = "french_alphabet_letter";
    public static String FRENCH_ALPHABET_ADDED_TIMES = "french_alphabet_added_times";

    public static String HEBREW_ALPHABET_TABLE_NAME = "hebrew_alphabet_table";
    public static String HEBREW_ALPHABET_ID = "hebrew_alphabet_id";
    public static String HEBREW_ALPHABET_LETTER = "hebrew_alphabet_letter";
    public static String HEBREW_ALPHABET_ADDED_TIMES = "hebrew_alphabet_added_times";

    public static String GREEK_ALPHABET_TABLE_NAME = "greek_alphabet_table";
    public static String GREEK_ALPHABET_ID = "greek_alphabet_id";
    public static String GREEK_ALPHABET_LETTER = "greek_alphabet_letter";
    public static String GREEK_ALPHABET_ADDED_TIMES = "greek_alphabet_added_times";

    public static String KOREAN_ALPHABET_TABLE_NAME = "korean_alphabet_table";
    public static String KOREAN_ALPHABET_ID = "korean_alphabet_id";
    public static String KOREAN_ALPHABET_LETTER = "korean_alphabet_letter";
    public static String KOREAN_ALPHABET_ADDED_TIMES = "korean_alphabet_added_times";

    public static String HINDI_ALPHABET_TABLE_NAME = "hindi_alphabet_table";
    public static String HINDI_ALPHABET_ID = "hindi_alphabet_id";
    public static String HINDI_ALPHABET_LETTER = "hindi_alphabet_letter";
    public static String HINDI_ALPHABET_ADDED_TIMES = "hindi_alphabet_added_times";

    public static String JAPANESE_ALPHABET_TABLE_NAME = "japanese_alphabet_table";
    public static String JAPANESE_ALPHABET_ID = "japanese_alphabet_id";
    public static String JAPANESE_ALPHABET_LETTER = "japanese_alphabet_letter";
    public static String JAPANESE_ALPHABET_ADDED_TIMES = "japanese_alphabet_added_times";

    public static String RUSSIAN_ALPHABET_TABLE_NAME = "russian_alphabet_table";
    public static String RUSSIAN_ALPHABET_ID = "russian_alphabet_id";
    public static String RUSSIAN_ALPHABET_LETTER = "russian_alphabet_letter";
    public static String RUSSIAN_ALPHABET_ADDED_TIMES = "russian_alphabet_added_times";


    public static String CHINESE_ALPHABET_TABLE_NAME = "chinese_alphabet_table";
    public static String CHINESE_ALPHABET_ID = "chinese_alphabet_id";
    public static String CHINESE_ALPHABET_LETTER = "chinese_alphabet_letter";
    public static String CHINESE_ALPHABET_ADDED_TIMES = "chinese_alphabet_added_times";

    public static String[] ALPHABET_TABLE_NAME_ARRAY = {ARABIC_ALPHABET_TABLE_NAME, GERMAN_ALPHABET_TABLE_NAME,
            ENGLISH_ALPHABET_TABLE_NAME, SPANISH_ALPHABET_TABLE_NAME, FRENCH_ALPHABET_TABLE_NAME, HEBREW_ALPHABET_TABLE_NAME,
            GREEK_ALPHABET_TABLE_NAME, KOREAN_ALPHABET_TABLE_NAME, HINDI_ALPHABET_TABLE_NAME, JAPANESE_ALPHABET_TABLE_NAME,
            RUSSIAN_ALPHABET_TABLE_NAME};

    public static String[] ALPHABET_ID_COLUMN_ARRAY = {ARABIC_ALPHABET_ID, GERMAN_ALPHABET_ID,
            ENGLISH_ALPHABET_ID, SPANISH_ALPHABET_ID, FRENCH_ALPHABET_ID, HEBREW_ALPHABET_ID,
            GREEK_ALPHABET_ID, KOREAN_ALPHABET_ID, HINDI_ALPHABET_ID, JAPANESE_ALPHABET_ID,
            RUSSIAN_ALPHABET_ID};

    public static String[] ALPHABET_LETTER_COLUMN_ARRAY = {ARABIC_ALPHABET_LETTER, GERMAN_ALPHABET_LETTER,
            ENGLISH_ALPHABET_LETTER, SPANISH_ALPHABET_LETTER, FRENCH_ALPHABET_LETTER, HEBREW_ALPHABET_LETTER,
            GREEK_ALPHABET_LETTER, KOREAN_ALPHABET_LETTER, HINDI_ALPHABET_LETTER, JAPANESE_ALPHABET_LETTER,
            RUSSIAN_ALPHABET_LETTER};

    public static String[] ALPHABET_ADDED_TIMES_COLUMN_ARRAY = {ARABIC_ALPHABET_ADDED_TIMES, GERMAN_ALPHABET_ADDED_TIMES,
            ENGLISH_ALPHABET_ADDED_TIMES, SPANISH_ALPHABET_ADDED_TIMES, FRENCH_ALPHABET_ADDED_TIMES,
            HEBREW_ALPHABET_ADDED_TIMES, GREEK_ALPHABET_ADDED_TIMES, KOREAN_ALPHABET_ADDED_TIMES,
            HINDI_ALPHABET_ADDED_TIMES, JAPANESE_ALPHABET_ADDED_TIMES, RUSSIAN_ALPHABET_ADDED_TIMES};

    public static String[][] ALPHABET_LETTER_1 = {
            LanguageInfo.arabicAlphabetLeftToRight, LanguageInfo.germanAlphabetUppercase, LanguageInfo.englishAlphabetUppercase,
            LanguageInfo.spanishAlphabetUppercase, LanguageInfo.frenchAlphabetUppercase, LanguageInfo.hebrewAlphabetRightToLeft,
            LanguageInfo.greekAlphabetUppercase, LanguageInfo.koreanVowelLetters, LanguageInfo.hindiVowelLetters,
            LanguageInfo.hiragana, LanguageInfo.russianAlphabetUppercase
    };

    public static String[][] ALPHABET_LETTER_2 = {
            null, LanguageInfo.germanAlphabetLowercase, LanguageInfo.englishAlphabetLowercase,
            LanguageInfo.spanishAlphabetLowercase, LanguageInfo.frenchAlphabetLowercase, null,
            LanguageInfo.greekAlphabetLowercase, LanguageInfo.koreanConsonantLetters, LanguageInfo.hindiConsonantLetters,
            LanguageInfo.katagana, LanguageInfo.russianAlphabetLowercase
    };

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        for (int i = 0; i < ALPHABET_TABLE_NAME_ARRAY.length; i++) {
            createAndInitializeAlphabetTable(db,
                    ALPHABET_TABLE_NAME_ARRAY[i],
                    ALPHABET_ID_COLUMN_ARRAY[i],
                    ALPHABET_LETTER_COLUMN_ARRAY[i],
                    ALPHABET_ADDED_TIMES_COLUMN_ARRAY[i],
                    ALPHABET_LETTER_1[i],
                    ALPHABET_LETTER_2[i]);
        }

/*        createAndInitializeAlphabetTable(db, ARABIC_ALPHABET_TABLE_NAME,
                ARABIC_ALPHABET_ID,
                ARABIC_ALPHABET_LETTER,
                ARABIC_ALPHABET_ADDED_TIMES,
                LanguageInfo.arabicAlphabetLeftToRight,
                null);

        createAndInitializeAlphabetTable(db, GERMAN_ALPHABET_TABLE_NAME,
                GERMAN_ALPHABET_ID,
                GERMAN_ALPHABET_LETTER,
                GERMAN_ALPHABET_ADDED_TIMES,
                LanguageInfo.germanAlphabetUppercase,
                LanguageInfo.germanAlphabetLowercase);

        createAndInitializeAlphabetTable(db, ENGLISH_ALPHABET_TABLE_NAME,
                ENGLISH_ALPHABET_ID,
                ENGLISH_ALPHABET_LETTER,
                ENGLISH_ALPHABET_ADDED_TIMES,
                LanguageInfo.englishAlphabetUppercase,
                LanguageInfo.englishAlphabetLowercase);

        createAndInitializeAlphabetTable(db, SPANISH_ALPHABET_TABLE_NAME,
                SPANISH_ALPHABET_ID,
                SPANISH_ALPHABET_LETTER,
                SPANISH_ALPHABET_ADDED_TIMES,
                LanguageInfo.spanishAlphabetUppercase,
                LanguageInfo.spanishAlphabetLowercase);

        createAndInitializeAlphabetTable(db, FRENCH_ALPHABET_TABLE_NAME,
                FRENCH_ALPHABET_ID,
                FRENCH_ALPHABET_LETTER,
                FRENCH_ALPHABET_ADDED_TIMES,
                LanguageInfo.frenchAlphabetUppercase,
                LanguageInfo.frenchAlphabetLowercase);

        createAndInitializeAlphabetTable(db, HEBREW_ALPHABET_TABLE_NAME,
                HEBREW_ALPHABET_ID,
                HEBREW_ALPHABET_LETTER,
                HEBREW_ALPHABET_ADDED_TIMES,
                LanguageInfo.hebrewAlphabetRightToLeft,
                null);

        createAndInitializeAlphabetTable(db, GREEK_ALPHABET_TABLE_NAME,
                GREEK_ALPHABET_ID,
                GREEK_ALPHABET_LETTER,
                GREEK_ALPHABET_ADDED_TIMES,
                LanguageInfo.greekAlphabetUppercase,
                LanguageInfo.greekAlphabetLowercase);

        createAndInitializeAlphabetTable(db, KOREAN_ALPHABET_TABLE_NAME,
                KOREAN_ALPHABET_ID,
                KOREAN_ALPHABET_LETTER,
                KOREAN_ALPHABET_ADDED_TIMES,
                LanguageInfo.koreanVowelLetters,
                LanguageInfo.koreanConsonantLetters);

        createAndInitializeAlphabetTable(db, HINDI_ALPHABET_TABLE_NAME,
                HINDI_ALPHABET_ID,
                HINDI_ALPHABET_LETTER,
                HINDI_ALPHABET_ADDED_TIMES,
                LanguageInfo.hindiVowelLetters,
                LanguageInfo.hindiConsonantLetters);

        createAndInitializeAlphabetTable(db, JAPANESE_ALPHABET_TABLE_NAME,
                JAPANESE_ALPHABET_ID,
                JAPANESE_ALPHABET_LETTER,
                JAPANESE_ALPHABET_ADDED_TIMES,
                LanguageInfo.hiragana,
                LanguageInfo.katagana);

        createAndInitializeAlphabetTable(db, RUSSIAN_ALPHABET_TABLE_NAME,
                RUSSIAN_ALPHABET_ID,
                RUSSIAN_ALPHABET_LETTER,
                RUSSIAN_ALPHABET_ADDED_TIMES,
                LanguageInfo.russianAlphabetUppercase,
                LanguageInfo.russianAlphabetLowercase);*/
    }

    private void createAndInitializeAlphabetTable(SQLiteDatabase db,
                                                  String tableName,
                                                  String alphabetLetterId,
                                                  String alphabetLetterColumnName,
                                                  String alphabetAddedTimesColumnName,
                                                  String[] alphabetLettersPart1,
                                                  String[] alphabetLettersPart2) {
        String createAlphabetTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                alphabetLetterId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                alphabetLetterColumnName + " TEXT IDENTITY, " +
                alphabetAddedTimesColumnName + " INTEGER DEFAULT 0)";
        Log.v(LOG_TAG, "createAlphabetTableQuery, DatabaseHelper: " + createAlphabetTableQuery);
        db.execSQL(createAlphabetTableQuery);
        for (int i = 0; i < alphabetLettersPart1.length; i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(alphabetLetterColumnName, alphabetLettersPart1[i]);
            Log.v(LOG_TAG, "alphabetLettersPart1[i] for initialization of database: " + alphabetLettersPart1[i]);
            db.insert(tableName, null, contentValues);
        }
        if (alphabetLettersPart2 != null) {
            for (int i = 0; i < alphabetLettersPart2.length; i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(alphabetLetterColumnName, alphabetLettersPart2[i]);
                Log.v(LOG_TAG, "alphabetLettersPart2[i] for initialization of database: " + alphabetLettersPart1[2]);
                db.insert(tableName, null, contentValues);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        upgradeTables(db, ALPHABET_TABLE_NAME_ARRAY, oldVersion, newVersion);
    }

    private void upgradeTables(SQLiteDatabase db, String[] tableNameArray, int oldVersion, int newVersion) {
        for (int i = 0; i < tableNameArray.length; i++) {
            String upgradeQuery = "DROP TABLE IF EXISTS " + tableNameArray[i];
            Log.v(LOG_TAG, "upgradeQuery: " + upgradeQuery);
            Log.v(LOG_TAG, "Upgrade table" + tableNameArray[i] + " from " + oldVersion + " to " + newVersion);
            db.execSQL(upgradeQuery);
        }
    }

    public int getAlphabetLetterAddedTimes(String languageIdentifier, String letter) {
        int index = GeneralHelper.languageIdentifierToIndex(languageIdentifier);
        return queryAlphabetLetterAddedTimes(ALPHABET_TABLE_NAME_ARRAY[index],
                ALPHABET_LETTER_COLUMN_ARRAY[index],
                letter,
                ALPHABET_ADDED_TIMES_COLUMN_ARRAY[index]
        );
    }

    private int queryAlphabetLetterAddedTimes(String tableName, String letterColumnName, String letter, String alphabetAddedTimesColumnName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String queryAlphabetLetterAddedTimes =
                "SELECT * FROM " + tableName + " WHERE " + letterColumnName + " = '" + letter + "'";
        Log.v(LOG_TAG, "queryAlphabetLetterAddedTimes: " + queryAlphabetLetterAddedTimes);
        Cursor cursor = db.rawQuery(queryAlphabetLetterAddedTimes, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getInt(cursor.getColumnIndex(alphabetAddedTimesColumnName));
        } else return -1;
    }

    public boolean addToReviewNoteBook(String languageIdentifier, String letter) {
        if (languageIdentifier != null) {
            SQLiteDatabase db = this.getWritableDatabase();
            int addedTimes = getAlphabetLetterAddedTimes(languageIdentifier, letter);
            Log.v(LOG_TAG, "addedTimes, got from getAlphabetLetterAddedTimes(languageIdentifier, letter), addToReviewNoteBook(): " + addedTimes);
            int index = GeneralHelper.languageIdentifierToIndex(languageIdentifier);
            addedTimes++;
            ContentValues contentValues = new ContentValues();
            contentValues.put(ALPHABET_LETTER_COLUMN_ARRAY[index], letter);
            contentValues.put(ALPHABET_ADDED_TIMES_COLUMN_ARRAY[index], addedTimes);
            db.update(ALPHABET_TABLE_NAME_ARRAY[index], contentValues, ALPHABET_LETTER_COLUMN_ARRAY[index] + " = ?", new String[]{letter});
            return true;
        }
        return false;
    }

    public boolean removeFromReviewBook(String languageIdentifier, String letter) {
        if (languageIdentifier != null) {
            SQLiteDatabase db = this.getWritableDatabase();
            int index = GeneralHelper.languageIdentifierToIndex(languageIdentifier);
            int addedTimes = getAlphabetLetterAddedTimes(languageIdentifier, letter);
            if (index > 0) {
                if (addedTimes > 0) {
                    addedTimes--;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ALPHABET_LETTER_COLUMN_ARRAY[index], letter);
                    contentValues.put(ALPHABET_ADDED_TIMES_COLUMN_ARRAY[index], addedTimes);
                    db.update(ALPHABET_TABLE_NAME_ARRAY[index], contentValues, ALPHABET_LETTER_COLUMN_ARRAY[index] + " = ?", new String[]{letter});
                } else {
                    addedTimes = 0;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ALPHABET_LETTER_COLUMN_ARRAY[index], letter);
                    contentValues.put(ALPHABET_ADDED_TIMES_COLUMN_ARRAY[index], addedTimes);
                    db.update(ALPHABET_TABLE_NAME_ARRAY[index], contentValues, ALPHABET_LETTER_COLUMN_ARRAY[index] + " = ?", new String[]{letter});
                }
            }
            return true;
        }
        return false;
    }
}
