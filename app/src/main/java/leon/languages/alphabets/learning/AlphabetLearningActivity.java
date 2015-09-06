package leon.languages.alphabets.learning;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import leon.languages.alphabets.R;
import leon.languages.alphabets.database.LanguageInfo;
import leon.languages.alphabets.leftdrawer.CustomDrawerListViewAdapter;
import leon.languages.alphabets.others.CommonConstants;

public class AlphabetLearningActivity extends FragmentActivity {

    private static final String LOG_TAG = AlphabetLearningActivity.class.getSimpleName();

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private String languageIdentifier;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabetlearningactivity);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_learning_activity);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_learning_activity);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new CustomDrawerListViewAdapter(getApplicationContext()));
        mDrawerList.setOnItemClickListener(new LearningDrawerItemClickListener());

        languageIdentifier = getIntent().getStringExtra(CommonConstants.LANGUAGE_IDENTIFER);
        if (languageIdentifier != "") {
            displayFragment(languageIdentifier, CommonConstants.ALPHABET_PART1_IDENTIFIER);
        } else {
            Log.e(LOG_TAG, "languageIdentifier is null - Line 22");
        }

    }

    private class LearningDrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            displayFragment(LanguageInfo.LANGUAGE_NAME_IDENTIFIERS[position], CommonConstants.ALPHABET_PART1_IDENTIFIER);
            mDrawerLayout.closeDrawers();
        }
    }

    private void displayFragment(String languageIdentifier, int identifier) {
        Bundle args = setFragmentArguments(languageIdentifier, identifier);
        if (args != null) {
            DisplayFragment displayFragment = new DisplayFragment();
            displayFragment.setArguments(args);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, displayFragment);
            fragmentTransaction.commit();
        }
    }

    private Bundle setFragmentArguments(String languageIdentifier, int identifier) {
        Bundle args = new Bundle();
        getActionBar().setTitle(languageIdentifier + " Alphabet");
        if (CommonConstants.ALPHABET_PART1_IDENTIFIER == identifier) {
            switch (languageIdentifier) {
                case "Arabic":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.arabicAlphabetWithDifferentForms);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Arabic Alphabet Letters");
                    getActionBar().setSubtitle("Different forms of Arabic Alphabet");
                    break;
                case "English":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.englishAlphabetUppercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "English Alphabet Uppercase");
                    getActionBar().setSubtitle("Uppercaset");
                    break;
                case "French":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.frenchAlphabetUppercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "French Alphabet Uppercase");
                    getActionBar().setSubtitle("Uppercaset");
                    break;
                case "German":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.germanAlphabetUppercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "German Alphabet Uppercase");
                    getActionBar().setSubtitle("Uppercaset");
                    break;
                case "Greek":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.greekAlphabetUppercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Greek Alphabet Uppercase");
                    getActionBar().setSubtitle("Uppercaset");
                    setBackgroundImage(R.mipmap.greekalphabetheader, R.mipmap.greecebackgroundimage, 50);
                    break;
                case "Hindi":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.hindiVowelLetters);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Hindi Vowel Letters");
                    getActionBar().setSubtitle("Hindi Vowel Letters");
                    break;
                case "Hebrew":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.hebrewAlphabetRightToLeft);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Hebrew Alphabet Letters");
                    getActionBar().setSubtitle("Hebrew Vowel Letters");
//                introduction = "  The Hebrew alphabet has 22 letters. " +
//                        "It does not have case, but five letters have different forms when used at the end of a word. " +
//                        "Hebrew is written from right to left. There have been two script forms in use; the original old Hebrew script is known as the " +
//                        "paleo-Hebrew script (which has been largely preserved, in an altered form, in the Samaritan script), while the present form of the Hebrew alphabet is a stylized form of the Aramaic script. " +
//                        "Various (in current terms, fonts) of representation of the letters exist.";
//                detailedInfoUrl = "https://en.wikipedia.org/wiki/Hebrew_alphabet";
                    break;
                case "Japanese":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.hiragana);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, LanguageInfo.japaneseAudioUrl);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Japanese Hiragana");
                    getActionBar().setSubtitle("Hiragana");
                    break;
                case "Korean":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.koreanVowelLetters);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, LanguageInfo.koreanVowelsAudioUrls);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Korean Vowel Letters");
                    getActionBar().setSubtitle("Korean Vowel Letters");
