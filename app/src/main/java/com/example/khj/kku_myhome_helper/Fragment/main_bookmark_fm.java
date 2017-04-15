package com.example.khj.kku_myhome_helper.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.khj.kku_myhome_helper.Activity.MainActivity;
import com.example.khj.kku_myhome_helper.R;

import java.util.List;

/**
 * Created by KHJ on 2017-04-12.
 */

public class main_bookmark_fm extends Fragment implements NavigationView.OnNavigationItemSelectedListener{

    private Callbacks mCallbacks;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    /**
     * 호스팅 액티비티에서 구현할 필요가 있는 인터페이스.
     */
    public interface Callbacks {
        void onCrimeSelected();
    }

    // 프래그먼트가 그려질때 엑티비티에서 전달값을 새로 구성한다.
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        mCallbacks = (Callbacks) context;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_main, container, false);



        return view;
    }

    // 옵션 매뉴(툴바)를 생성 한다.
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        // 메뉴 리소스를 가져온다.
        inflater.inflate(R.menu.search_view, menu);
    }

    // 매뉴 선택 이벤트 처리
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 선택된 이벤트를 받는다.
        switch (item.getItemId()) {
            // 선택된 이벤트가 어떤 값을 가지는지 확인한다.

        }
        Log.e("매뉴 아이템 아이디",item.getItemId()+"");
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }
}
