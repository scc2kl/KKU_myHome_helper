//package com.example.khj.kku_myhome_helper.Fragment;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.khj.hoom_helper.Data.CrimeLab;
//import com.example.khj.hoom_helper.R;
//
//import java.util.List;
//
///**
// * Created by KHJ on 2017-04-11.
// * 리사이클뷰 프래그먼트 생성
// */
//
//public class CrimeListFragment extends Fragment {
//    // 리사이클뷰 생성
//    private RecyclerView mCrimeRecyclerView;
//    // 리사이클뷰 어뎁터 생성
//    private CrimeAdapter mAdapter;
//    // 리소스 인텐트에 사용되는 값
//    private static final int REQUEST_CRIME = 1;
//
//    // 서브타이틀을 보여줄지 말지를 선택한다.
//    private boolean mSubtitleVisible;
//
//    // 번들에 저장할때 사용할 키값
//    private static final String SAVED_SUBTUTLE_VISIBLE = "subtitle";
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // 매뉴를 표시하는것을 허락한다.
//        setHasOptionsMenu(true);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // 리사이클뷰를 포함한 레이아웃 가져오기
//        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
//        // 레이아웃의 리사이클뷰 가져오기
//        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
//
//        /**
//         * 리사이클뷰를 사용하기위해 매니저를 설정해준다.(해당부분이 지정되지 않으면 실행되지 않음)
//         * 여기서는 리니어레이아웃을 사용하여 리스트 형태를 표기해 준다.
//         * GridLayoutManger를 사용하는경우 격자 형태로 변경 가능하다.
//         */
//        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        // 다시 불러왔을때 번들에 값이 있다면 해당 값으로 필요한 값을 초기화 해준다.
//        if(savedInstanceState != null){
//            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTUTLE_VISIBLE);
//        }
//        return view;
//    }
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        // 번들에 필요한 값을 저장한다.
//        // 오브젝트 타입이므로 아무거나 넣을수 있다.
//        // put옵션을 변경하여 변수타입 지정 가능
//        outState.putBoolean(SAVED_SUBTUTLE_VISIBLE,mSubtitleVisible);
//    }
//
//    private void updateUI() {
//        // 전역 변수(데이터)를 저장한 crimeLab이라는 클래스를 불러온다.
//        // 해당 클래스는 Context를 받아 작업하기 때문에 엑티비티값을 넘겨준다.
//        CrimeLab crimeLab = CrimeLab.get(getActivity());
//        // 리스트를 생성한 후 전역변수의 데이터를 받아온다.
//        // 현재는 임의로 데이터를 전역변수에서 생성하게 해놓았다.(추가,수정,삭제 불가)
//        List<Crime> crimes = crimeLab.getmCrimes();
//
//        if (mAdapter == null) {
//            //어뎁터에 사용할 데이터를 보내준다.
//            mAdapter = new CrimeAdapter(crimes);
//
//            // 리사이클뷰에 어뎁터를 할당한다.
//            mCrimeRecyclerView.setAdapter(mAdapter);
//        } else {
//            mAdapter.setCrimes(crimes);
//            mAdapter.notifyDataSetChanged();
//        }
//        updateSubtitle();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        updateUI();
//    }
//
//
//    // 옵션 매뉴(툴바)를 생성 한다.
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        // 메뉴 리소스를 가져온다.
//        inflater.inflate(R.menu.fragment_crime_list, menu);
//
//        MenuItem subtitleItem = menu.findItem(R.id.menu_item_show_subtitle);
//        if(mSubtitleVisible){
//            subtitleItem.setTitle(R.string.hide_title);
//        }else{
//            subtitleItem.setTitle(R.string.show_subtitle);
//        }
//    }
//
//    // 매뉴 선택 이벤트 처리
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // 선택된 이벤트를 받는다.
//        switch (item.getItemId()) {
//            // 선택된 이벤트가 어떤 값을 가지는지 확인한다.
//            case R.id.menu_item_new_crime:
//                // 이벤트시 동작
//                Crime crime = new Crime();
//                CrimeLab.get(getActivity()).addCrime(crime);
//                Intent intent = CrimePagerActivity.newIntent(getActivity(), crime.getmId());
//                startActivity(intent);
//                return true;
//            case R.id.menu_item_show_subtitle:
//                mSubtitleVisible = !mSubtitleVisible;
//                getActivity().invalidateOptionsMenu();
//                updateSubtitle();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//
//    }
//
//    // 서브타이틀 보여주기
//    private void updateSubtitle(){
//        // 크레임랩에서 저장되어 있는 데이터값(데이터갯수)을 가져온다.
//        CrimeLab crimeLab = CrimeLab.get(getActivity());
//        int crimeCount = crimeLab.getmCrimes().size();
//        // 서브타이틀에 숫자 건 으로 이루어진 값을 업데이트 한다.
//        String subtitle = getString(R.string.subtitle_format,crimeCount);
//        if(!mSubtitleVisible){
//            subtitle=null;
//        }
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        // 엑션바에 서브 타이틀을 추가한다.
//        activity.getSupportActionBar().setSubtitle(subtitle);
//    }
//
//    // 간단한 뷰홀더 구현
//    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        // 텍스트뷰 생성
////        public TextView mTitleTextView;
//        // 생성한 레이아웃에 맞게 뷰들을 생성
//        private TextView mTitleTextView;
//        private TextView mDateTextView;
//        private CheckBox mSolvedCheckBox;
//        // 데이터를 받아서 값을 초기화할 클래스를 생성한다.
//        Crime mCrime;
//
//        // 뷰홀더 생성시
//        public CrimeHolder(View itemView) {
//            super(itemView);
//            // 현재는 텍스트뷰 하나만 있는 뷰이기 때문에 아래와 같이 가능하다.
//            // 레이아웃을 가져온경우 인플레이트를 다시 하고 뷰마다 다른 값을 가져다가 쓸수도 있다.
////            mTitleTextView = (TextView) itemView;
//            //이젠 메인 뷰에서 하위 뷰를 찾아온다
//            itemView.setOnClickListener(this);
//            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
//            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
//            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);
//        }
//
//        public void bindCrime(Crime crime) {
//            mCrime = crime;
//            mTitleTextView.setText(mCrime.getmTitle());
//            mDateTextView.setText(mCrime.getmDate().toString());
//            mSolvedCheckBox.setChecked(mCrime.ismSolved());
//        }
//
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(getActivity(), mCrime.getmTitle() + " 선택 됨!!! ", Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(getActivity(),CrimeActivity.class);
//
//            // 인텐트 생성 스테틱 메서트를 호출하여 UUID값을 전달해 준다.(엑티비티 Context,전달값)
//            // 해당값으로 생성된 인텐트를 가져온다.
////            Intent intent = CrimeActivity.newIntent(getActivity(),mCrime.getmId());
//
//            // 인텐트 생성 스테틱 메서트를 호출하여 UUID값을 전달해 준다.(엑티비티 Context,전달값)
//            // 해당값으로 생성된 인텐트를 가져온다. pagerActivity를 불러오도록 변경 한다.
//            Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.getmId());
//            // 엑티비티를 불러오는 인텐트 실행
////            startActivity(intent);
//            // 엑티비티를 불러오며 값을 전달하는 인텐트 실행
//            startActivityForResult(intent, REQUEST_CRIME);
//        }
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_CRIME) {
//            Toast.makeText(getActivity(), "크하하하", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void returnResult() {
//        getActivity().setResult(Activity.RESULT_OK, null);
//    }
//
//    // 어뎁터 생성 상속시 뷰홀더를 지정한다. RecyclerView.Adapter<CrimeHolder>
//    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
//        // 어뎁터에서 사용할 리스트 생성
//        private List<Crime> mCrimes;
//
//        // 어뎁터 생성시 전달받을값
//        public CrimeAdapter(List<Crime> crimes) {
//            mCrimes = crimes;
//        }
//
//        //리스트 항목에 보여줄 새로운 View가 필요한경우 뷰홀더를 불러온다.
//        @Override
//        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//            /**
//             * 화면을 불러올때 사용할 엑티비티를 찾는다 현재는 프래그먼트에 같이 생성되어 있어
//             * 해당 프래그먼트를 불러온 엑티비티의 값을 가진다.LayoutInflater.from(Context)
//             */
//            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
//
//            // 엑티비티에 레이아웃을 하나 가져와서 사용가능하게 요청한다.
//            // 텍스트 뷰하나만 있는 기본제공 레이아웃이다.
//            // View view = layoutInflater.inflate(android.R.layout.simple_list_item_1,parent,false);
//            // 새로 생성한 레이아웃으로 사용요청
//            // 텍스트2개와 체크박스로 이루어짐 뷰홀더도 변경 필요
//            View view = layoutInflater.inflate(R.layout.list_item_crime, parent, false);
//            /**
//             * 뷰홀더에 레이아웃뷰를 전달한다.
//             * 뷰홀더에 맞는 레이아웃을 전달해야 한다.
//             */
//            return new CrimeHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(CrimeHolder holder, int position) {
//            // 뷰홀더의 위치데이터를 인자로 전달 받는다.
//            Crime crime = mCrimes.get(position);
////            if(holder.getAdapterPosition()!=RecyclerView.NO_POSITION){
////                mAdapter.notifyItemChanged(holder.getAdapterPosition());
////            }
//            // 그값으로 뷰홀더의 텍스트 값을 변경하도록 한다.
////            holder.mTitleTextView.setText(crime.getmTitle());
//            // 뷰홀더가 변경되어 데이터를 클래스로 받는다.
//            holder.bindCrime(crime);
//        }
//
//        @Override
//        public int getItemCount() {
//            // 만들어질 리스트가 몇개인지 표기한다 보통 리스트의 갯수로 한다.
//            return mCrimes.size();
//        }
//        public void setCrimes(List<Crime> crimes){
//            mCrimes =crimes;
//        }
//    }
//
//}