//                introduction = "  The Korean alphabet contains 14 consonant letters and 10 vowel letters.  " +
//                        "Instead of being written sequentially like the letters of the Latin alphabet, " +
//                        "letters are grouped into blocks, such as \"한(han)\". Each syllabic block consists of two to six letters, " +
//                        "including at least one consonant and one vowel. " +
//                        "These blocks are then arranged horizontally from left to right or vertically from top to bottom.";
//                detailedInfoUrl = "https://en.wikipedia.org/wiki/Hangul";
                    break;
                case "Russian":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.russianAlphabetLowercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Russian Alphabet Uppercase");
                    getActionBar().setSubtitle("Uppercaset");
                    break;
                case "Spanish":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.spanishAlphabetUppercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Spanish Alphabet Uppercase");
                    getActionBar().setSubtitle("Uppercaset");
                    break;
            }
        } else if (CommonConstants.ALPHABET_PART2_IDENTIFIER == identifier) {
            switch (languageIdentifier) {
                case "Arabic":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, null);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, null);
                    break;
                case "English":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.englishAlphabetLowercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "English Alphabet Lowercase");
                    getActionBar().setSubtitle("Lowercase");
                    break;
                case "French":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.frenchAlphabetLowercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "French Alphabet Lowercase");
                    getActionBar().setSubtitle("Lowercase");
                    break;
                case "German":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.germanAlphabetLowercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "German Alphabet Lowercase");
                    getActionBar().setSubtitle("Lowercase");
                    break;
                case "Greek":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.greekAlphabetLowercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Greek Alphabet Lowercase");
                    setBackgroundImage(R.mipmap.greekalphabetheader, R.mipmap.greecebackgroundimage, 50);
                    getActionBar().setSubtitle("Lowercase");
                    break;
                case "Hindi":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.hindiConsonantLetters);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Hindi Consonant Letters");
                    getActionBar().setSubtitle("Hindi Consonant Letters");
                    break;
                case "Hebrew":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, null);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, null);
                    getActionBar().setSubtitle("Hebrew Consonant Letters");
//                introduction = "  The Hebrew alphabet has 22 letters. " +
//                        "It does not have case, but five letters have different forms when used at the end of a word. " +
//                        "Hebrew is written from right to left. There have been two script forms in use; the original old Hebrew script is known as the " +
//                        "paleo-Hebrew script (which has been largely preserved, in an altered form, in the Samaritan script), while the present form of the Hebrew alphabet is a stylized form of the Aramaic script. " +
//                        "Various (in current terms, fonts) of representation of the letters exist.";
//                detailedInfoUrl = "https://en.wikipedia.org/wiki/Hebrew_alphabet";
                    break;
                case "Japanese":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.katagana);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, LanguageInfo.japaneseAudioUrl);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Japanese Katagana");
                    getActionBar().setSubtitle("Katagana");
                    break;
                case "Korean":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.koreanConsonantLetters);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, LanguageInfo.koreanConsonantsAudioUrls);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Korean Consonant Letters");
                    getActionBar().setSubtitle("Korean Consonant Letters");
//                introduction = "  The Korean alphabet contains 14 consonant letters and 10 vowel letters.  " +
//                        "Instead of being written sequentially like the letters of the Latin alphabet, " +
//                        "letters are grouped into blocks, such as \"한(han)\". Each syllabic block consists of two to six letters, " +
//                        "including at least one consonant and one vowel. " +
//                        "These blocks are then arranged horizontally from left to right or vertically from top to bottom.";
//                detailedInfoUrl = "https://en.wikipedia.org/wiki/Hangul";
                    break;
                case "Russian":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.russianConsonantLetters);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Russian Alphabet Lowercase");
                    getActionBar().setSubtitle("Lowercase");
                    break;
                case "Spanish":
                    args.putStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER, LanguageInfo.spanishAlphabetLowercase);
                    args.putIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER, null);
                    args.putString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER, "Spanish Alphabet Lowercase");
                    getActionBar().setSubtitle("Lowercase");
                    break;
            }
        }
        if (args.getStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER) != null) {
            return args;
        } else {
            return null;
        }
    }

    private void setBackgroundImage(int headerImageId, int backgroundImageId, int alphabDegree) {
        getActionBar().setBackgroundDrawable(getResources().getDrawable(headerImageId));
        Drawable background = getResources().getDrawable(backgroundImageId);
        background.setAlpha(alphabDegree);
        mDrawerLayout.setBackground(background);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_learning, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alphabet_part1:
                displayFragment(languageIdentifier, CommonConstants.ALPHABET_PART1_IDENTIFIER);
                break;
            case R.id.alphabet_part2:
                displayFragment(languageIdentifier, CommonConstants.ALPHABET_PART2_IDENTIFIER);
                break;
//            case R.id.alphabet_part3:
//                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
