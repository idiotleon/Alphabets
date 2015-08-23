package leon.languages.alphabets.test;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import leon.languages.alphabets.R;
import leon.languages.alphabets.leftdrawer.CustomDrawerListViewAdapter;

public class AlphabetTestActivity extends AppCompatActivity {

    private static final String LOG_TAG = AlphabetTestActivity.class.getSimpleName();

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private GridView gridView;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textView = (TextView) findViewById(R.id.textview_test_activity);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_test_activity);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_test_activity);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new CustomDrawerListViewAdapter(getApplicationContext()));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectAlphabetTest(position);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        gridView = (GridView) findViewById(R.id.gridview_test_activity);
        gridView.setAdapter(new CustomTestsGridViewAdapter(getApplicationContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectAlphabetTest(position);
            }
        });
    }

    private void selectAlphabetTest(int position) {
        mDrawerLayout.closeDrawers();
        gridView.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);

    }
}
