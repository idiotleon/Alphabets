package leon.languages.alphabets.obsolete;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import leon.languages.alphabets.others.CommonConstants;
import leon.languages.alphabets.database.LanguageInfo;
import leon.languages.alphabets.R;
import leon.languages.alphabets.gridview.CustomAlphabetLettersGridViewAdapter;
import leon.languages.alphabets.multimedia.PlayAudioService;

public class AlphabetPart1DisplayFragment extends Fragment {

    private static String LOG_TAG = AlphabetPart1DisplayFragment.class.getSimpleName();

    private static int ALPHABET_PART1 = 1;
    private static int ALPHABET_PART2 = 2;
    private static int ALPHABET_PART3 = 3;

    private String[] alphabetLetters1 = null;
    private String[] alphabetLetters2 = null;
    private String[] alphabetLetters3 = null;
    // Todo: animations

    private int[] alphabetAudioUrls1 = null;
    private int[] alphabetAudioUrls2 = null;
    private int[] alphabetAudioUrls3 = null;

    private String introduction;
    private String detailedInfoUrl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String languageIdentifier = getArguments().getString(CommonConstants.LANGUAGE_IDENTIFER);

        View fragmentView = inflater.inflate(R.layout.fragment_gridview, container, false);
        TextView textView1 = (TextView) fragmentView.findViewById(R.id.textview1_fragment_gridview);
        TextView textView2 = (TextView) fragmentView.findViewById(R.id.textview2_fragment_gridview);
        TextView textView3 = (TextView) fragmentView.findViewById(R.id.textview3_fragment_gridview);
        GridView gridView1 = (GridView) fragmentView.findViewById(R.id.gridview1_fragment_gridview);

        CustomAlphabetLettersGridViewAdapter customGridViewAdapter = null;


