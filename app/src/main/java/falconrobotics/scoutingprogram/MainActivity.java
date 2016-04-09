package falconrobotics.scoutingprogram;

import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.UUID;


/**
 * Main class
 */
public class MainActivity extends AppCompatActivity {
    public static final UUID BT_UUID = UUID.fromString("196e8598-e74f-11e5-9730-9a79f06e9478");
    public static Context context;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private static String eventName = "champsDATA.db";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
//        Thread thread = new Thread(runnable);
//        thread.setPriority(Thread.MAX_PRIORITY);
//        thread.start();

        DBHelper.createDir();

        DBHelper myDbHelper = new DBHelper(eventName);

        /**
         *Setup the DrawerLayout and NavigationView
         */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new Fragment_Sync()).commit();

        /**
         * Setup click events on the Navigation View Items.
         */
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                if (menuItem.getItemId() == R.id.nav_item_game_scout) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new Fragment_Tab_S()).commit();

                }

                if (menuItem.getItemId() == R.id.nav_item_pit_scout) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new Frame_Fragment_PS()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_bluetooth_share) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new Fragment_Sync()).commit();
                }
                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

                    mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }

    public static String getEventName()
    {
        return eventName;
    }
}



