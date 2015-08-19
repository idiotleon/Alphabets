package leon.languages.alphabets.learning;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import leon.languages.alphabets.R;
import leon.languages.alphabets.database.LanguageInfo;
import leon.languages.alphabets.fragment.DisplayFragment;
import leon.languages.alphabets.others.CommonConstants;

public class AlphabetLearningActivity extends AppCompatActivity {

    private static final String LOG_TAG = AlphabetLearningActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabetlearningactivity);

        String languageIdentifier = getIntent().getStringExtra(CommonConstants.LANGUAGE_IDENTIFER);
        if (languageIdentifier != "") {
            displayFragment(languageIdentifier);
        } else {
            Log.e(LOG_TAG, "languageIdentifier is null - Line 22");
        }
    }

    private void displayFragment(String languageIdentifier) {
        DisplayFragment displayFragment1 = new DisplayFragment();
        Bundle args1 = new Bundle();
        DisplayFragment displayFragment2 = new DisplayFragment();
        Bundle args2 = new Bundle();
        switch (languageIdentifier) {
            case "Arabic":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.arabicAlphabetWithDifferentForms);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Arabic Alphabet Letters");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, null);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, null);
                break;
            case "English":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.englishAlphabetUppercase);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "English Alphabet Uppercase");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.englishAlphabetLowercase);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "English Alphabet Lowercase");
                break;
            case "French":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.frenchAlphabetUppercase);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "French Alphabet Uppercase");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.frenchAlphabetUppercase);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "French Alphabet Lowercase");
                break;
            case "German":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.germanAlphabetUppercase);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Arabic Alphabet Uppercase");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.germanAlphabetLowercase);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Arabic Alphabet Lowercase");
                break;
            case "Greek":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.greekAlphabetUppercase);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Greek Alphabet Uppercase");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.greekAlphabetLowercase);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Greek Alphabet Lowercase");
                break;
            case "Hindi":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.hindiVowelLetters);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Hindi Vowel Letters");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.hindiConsonantLetters);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Hindi Consonant Letters");
                break;
            case "Hebrew":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.hebrewAlphabetRightToLeft);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Hebrew Alphabet Letters");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, null);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, null);
//                introduction = "  The Hebrew alphabet has 22 letters. " +
//                        "It does not have case, but five letters have different forms when used at the end of a word. " +
//                        "Hebrew is written from right to left. There have been two script forms in use; the original old Hebrew script is known as the " +
//                        "paleo-Hebrew script (which has been largely preserved, in an altered form, in the Samaritan script), while the present form of the Hebrew alphabet is a stylized form of the Aramaic script. " +
//                        "Various (in current terms, fonts) of representation of the letters exist.";
//                detailedInfoUrl = "https://en.wikipedia.org/wiki/Hebrew_alphabet";
                break;
            case "Japanese":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.hiragana);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, LanguageInfo.japaneseAudioUrl);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Japanese Hiragana");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.katagana);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, LanguageInfo.japaneseAudioUrl);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Japanese Katagana");
                break;
            case "Korean":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.koreanVowelLetters);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, LanguageInfo.koreanVowelsAudioUrls);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Korean Vowel Letters");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.koreanConsonantLetters);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, LanguageInfo.koreanConsonantsAudioUrls);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Korean Consonant Letters");
//                introduction = "  The Korean alphabet contains 14 consonant letters and 10 vowel letters.  " +
//                        "Instead of being written sequentially like the letters of the Latin alphabet, " +
//                        "letters are grouped into blocks, such as \"한(han)\". Each syllabic block consists of two to six letters, " +
//                        "including at least one consonant and one vowel. " +
//                        "These blocks are then arranged horizontally from left to right or vertically from top to bottom.";
//                detailedInfoUrl = "https://en.wikipedia.org/wiki/Hangul";
                break;
            case "Russian":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.russianAlphabetLowercase);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Russian Alphabet Uppercase");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.russianConsonantLetters);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Russian Alphabet Lowercase");
                break;
            case "Spanish":
                args1.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.spanishAlphabetUppercase);
                args1.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args1.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Spanish Alphabet Uppercase");
                args2.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.spanishAlphabetLowercase);
                args2.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                args2.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Spanish Alphabet Lowercase");
                break;
        }

        displayFragment1.setArguments(args1);
        displayFragment2.setArguments(args2);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container1, displayFragment1);
        fragmentTransaction.replace(R.id.container2, displayFragment2);
        fragmentTransaction.commit();
    }
}
