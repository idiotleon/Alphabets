package leon.languages.alphabets.obsolete;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import leon.languages.alphabets.helper.CommonConstants;
import leon.languages.alphabets.R;
import leon.languages.alphabets.database.LanguageInfo;
import leon.languages.alphabets.gridview.CustomAlphabetLettersGridViewAdapter;
import leon.languages.alphabets.multimedia.PlayAudioService;

public class AlphabetPart2DisplayFragment extends Fragment {

    private static String LOG_TAG = AlphabetPart2DisplayFragment.class.getSimpleName();

    private String[] alphabetPart2Letters = null;
    // Todo: animations

    private int[] alphabetPart2AudioUrls = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String languageIdentifier = getArguments().getString(CommonConstants.LANGUAGE_IDENTIFER);

        View fragmentView = inflater.inflate(R.layout.display_gridview, container, false);
        TextView textView = (TextView) fragmentView.findViewById(R.id.textview_display_gridview);
        GridView gridView = (GridView) fragmentView.findViewById(R.id.gridview_display_gridview);

        CustomAlphabetLettersGridViewAdapter customGridViewAdapter = null;


        switch (languageIdentifier) {
            case "Arabic":
                alphabetPart2Letters = null;
                alphabetPart2AudioUrls = null;
                gridView.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                break;
            case "English":
                alphabetPart2Letters = LanguageInfo.englishAlphabetLowercase;
                alphabetPart2AudioUrls = null;
                textView.setText("English Alphabet Lowercase");
                break;
            case "French":
                alphabetPart2Letters = LanguageInfo.frenchAlphabetLowercase;
                alphabetPart2AudioUrls = null;
                textView.setText("French Alphabet Lowercase");
                break;
            case "German":
                alphabetPart2Letters = LanguageInfo.germanAlphabetLowercase;
                alphabetPart2AudioUrls = null;
                textView.setText("German Alphabet Lowercase");
                break;
            case "Greek":
                alphabetPart2Letters = LanguageInfo.greekAlphabetLowercase;
                alphabetPart2AudioUrls = null;
                textView.setText("Greek Alphabet Lowercase");
                break;
            case "Hindi":
                alphabetPart2Letters = LanguageInfo.hindiConsonantLetters;
                alphabetPart2AudioUrls = LanguageInfo.hindiConsonantsAudioUrl;
                textView.setText("Hindi Alphabet Consonant Letters");
                break;
            case "Hebrew":
                alphabetPart2Letters = null;
                alphabetPart2AudioUrls = null;
                textView.setText("Hebrew Alphabet (22 letters in total, have no case)");
                break;
            case "Japanese":
                // Todo: katagana is not displayed at all. I guess it's because the layout cannot contain the 2nd part any more.
                // Todo: But I do not know how to solve this.
                alphabetPart2Letters = LanguageInfo.katagana;
                alphabetPart2AudioUrls = LanguageInfo.japaneseAudioUrl;
                textView.setText(getResources().getString(R.string.japanese_katagana));
                break;
            case "Korean":
                alphabetPart2Letters = LanguageInfo.koreanConsonantLetters;
                alphabetPart2AudioUrls = LanguageInfo.koreanConsonantsAudioUrls;
                textView.setText("자음(Consonants)");
                break;
            case "Russian":
                alphabetPart2Letters = LanguageInfo.russianAlphabetLowercase;
                alphabetPart2AudioUrls = null;
                textView.setText("Russian Alphabet Lowercase");
                break;
            case "Spanish":
                alphabetPart2Letters = LanguageInfo.spanishAlphabetLowercase;
                alphabetPart2AudioUrls = null;
                textView.setText("Spanish Alphabet Lowercase");
                break;
        }

        customGridViewAdapter = new CustomAlphabetLettersGridViewAdapter(getActivity(), alphabetPart2Letters);
//        Log.v(LOG_TAG, "getArguments().getString(CommonConstants.LANGUAGE_IDENTIFER): " + getArguments().getString(CommonConstants.LANGUAGE_IDENTIFER));

        gridView.setAdapter(customGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                customDialogHowToWrite(position);
                if (alphabetPart2AudioUrls != null && alphabetPart2AudioUrls.length > 0)
                    playAudio(alphabetPart2AudioUrls[position]);
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Todo: 加入生词本（数据库支持）
                Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

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

    private void customDialogHowToWrite(int position) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_box_how_to_write);
        dialog.setTitle(getResources().getString(R.string.custom_dialog_box_title));

        TextView textView = (TextView) dialog.findViewById(R.id.textview_dialog_box_how_to_write);
        textView.setText(alphabetPart2Letters[position]);

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
}