        switch (languageIdentifier) {
            case "Arabic":
                alphabetLetters1 = LanguageInfo.arabicAlphabetWithDifferentForms;
                alphabetAudioUrls1 = null;
                alphabetLetters2 = null;
                alphabetAudioUrls2 = null;
                gridView1.setNumColumns(4);
                textView1.setText("Arabic Alphabet");
                textView2.setVisibility(View.GONE);
                textView3.setVisibility(View.GONE);
                break;
            case "English":
                alphabetLetters1 = LanguageInfo.englishAlphabetUppercase;
                alphabetAudioUrls1 = null;
                alphabetLetters2 = LanguageInfo.englishAlphabetLowercase;
                alphabetAudioUrls2 = null;
                textView1.setText("English Alphabet Uppercase");
                textView2.setText("English Alphabet Lowercase");
                textView3.setVisibility(View.GONE);
                break;
            case "French":
                alphabetLetters1 = LanguageInfo.frenchAlphabetUppercase;
                alphabetAudioUrls1 = null;
                alphabetLetters2 = LanguageInfo.frenchAlphabetLowercase;
                alphabetAudioUrls2 = null;
                textView1.setText("French Alphabet Uppercase");
                textView2.setText("French Alphabet Lowercase");
                break;
            case "German":
                alphabetLetters1 = LanguageInfo.germanAlphabetUppercase;
                alphabetAudioUrls1 = null;
                alphabetLetters2 = LanguageInfo.germanAlphabetLowercase;
                alphabetAudioUrls2 = null;
                textView1.setText("German Alphabet Uppercase");
                textView2.setText("German Alphabet Lowercase");
                textView3.setVisibility(View.GONE);
                break;
            case "Greek":
                alphabetLetters1 = LanguageInfo.greekAlphabetUppercase;
                alphabetAudioUrls1 = null;
                alphabetLetters2 = LanguageInfo.greekAlphabetLowercase;
                alphabetAudioUrls2 = null;
                textView1.setText("Greek Alphabet Uppercase");
                textView2.setText("Greek Alphabet Lowercase");
                textView3.setVisibility(View.GONE);
                break;
            case "Hindi":
                alphabetLetters1 = LanguageInfo.hindiVowelLetters;
                alphabetAudioUrls1 = LanguageInfo.hindiVowelsAudioUrl;
                alphabetLetters2 = LanguageInfo.hindiConsonantLetters;
                alphabetAudioUrls2 = LanguageInfo.hindiConsonantsAudioUrl;
                textView1.setText("Hindi Alphabet Vowel Letters");
                textView2.setText("Hindi Alphabet Consonant Letters");
                textView3.setVisibility(View.GONE);
                break;
            case "Hebrew":
                alphabetLetters1 = LanguageInfo.hebrewAlphabetRightToLeft;
                alphabetAudioUrls1 = null;
                alphabetLetters2 = null;
                alphabetAudioUrls2 = null;
                textView1.setText("Hebrew Alphabet (22 letters in total, have no case)");
                textView2.setVisibility(View.GONE);
                textView3.setVisibility(View.GONE);
                introduction = "  The Hebrew alphabet has 22 letters. " +
                        "It does not have case, but five letters have different forms when used at the end of a word. " +
                        "Hebrew is written from right to left. There have been two script forms in use; the original old Hebrew script is known as the " +
                        "paleo-Hebrew script (which has been largely preserved, in an altered form, in the Samaritan script), while the present form of the Hebrew alphabet is a stylized form of the Aramaic script. " +
                        "Various (in current terms, fonts) of representation of the letters exist.";
                detailedInfoUrl = "https://en.wikipedia.org/wiki/Hebrew_alphabet";
                break;
            case "Japanese":
                alphabetLetters1 = LanguageInfo.hiragana;
                alphabetAudioUrls1 = LanguageInfo.japaneseAudioUrl;
                // Todo: katagana is not displayed at all. I guess it's because the layout cannot contain the 2nd part any more.
                // Todo: But I do not know how to solve this.
                alphabetLetters2 = LanguageInfo.katagana;
                alphabetAudioUrls2 = LanguageInfo.japaneseAudioUrl;
                textView1.setText(getResources().getString(R.string.japanese_hiragana));
                textView2.setText(getResources().getString(R.string.japanese_katagana));
                textView3.setVisibility(View.GONE);
                break;
            case "Korean":
                alphabetLetters1 = LanguageInfo.koreanVowelLetters;
                alphabetAudioUrls1 = LanguageInfo.koreanVowelsAudioUrls;
                alphabetLetters2 = LanguageInfo.koreanConsonantLetters;
                alphabetAudioUrls2 = LanguageInfo.koreanConsonantsAudioUrls;
                alphabetLetters3 = LanguageInfo.koreanDoubleConsonantLetters;
                alphabetAudioUrls3 = LanguageInfo.koreanCompoundConsonantsAudioUrls;
                textView1.setText("모음(Vowels)");
                textView2.setText("자음(Consonants)");
                textView3.setText("겹받침(Compound Consonants)");
                introduction = "  The Korean alphabet contains 14 consonant letters and 10 vowel letters.  " +
                        "Instead of being written sequentially like the letters of the Latin alphabet, " +
                        "letters are grouped into blocks, such as \"한(han)\". Each syllabic block consists of two to six letters, " +
                        "including at least one consonant and one vowel. " +
                        "These blocks are then arranged horizontally from left to right or vertically from top to bottom.";
                detailedInfoUrl = "https://en.wikipedia.org/wiki/Hangul";
                break;
            case "Russian":
                alphabetLetters1 = LanguageInfo.russianAlphabetUppercase;
                alphabetAudioUrls1 = null;
                alphabetLetters2 = LanguageInfo.russianAlphabetLowercase;
                alphabetAudioUrls2 = null;
                textView1.setText("Russian Alphabet Uppercase");
                textView2.setText("Russian Alphabet Lowercase");
                textView3.setVisibility(View.GONE);
                break;
            case "Spanish":
                alphabetLetters1 = LanguageInfo.spanishAlphabetUppercase;
                alphabetAudioUrls1 = null;
                alphabetLetters2 = LanguageInfo.spanishAlphabetLowercase;
                alphabetAudioUrls2 = null;
                textView1.setText("Spanish Alphabet Uppercase");
                textView2.setText("Spanish Alphabet Lowercase");
                textView3.setVisibility(View.GONE);
                break;
        }


