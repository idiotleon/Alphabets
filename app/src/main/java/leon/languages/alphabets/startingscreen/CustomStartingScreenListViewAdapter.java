package leon.languages.alphabets.startingscreen;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import leon.languages.alphabets.R;

public class CustomStartingScreenListViewAdapter extends ArrayAdapter {

    private Context context;
    private String[] options;
    private int resource;

    public CustomStartingScreenListViewAdapter(Context context, int resource, String[] options) {
        super(context, resource, options);
        this.context = context;
        this.resource = resource;
        this.options = options;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(resource, null);
        TextView textView = (TextView) rootView.findViewById(R.id.textview_listview_startingscreen);
        textView.setText(options[position]);
        return rootView;
    }
}
