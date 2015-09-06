package leon.languages.alphabets.startingscreen;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import leon.languages.alphabets.R;
import leon.languages.alphabets.database.LanguageInfo;
import leon.languages.alphabets.learning.AlphabetLearningActivity;
import leon.languages.alphabets.leftdrawer.CustomDrawerListViewAdapter;
import leon.languages.alphabets.multimedia.PlayAudioService;
import leon.languages.alphabets.others.CommonConstants;
import leon.languages.alphabets.test.AlphabetTestActivity;

public class StartingScreenListViewActivity extends Activity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ListView listViewStartingScreen;

    private String[] options = {"Start", "Test", "Review", "ScoreBoard"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_screen_listview);

        listViewStartingScreen = (ListView) findViewById(R.id.listview_options_startingscreen);
        CustomStartingScreenListViewAdapter customStartingScreenListViewAdapter
                = new CustomStartingScreenListViewAdapter(StartingScreenListViewActivity.this,
                R.layout.listview_item_startingscreenlistviewactivity,
                options);
        listViewStartingScreen.setAdapter(customStartingScreenListViewAdapter);
        listViewStartingScreen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (options[position]) {
                    case "Start":
                        mDrawerLayout.openDrawer(GravityCompat.START);
                        break;
                    case "Test":
                        Toast.makeText(StartingScreenListViewActivity.this, "Test Capabilities is being added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(StartingScreenListViewActivity.this, AlphabetTestActivity.class);
                        startActivity(intent);
                        break;
                    case "Review":
                        Toast.makeText(StartingScreenListViewActivity.this, "Review Capabilities will be added", Toast.LENGTH_SHORT).show();

                        break;
                    case "ScoreBoard":
                        Toast.makeText(StartingScreenListViewActivity.this, "Score board will be added", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_startingscreenlistview);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_startingscreenlistview);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new CustomDrawerListViewAdapter(getApplicationContext()));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayShowHomeEnabled(false);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(StartingScreenListViewActivity.this, PlayAudioService.class));
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(StartingScreenListViewActivity.this, AlphabetLearningActivity.class);
            intent.putExtra(CommonConstants.LANGUAGE_IDENTIFER, LanguageInfo.LANGUAGE_NAME_IDENTIFIERS[position]);
            startActivity(intent);
        }
    }
}
