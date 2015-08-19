package leon.languages.alphabets.fragment;

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

import leon.languages.alphabets.others.CommonConstants;
import leon.languages.alphabets.R;
import leon.languages.alphabets.gridview.CustomAlphabetLettersGridViewAdapter;
import leon.languages.alphabets.multimedia.PlayAudioService;

public class DisplayFragment extends Fragment {

    private String[] alphabetLetters;
    private int[] alphabetAudios;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentDisplayView = inflater.inflate(R.layout.display_gridview, container, false);

        String title = "Alphabet";
        if (getArguments() != null) {
            alphabetLetters = getArguments().getStringArray(CommonConstants.ALPHABET_LETTER_IDENTIFIER);
            alphabetAudios = getArguments().getIntArray(CommonConstants.ALPHABET_LETTER_AUDIO_IDENTIFIER);
            title = getArguments().getString(CommonConstants.ALPHABET_FRAGMENT_TITLE_IDENTIFIER);
        }

        TextView textView = (TextView) fragmentDisplayView.findViewById(R.id.textview_display_gridview);
        GridView gridView = (GridView) fragmentDisplayView.findViewById(R.id.gridview_display_gridview);
        if (title != "") textView.setText(title);

        CustomAlphabetLettersGridViewAdapter customAlphabetLettersGridViewAdapter = new CustomAlphabetLettersGridViewAdapter(getActivity(), alphabetLetters);
        gridView.setAdapter(customAlphabetLettersGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (alphabetAudios != null && alphabetAudios.length > 0)
                    playAudio(alphabetAudios[position]);
            }
        });

        return fragmentDisplayView;
    }

    private void playAudio(int url) {
        Intent audioPlayIntent = new Intent(getActivity(), PlayAudioService.class);
        audioPlayIntent.putExtra(CommonConstants.ITEM_SELECTED_AUDIO_URL, url);
        getActivity().startService(audioPlayIntent);
    }
}
