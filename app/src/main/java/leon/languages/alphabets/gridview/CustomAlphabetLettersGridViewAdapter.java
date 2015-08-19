package leon.languages.alphabets.gridview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAlphabetLettersGridViewAdapter extends BaseAdapter {

    private static String LOG_TAG = CustomAlphabetLettersGridViewAdapter.class.getSimpleName();

    private Context context;
    private String[] alphabetLetters;


    public CustomAlphabetLettersGridViewAdapter(Context context, String[] alphabetLetters) {
        this.context = context;
        this.alphabetLetters = alphabetLetters;
    }

    @Override
    public int getCount() {
        return alphabetLetters.length;
    }

    @Override
    public String getItem(int position) {
        return alphabetLetters[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(context);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(alphabetLetters[position]);
        textView.setTextSize(64);
        textView.setGravity(Gravity.CENTER);

        return textView;
    }
}
