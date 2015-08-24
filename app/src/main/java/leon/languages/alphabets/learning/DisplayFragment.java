package leon.languages.alphabets.learning;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import leon.languages.alphabets.database.DatabaseHelper;
import leon.languages.alphabets.helper.CommonConstants;
import leon.languages.alphabets.R;
import leon.languages.alphabets.gridview.CustomAlphabetLettersGridViewAdapter;
import leon.languages.alphabets.multimedia.PlayAudioService;

public class DisplayFragment extends Fragment {

    private String[] alphabetLetters;
    private int[] alphabetAudios;
    private DatabaseHelper dbHelper;
    private String languageIdentifier;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentDisplayView = inflater.inflate(R.layout.display_gridview, container, false);
        dbHelper = new DatabaseHelper(getActivity());

        String title = "Alphabet";

        if (getArguments() != null) {
            alphabetLetters = getArguments().getStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER);
            alphabetAudios = getArguments().getIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER);
            title = getArguments().getString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER);
            languageIdentifier = getArguments().getString(CommonConstants.LANGUAGE_IDENTIFER);
        }

        TextView textView = (TextView) fragmentDisplayView.findViewById(R.id.textview_display_gridview);
        GridView gridView = (GridView) fragmentDisplayView.findViewById(R.id.gridview_display_gridview);
        if (title != "") textView.setText(title);

        CustomAlphabetLettersGridViewAdapter customAlphabetLettersGridViewAdapter
                = new CustomAlphabetLettersGridViewAdapter(getActivity(), alphabetLetters);
        gridView.setAdapter(customAlphabetLettersGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displaySingleAlphabetDialog(getActivity(), languageIdentifier, position);
                if (alphabetAudios != null && alphabetAudios.length > 0) {
                    playAudio(alphabetAudios[position]);
                }
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),
                        "Added: " + dbHelper.getAlphabetLetterAddedTimes(languageIdentifier, alphabetLetters[position]),
                        Toast.LENGTH_SHORT).show();
                dbHelper.addOneTime(languageIdentifier, alphabetLetters[position]);
                return false;
            }
        });

        return fragmentDisplayView;
    }

    private void playAudio(int url) {
        Intent audioPlayIntent = new Intent(getActivity(), PlayAudioService.class);
        audioPlayIntent.putExtra(CommonConstants.ITEM_SELECTED_AUDIO_URL, url);
        getActivity().startService(audioPlayIntent);
    }

    private void displaySingleAlphabetDialog(Context context, final String languageIdentifier, final int position) {
        final Dialog displayDialog = new Dialog(context);
        displayDialog.setContentView(R.layout.dialog_box_how_to_write);
        displayDialog.setTitle("How to write:");
        TextView textView = (TextView) displayDialog.findViewById(R.id.textview_dialog_box_how_to_write);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(108);
        textView.setText(alphabetLetters[position]);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDialog.dismiss();
            }
        });

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(),
                        "Added: " + dbHelper.getAlphabetLetterAddedTimes(languageIdentifier, alphabetLetters[position]),
                        Toast.LENGTH_SHORT).show();
                dbHelper.addOneTime(languageIdentifier, alphabetLetters[position]);
                return true;
            }
        });

        displayDialog.show();
    }
}
