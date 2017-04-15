package com.example.khj.kku_myhome_helper.Activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;

import com.example.khj.kku_myhome_helper.R;

// AppCompatActivity
public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();


    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