        customGridViewAdapter = new CustomAlphabetLettersGridViewAdapter(getActivity(), alphabetLetters1);
//        Log.v(LOG_TAG, "getArguments().getString(CommonConstants.LANGUAGE_IDENTIFER): " + getArguments().getString(CommonConstants.LANGUAGE_IDENTIFER));

        gridView1.setAdapter(customGridViewAdapter);
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                customDialogHowToWrite(position, ALPHABET_PART1);
                if (alphabetAudioUrls1 != null && alphabetAudioUrls1.length > 0)
                    playAudio(alphabetAudioUrls1[position]);
            }
        });
        gridView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Todo: 加入生词本（数据库支持）
                Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        if (alphabetLetters2 != null && alphabetLetters2.length > 0) {
            GridView gridView2 = (GridView) fragmentView.findViewById(R.id.gridview2_fragment_gridview);
            gridView2.setAdapter(new CustomAlphabetLettersGridViewAdapter(getActivity(), alphabetLetters2));
            gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    customDialogHowToWrite(position, ALPHABET_PART2);
                    if (alphabetAudioUrls2 != null && alphabetAudioUrls2.length > 0)
                        playAudio(alphabetAudioUrls2[position]);
                }
            });
            gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }

        if (alphabetLetters3 != null && alphabetLetters3.length > 0) {
            GridView gridView3 = (GridView) fragmentView.findViewById(R.id.gridview3_fragment_gridview);
            gridView3.setAdapter(new CustomAlphabetLettersGridViewAdapter(getActivity(), alphabetLetters3));
            gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    customDialogHowToWrite(position, ALPHABET_PART3);
                    if (alphabetAudioUrls3 != null && alphabetAudioUrls3.length > 0)
                        playAudio(alphabetAudioUrls3[position]);
                }
            });
            gridView3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }

        if (introduction != null) {
            customDialogBasicInfo(introduction, detailedInfoUrl);
        }

        return fragmentView;
    }

    private void playAudio(int url) {
        Intent audioPlayIntent = new Intent(getActivity(), PlayAudioService.class);
        audioPlayIntent.putExtra(CommonConstants.ITEM_SELECTED_AUDIO_URL, url);
        getActivity().startService(audioPlayIntent);
    }

    private void stopPlayingAudio() {
        Intent stopAudioPlayIntent = new Intent(getActivity(), PlayAudioService.class);
        getActivity().stopService(stopAudioPlayIntent);
    }

    private void customDialogHowToWrite(int position, int identifier) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_box_how_to_write);
        dialog.setTitle(getResources().getString(R.string.custom_dialog_box_title));

        TextView textView = (TextView) dialog.findViewById(R.id.textview_dialog_box_how_to_write);
        if (ALPHABET_PART1 == identifier) {
            textView.setText(alphabetLetters1[position]);
        } else if (ALPHABET_PART2 == identifier) {
            textView.setText(alphabetLetters2[position]);
        } else {
            textView.setText(alphabetLetters3[position]);
        }
        if (textView.getText() != " ") {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    return false;
                }
            });

            dialog.show();
        }
    }

    private void customDialogBasicInfo(String introduction, final String detailedInfoUrl) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_box_basic_info);
        dialog.setTitle("Introduction");

        TextView textView = (TextView) dialog.findViewById(R.id.textview_dialog_box_basic_info);
        textView.setText(introduction);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (detailedInfoUrl != null) {
                    // Todo: detailed info provided here, or open browers on Wikipedia directly
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailedInfoUrl));
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Details will be provided.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkbox_dialog_box_basic_info);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity(), "Never show up again.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "I will show up again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }
}
