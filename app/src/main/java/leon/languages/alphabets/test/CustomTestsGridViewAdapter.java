package leon.languages.alphabets.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import leon.languages.alphabets.CommonConstants;
import leon.languages.alphabets.R;
import leon.languages.alphabets.database.LanguageInfo;

public class CustomTestsGridViewAdapter extends BaseAdapter {

    private Context context;

    public CustomTestsGridViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return LanguageInfo.LANGUAGE_NAMES_IN_NATIVE.length;
    }

    @Override
    public String getItem(int position) {
        return LanguageInfo.LANGUAGE_NAMES_IN_NATIVE[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.drawer_list_item, parent, false);

        TextView textView = (TextView) rootView.findViewById(R.id.textview_drawer_list_row);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageview_drawer_list_row);

        textView.setText(LanguageInfo.LANGUAGE_NAMES_IN_NATIVE[position]);
        imageView.setImageResource(LanguageInfo.nationalFlagImageUrls[position]);

        return rootView;
    }
}
