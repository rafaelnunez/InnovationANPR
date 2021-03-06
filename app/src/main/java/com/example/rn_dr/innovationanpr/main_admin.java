package com.example.rn_dr.innovationanpr;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class main_admin extends AppCompatActivity{


    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main_admin);
            final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.rotate_ivlog);
            appbar = (Toolbar)findViewById(R.id.appbar_admin);
            setSupportActionBar(appbar);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout_admin);
            Fragment fragment = null;
            fragment = new fragmen1_admin();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame_admin, fragment)
                    .commit();
            ImageView imageViewlog = (ImageView)findViewById(R.id.ivlog);
            imageViewlog.startAnimation(animScale);
            navView = (NavigationView)findViewById(R.id.navview_admin);
            navView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {

                            boolean fragmentTransaction = false;
                            Fragment fragment = null;

                            switch (menuItem.getItemId()) {
                                case R.id.menu_seccion_1:
                                    fragment = new fragmen1_admin();
                                    fragmentTransaction = true;
                                    break;
                                case R.id.menu_seccion_2:
                                    fragment = new fragment2_admin();
                                    fragmentTransaction = true;
                                    break;
                                case R.id.menu_seccion_3:
                                    fragment = new Fragment3();
                                    fragmentTransaction = true;
                                    break;
                                case R.id.menu_opcion_1:
                                    Log.i("NavigationView", "Pulsada opción 1");
                                    break;
                                case R.id.menu_opcion_2:
                                    Log.i("NavigationView", "Pulsada opción 2");
                                    break;
                            }

                            if (fragmentTransaction) {
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame_admin, fragment)
                                        .commit();

                                menuItem.setChecked(true);
                                getSupportActionBar().setTitle(menuItem.getTitle());
                            }
                            drawerLayout.closeDrawers();
                            return true;
                        }
                    });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main_admin, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.

            switch(item.getItemId()) {
                case android.R.id.home:
                    drawerLayout.openDrawer(GravityCompat.START);
                    return true;
            }

            return super.onOptionsItemSelected(item);
        }
}
