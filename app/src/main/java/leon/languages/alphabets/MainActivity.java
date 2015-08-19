package leon.languages.alphabets;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import leon.languages.alphabets.database.LanguageInfo;
import leon.languages.alphabets.listview.CustomDrawerListViewAdapter;
import leon.languages.alphabets.gridview.GridViewFragment;
import leon.languages.alphabets.multimedia.PlayAudioService;
import leon.languages.alphabets.test.AlphabetTestActivity;

/**
 * 1. Location for making friends and study group
 * 2. 加入生词本(数据库(怎么设计数据库))
 * 3. OAuth & Save Progress in Cloud: icon of OAuth social account on top of side navigation bar
 * 5. ActionBar with icon
 * <p>
 * <p>
 * Error:
 * 1. Side Navigation Bar: 新生成的Fragment会叠加到原有的Fragment上
 */
public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getSimpleName();

    // Todo: drawer slided with animations, such as with bright shine
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mLanguages;

    // Main UI components on the starting screen
    private Button btnStart;
    private Button btnTest;
    private Button btnReview;
    private Button btnScore;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main_activity);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_main_activity);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new CustomDrawerListViewAdapter(getApplicationContext()));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btnStart = (Button) findViewById(R.id.btn_start_mainactivity);
        btnTest = (Button) findViewById(R.id.btn_test_mainactivity);
        btnReview = (Button) findViewById(R.id.btn_review_mainactivity);
        btnScore = (Button) findViewById(R.id.btn_score_mainactivity);
        btnExit = (Button) findViewById(R.id.btn_exit_mainactivity);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Please select a language", Toast.LENGTH_SHORT).show();
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Test Capabilities is being added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AlphabetTestActivity.class);
                startActivity(intent);
            }
        });

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Review Capabilities will be added", Toast.LENGTH_SHORT).show();
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Score board will be added", Toast.LENGTH_SHORT).show();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Service is terminated
                stopService(new Intent(MainActivity.this, PlayAudioService.class));
                finish();
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_settings).setVisible(!mDrawerLayout.isDrawerOpen(mDrawerList));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {

        btnStart.setVisibility(View.GONE);
        btnTest.setVisibility(View.GONE);
        btnReview.setVisibility(View.GONE);
        btnScore.setVisibility(View.GONE);
        btnExit.setVisibility(View.GONE);

        mDrawerLayout.closeDrawers();
        GridViewFragment gridViewFragment = new GridViewFragment();
        Bundle args = new Bundle();
        args.putString(CommonConstants.FRAGMENT_LANGUAGE_IDENTIFER, LanguageInfo.LANGUAGE_NAME_IDENTIFIERS[position]);
        Log.v(LOG_TAG, "languageNameIdentifier - 161, MainActivity: " + LanguageInfo.LANGUAGE_NAME_IDENTIFIERS[position]);
        gridViewFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame_main_activity, gridViewFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(MainActivity.this, PlayAudioService.class));
    }
}
