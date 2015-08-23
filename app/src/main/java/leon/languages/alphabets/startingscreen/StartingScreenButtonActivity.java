package leon.languages.alphabets.startingscreen;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import leon.languages.alphabets.R;
import leon.languages.alphabets.database.LanguageInfo;
import leon.languages.alphabets.learning.AlphabetLearningActivity;
import leon.languages.alphabets.leftdrawer.CustomDrawerListViewAdapter;
import leon.languages.alphabets.multimedia.PlayAudioService;
import leon.languages.alphabets.others.CommonConstants;
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
public class StartingScreenButtonActivity extends Activity {

    private static String LOG_TAG = StartingScreenButtonActivity.class.getSimpleName();

    // Todo: drawer slided with animations, such as with bright shine
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    // Main UI components on the starting screen
    private Button btnStart;
    private Button btnTest;
    private Button btnReview;
    private Button btnScore;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_screen_buttons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main_activity);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_main_activity);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new CustomDrawerListViewAdapter(getApplicationContext()));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        btnStart = (Button) findViewById(R.id.btn_start_mainactivity);
        btnTest = (Button) findViewById(R.id.btn_test_mainactivity);
        btnReview = (Button) findViewById(R.id.btn_review_mainactivity);
        btnScore = (Button) findViewById(R.id.btn_score_mainactivity);
        btnExit = (Button) findViewById(R.id.btn_exit_mainactivity);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartingScreenButtonActivity.this, "Please select a languageName", Toast.LENGTH_SHORT).show();
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartingScreenButtonActivity.this, "Test Capabilities is being added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StartingScreenButtonActivity.this, AlphabetTestActivity.class);
                startActivity(intent);
            }
        });

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartingScreenButtonActivity.this, "Review Capabilities will be added", Toast.LENGTH_SHORT).show();
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartingScreenButtonActivity.this, "Score board will be added", Toast.LENGTH_SHORT).show();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Service is terminated
                stopService(new Intent(StartingScreenButtonActivity.this, PlayAudioService.class));
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
            Intent intent = new Intent(StartingScreenButtonActivity.this, AlphabetLearningActivity.class);
            intent.putExtra(CommonConstants.LANGUAGE_IDENTIFER, LanguageInfo.LANGUAGE_NAME_IDENTIFIERS[position]);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(StartingScreenButtonActivity.this, PlayAudioService.class));
    }
}
