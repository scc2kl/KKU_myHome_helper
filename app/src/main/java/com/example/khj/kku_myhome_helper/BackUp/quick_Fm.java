package com.example.khj.kku_myhome_helper.BackUp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khj.kku_myhome_helper.Activity.FmActivity;
import com.example.khj.kku_myhome_helper.Data.SingleTon;
import com.example.khj.kku_myhome_helper.R;
import com.getbase.floatingactionbutton.FloatingActionsMenu;


public class quick_Fm extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_roomlist, container, false);
//        listView = (Re) view.findViewById(R.id.listView);
        RecyclerView mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.main_book_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
////        fab.setVisibility(View.VISIBLE);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "안녕 안녕", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        final View actionA = view.findViewById(R.id.action_a);
        final View actionB = view.findViewById(R.id.action_b);
//        com.getbase.floatingactionbutton.FloatingActionButton actionC =
//                new com.getbase.floatingactionbutton.FloatingActionButton(getActivity());
//        actionC.setTitle("두번째 매뉴를 감춥니다.");
//        actionC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
//            }
//        });
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FmActivity.newIntent(getActivity(), SingleTon.FM_ROOMADD);
                startActivity(intent);
            }
        });
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FmActivity.newIntent(getActivity(), SingleTon.FM_ITEMADD);
                startActivity(intent);
            }
        });


        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) view.findViewById(R.id.multiple_actions);

//        menuMultipleActions.addButton(actionC);
//        menuMultipleActions.setVisibility(View.GONE);
        return view;
    }
    public static int convertPixelsToDp(float px, Context context) {
        int value = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, context.getResources().getDisplayMetrics());
        return value;
    }

}