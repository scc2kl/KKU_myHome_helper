//package com.example.khj.kku_myhome_helper.BackUp;
//
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.NavigationView;
//import android.support.design.widget.Snackbar;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//
//import com.example.khj.kku_myhome_helper.R;
//
//public class MainActivity extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener {
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        LotteFragment = new main_Fm();
//
//        /**
//         * 기본 화면 설정
//         */
////        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
////        transaction.add(R.id.`4rfd, LotteFragment);
//////        transaction.addToBackStack(null);
////        transaction.commit();
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.multiple_actions);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.search_view, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    /**
//     * @param item
//     * @return
//     * @see NavigationView.OnNavigationItemSelectedListener
//     */
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
////            transaction.replace(R.id.container, LotteFragment);
//        } else if (id == R.id.nav_gallery) {
////            transaction.replace(R.id.container, LotteFragment);
//            this.setTitle("LG Fragment");
//        } else if (id == R.id.nav_slideshow) {
//        } else if (id == R.id.nav_manage) {
//        } else if (id == R.id.nav_share) {
//        } else if (id == R.id.nav_send) {
////            transaction.replace(R.id.container, LotteFragment);
//            this.setTitle("SAMSUNG Fragment");
//        }
//
//        transaction.commit();
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//}
