package com.example.khj.kku_myhome_helper.BackUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.khj.kku_myhome_helper.Activity.FmActivity;
import com.example.khj.kku_myhome_helper.Data.SingleTon;
import com.example.khj.kku_myhome_helper.Fragment.quick_Fm;
import com.example.khj.kku_myhome_helper.R;

import java.util.ArrayList;
import java.util.List;

//import com.example.khj.kku_myhome_helper.Fragment.myRoom_Fm;

public class MainActivityddd extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<Fragment> myFmList;
    Fragment fragment_myRoom;
    Fragment fragment_quick_Fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("내방 관리"));
        tabLayout.addTab(tabLayout.newTab().setText("퀵 메뉴"));
        SingleTon s = SingleTon.getInstance(this);
        s.getDbHelper();


        myFmList = new ArrayList<>();
        fragment_myRoom = new quick_Fm();
        fragment_quick_Fm = new quick_Fm();

        myFmList.add(fragment_myRoom);
        myFmList.add(fragment_quick_Fm);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ViewPager pager = (ViewPager) findViewById(R.id.main_viewPager);
        FragmentManager fragmentManager = getSupportFragmentManager();
//        mainPager_Ad adapter = new mainPager_Ad(getSupportFragmentManager(), (ArrayList<Fragment>) myFmList);
        pager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            /**
             * View Pager 의 Fragment 들은 각각 Index 를 가진다.
             * Android OS로 부터 요청된 Pager 의 Index 를 보내주면,
             * 해당되는 Fragment 를 리턴시킨다.
             * @param position
             * @return
             */
            @Override
            public Fragment getItem(int position) {
                return myFmList.get(position);
//                Crime crime = mCrimes.get(position);
//                return CrimeFragment.newInstance(crime.getId());
            }
            /**
             * View Pager 에 몇개의 Fragment 가 들어가는지 설정한다.
             * @return
             */
            @Override
            public int getCount() {
                return myFmList.size();
            }
//            for (int i = 0; i < mCrimes.size(); i++) {
//                if (mCrimes.get(i).getId().equals(crimeId)) {
//                    mViewPager.setCurrentItem(i);
//                    break;
//                }
//            }
        });
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        this.setTitle("내방 매니저");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Button go = (Button) findViewById(R.id.nav_header_login_id_button);
//        go.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = FmActivity.newIntent(MainActivity.this, SingleTon.FM_ITEMADD);
//                startActivity(intent);
//            }
//        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_view, menu);
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

    /**
     * @param item
     * @return
     * @see NavigationView.OnNavigationItemSelectedListener
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
////            transaction.replace(R.id.container, fragment_quick_Fm);
//        } else if (id == R.id.nav_gallery) {
//            this.setTitle("LG Fragment");
//        } else if (id == R.id.nav_slideshow) {
//        } else if (id == R.id.nav_manage) {
//        } else if (id == R.id.nav_share) {
//        } else if (id == R.id.nav_send) {
//            this.setTitle("SAMSUNG Fragment");
//        }
        if (id == R.id.nav_manage) {
            Intent intent = FmActivity.newIntent(this, SingleTon.FM_ITEMADD);
            startActivity(intent);
        }

        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // 어뎁터 생성
    private class mainPager_Ad extends FragmentStatePagerAdapter {

        List<Fragment> myFmList;


        public mainPager_Ad(FragmentManager fm, ArrayList<Fragment> myFmList) {
            super(fm);
            this.myFmList = myFmList;
        }

        /**
         * View Pager 의 Fragment 들은 각각 Index 를 가진다.
         * Android OS로 부터 요청된 Pager 의 Index 를 보내주면,
         * 해당되는 Fragment 를 리턴시킨다.
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            return myFmList.get(position);
        }


        /**
         * View Pager 에 몇개의 Fragment 가 들어가는지 설정한다.
         * @return
         */
        @Override
        public int getCount() {
            return myFmList.size();
        }
    }
}
