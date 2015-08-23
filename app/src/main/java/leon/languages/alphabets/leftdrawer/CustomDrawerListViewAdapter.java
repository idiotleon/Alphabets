package leon.languages.alphabets.leftdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import leon.languages.alphabets.R;
import leon.languages.alphabets.database.LanguageInfo;

public class CustomDrawerListViewAdapter extends BaseAdapter {

    private Context context;

    public CustomDrawerListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return LanguageInfo.LANGUAGE_NAMES_IN_NATIVE.length;
    }

    @Override
    public Object getItem(int position) {
        return LanguageInfo.LANGUAGE_NAMES_IN_NATIVE[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.drawer_list_item, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageview_drawer_list_row);
        TextView textView = (TextView) rowView.findViewById(R.id.textview_drawer_list_row);
        textView.setText(LanguageInfo.LANGUAGE_NAMES_IN_NATIVE[position]);
        imageView.setImageResource(LanguageInfo.nationalFlagImageUrls[position]);

        return rowView;
    }
}
