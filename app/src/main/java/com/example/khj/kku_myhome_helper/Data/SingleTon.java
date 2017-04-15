package com.example.khj.kku_myhome_helper.Data;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.khj.kku_myhome_helper.Fragment.*;

import com.example.khj.kku_myhome_helper.DataBase.SqliteHelper;

public class SingleTon {
    private static SingleTon singleTon;
    private SqliteHelper mDatabase;
    private static Context mContext;

    final public static int FM_LOGIN = 0;
    final public static int FM_SGINUP = 1;
    final public static int FM_SETTING = 2;
    final public static int FM_SEARCH = 3;
    final public static int FM_MYPAGE = 4;
    final public static int FM_ROOMADD = 5;
    final public static int FM_ITEMADD = 6;
    final public static int FM_ITEMANAGER = 7;

    final public static int ITEM_ROOM = 1;
    final public static int ITEM_BOX = 2;
    final public static int ITEM_ITEM = 3;


    private static class Singleton {
        private static final SingleTon instance = new SingleTon(mContext);
    }


    public static SingleTon getInstance(Context context) {
        if (singleTon == null) {
            singleTon = new SingleTon(context);
        }
        return Singleton.instance;
    }

    private SingleTon(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new SqliteHelper(mContext);
    }

    public SqliteHelper getDbHelper() {
        return mDatabase;
    }
}