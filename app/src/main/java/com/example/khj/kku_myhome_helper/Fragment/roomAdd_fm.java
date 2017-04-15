package com.example.khj.kku_myhome_helper.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.khj.kku_myhome_helper.CustomView.ClearEditText;
import com.example.khj.kku_myhome_helper.Data.listItemDataSet;
import com.example.khj.kku_myhome_helper.R;
import java.util.Date;
import java.util.UUID;

/**
 * Created by KHJ on 2017-04-12.
 */

public class roomAdd_fm extends Fragment {

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

    // 데이터 값을 전달할때 사용하나??....기억이....
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(resultCode != Activity.RESULT_OK){
//            return;
//        }
//        if(requestCode==REQUEST_DATE){
//            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
//            mCrime.setmDate(date);
//            updateData();
//        }
//    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void updateData() {

    }

    // 값을 전달 받아 번들에 저장하고 해당 번들을 다시 전달하는 메서드
    public static roomAdd_fm newInstance(UUID crimeId){
        // 번들 생성
        Bundle args = new Bundle();
        // 아이디(키)에 받아온 값을 저장한다.
        args.putSerializable(ARG_CRIME_ID,crimeId);

        // 프래그먼드를 재호출 한다.
        roomAdd_fm fragment = new roomAdd_fm();

        // 프래그먼트에 번들 값을 저장한다.
        fragment.setArguments(args);

        // 프래그먼트를 전달한다.
        return fragment;
    }
    // 프래그먼트를 생성한다. 번블에 이전 정보들을 넣어놓으면 여기서 불러올수도 있다.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // 번블을 불러온다.
        super.onCreate(savedInstanceState);
        // 랜덤한 고유의 UUID를 얻어올수 있다.(생성시마다 다른값을 가져온다.)
//        mCrime = new Crime();
        // getActivity().getIntent() 인텐트 값을 받아라(실행)
        // .getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID); 어떤인텐트를 받을거다(인텐트를 날릴때 보낸키값)
//        UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);
        // 인텐트로 전달 받은 UUID를 가지고 CrimeLap에서 데이터를 불러온다
//        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);

        // 번들로 전달되어 온값을 받아 저장한다.
//        String tPos = (String) getArguments().getSerializable(ARG_CRIME_ID);

//        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    // 프래그먼트 뷰를 생성 한다.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // 프래그먼트를 생성할 메인 레이아웃을 불러온다.
        View v = inflater.inflate(R.layout.fragment_add_room,container,false);

        return v;
    }
}
