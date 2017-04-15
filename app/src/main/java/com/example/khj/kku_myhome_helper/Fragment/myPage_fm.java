package com.example.khj.kku_myhome_helper.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.khj.kku_myhome_helper.CustomView.ClearEditText;
import com.example.khj.kku_myhome_helper.Data.listItemDataSet;
import com.example.khj.kku_myhome_helper.R;

import java.util.UUID;

/**
 * Created by KHJ on 2017-04-12.
 */

public class myPage_fm extends Fragment{

    // 번들에서 사용할 아이디를 만듦
    private static final String ARG_CRIME_ID ="crime_id";
    private static final String DIALOG_DATE ="DialogDate";
    private static final int REQUEST_DATE =0;

    private listItemDataSet rbData;
    private ClearEditText mTitleField;
    private ClearEditText mExpField;
    private Button mSaveButton;
    private Button mCencleButton;
    private TextView mPosisionField;


    @Override
    public void onPause() {
        super.onPause();
    }

    private void updateData() {

    }

    // 값을 전달 받아 번들에 저장하고 해당 번들을 다시 전달하는 메서드
    public static itemAdd_fm newInstance(UUID crimeId){
        // 번들 생성
        Bundle args = new Bundle();
        // 아이디(키)에 받아온 값을 저장한다.
        args.putSerializable(ARG_CRIME_ID,crimeId);

        // 프래그먼드를 재호출 한다.
        itemAdd_fm fragment = new itemAdd_fm();

        // 프래그먼트에 번들 값을 저장한다.
        fragment.setArguments(args);

        // 프래그먼트를 전달한다.
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_page,container,false);

        return v;
    }
}
