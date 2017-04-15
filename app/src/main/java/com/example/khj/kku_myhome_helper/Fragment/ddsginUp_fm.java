//package com.example.khj.kku_myhome_helper.Fragment;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.EditText;
//
//import java.util.Date;
//import java.util.UUID;
//
///**
// * Created by KHJ on 2017-04-12.
// */
//
//public class sginUp_fm extends Fragment {
//
//    // 번들에서 사용할 아이디를 만듦
//    private static final String ARG_CRIME_ID ="crime_id";
//    private static final String DIALOG_DATE ="DialogDate";
//    private static final int REQUEST_DATE =0;
//
//    private Crime mCrime;
//    private EditText mTitleField;
//    private Button mDateButton;
//    private CheckBox mSolvedCheckBox;
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(resultCode != Activity.RESULT_OK){
//            return;
//        }
//        if(requestCode==REQUEST_DATE){
//            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
//            mCrime.setmDate(date);
//            updateDate();
//        }
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        CrimeLab.get(getActivity()).updateCrime(mCrime);
//    }
//
//    private void updateDate() {
//        mDateButton.setText(mCrime.getmDate().toString());
//    }
//
//    // 값을 전달 받아 번들에 저장하고 해당 번들을 다시 전달하는 메서드
//    public static CrimeFragment newInstance(UUID crimeId){
//        // 번들 생성
//        Bundle args = new Bundle();
//        // 아이디(키)에 받아온 값을 저장한다.
//        args.putSerializable(ARG_CRIME_ID,crimeId);
//
//        // 프래그 먼드를 재호출 한다.
//        CrimeFragment fragment = new CrimeFragment();
//
//        // 프래그먼트에 번들 값을 저장한다.
//        fragment.setArguments(args);
//
//        // 프래그먼트를 전달한다.
//        return fragment;
//    }
//    // 프래그먼트를 생성한다. 번블에 이전 정보들을 넣어놓으면 여기서 불러올수도 있다.
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        // 번블을 불러온다.
//        super.onCreate(savedInstanceState);
//        // 랜덤한 고유의 UUID를 얻어올수 있다.(생성시마다 다른값을 가져온다.)
////        mCrime = new Crime();
//        // getActivity().getIntent() 인텐트 값을 받아라(실행)
//        // .getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID); 어떤인텐트를 받을거다(인텐트를 날릴때 보낸키값)
////        UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);
//        // 인텐트로 전달 받은 UUID를 가지고 CrimeLap에서 데이터를 불러온다
////        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
//
//        // 번들로 전달되어 온값을 받아 저장한다.
//        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
//        // 번들로 전달 받은 UUID를 가지고 CrimeLap에서 데이터를 불러온다
//        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
//    }
//
//    // 프래그먼트 뷰를 생성 한다.
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
//    {
//        // 프래그먼트를 생성할 메인 레이아웃을 불러온다.
//        View v = inflater.inflate(R.layout.fragment_crime,container,false);
//
//        // 레이아웃으 객체들을 불러와 이벤트를 사용한다.
//        mTitleField = (EditText)v.findViewById(R.id.crim_title);
//        // 인텐트로 받은 값으로 뷰의 값을 초기화 한다.
//        mTitleField.setText(mCrime.getmTitle());
//        mTitleField.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                mCrime.setmTitle(charSequence.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        mDateButton = (Button)v.findViewById(R.id.crime_date);
////        mDateButton.setText(mCrime.getmDate().toString());
//        updateDate();
////        mDateButton.setEnabled(false);
//        // 버튼을 클릭 이벤트를 받는다.(선언)
//        mDateButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                // 프래그먼트를 불러오기위한 매니저 생성
//                FragmentManager manager = getFragmentManager();
//                // 프래그먼트 다이얼로그를 생성한다.
////                DatePickerFragment dialog = new DatePickerFragment();
//                // 프래그먼트 다이얼로그 생성시 현재값을 다이얼로그로 보낸다.
//                DatePickerFragment dialog = DatePickerFragment.newInstance(mCrime.getmDate());
//                // 호출한 프래그 먼트의 인자값을 타겟으로 알려준다.
//                dialog.setTargetFragment(CrimeFragment.this,REQUEST_DATE);
//                // 프래그먼트 다이얼로그를 띄운다.(프래그매니저,다이얼로그아이디)
//                dialog.show(manager,DIALOG_DATE);
//            }
//        });
//        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
//        mSolvedCheckBox.setChecked(mCrime.ismSolved());
//        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                mCrime.setmSolved(b);
//            }
//        });
//        return v;
//    }
//}