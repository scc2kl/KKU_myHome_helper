package com.example.khj.kku_myhome_helper.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.khj.kku_myhome_helper.Fragment.iteManager_fm;
import com.example.khj.kku_myhome_helper.Fragment.itemAdd_fm;
import com.example.khj.kku_myhome_helper.Fragment.login_fm;
import com.example.khj.kku_myhome_helper.Fragment.myPage_fm;
import com.example.khj.kku_myhome_helper.Fragment.roomAdd_fm;
import com.example.khj.kku_myhome_helper.Fragment.search_fm;
import com.example.khj.kku_myhome_helper.Fragment.setting_fm;
import com.example.khj.kku_myhome_helper.Fragment.sginup_fm;

import static com.example.khj.kku_myhome_helper.Data.SingleTon.*;


public class FmActivity extends SingleFragmentActivity {

    // 인텐트 값을 받을때 사용할 키값 지정
    private static final String EXTRA_FM_ID = "com.example.khj.kku_myhome_helper.Activity.FmActivity";

    /**
     * 이 엑티비티는 프래그먼트 중개 엑티비티로 무조건 호출시 newIntent을 사용해야한다.
     * @param packageContext 요청한 컨텍스트
     * @param fmName 프래그먼트 이름(SingleTon에 기록이되어 있다.)
      */
    public static Intent newIntent(Context packageContext, int fmName){
        // 이 클래스로 오는 인텐트를 생성
        Intent intent = new Intent(packageContext,FmActivity.class);
        // 클래스로 올때 프래그먼트ID값을 보낸다.
        intent.putExtra(EXTRA_FM_ID,fmName);
        return intent;
    }
    @Override
    protected Fragment createFragment(){

        int fmName = (int)getIntent().getSerializableExtra(EXTRA_FM_ID);
        Fragment fm = new Fragment();
        switch (fmName) {
            case FM_LOGIN:
                fm = new login_fm();
                break;
            case FM_SGINUP:
                fm = new sginup_fm();
                break;
            case FM_SETTING:
                fm = new setting_fm();
                break;
            case FM_SEARCH:
                fm = new search_fm();
                break;
            case FM_MYPAGE:
                fm = new myPage_fm();
                break;
            case FM_ROOMADD:
                fm = new roomAdd_fm();
                break;
            case FM_ITEMADD:
                fm = new itemAdd_fm();
                break;
            case FM_ITEMANAGER:
                fm = new iteManager_fm();
                break;
        }
        return fm;
    }

}
