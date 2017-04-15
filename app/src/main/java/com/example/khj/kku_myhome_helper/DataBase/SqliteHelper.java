package com.example.khj.kku_myhome_helper.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;

public class SqliteHelper extends SQLiteOpenHelper {

    Context mContext;
    String dbName, sql;
    SQLiteDatabase.CursorFactory mfactory;
    int mVersion;
    String[] mTableSql;
    public static SQLiteDatabase mDB;
    private SqliteHelper mDBHelper;
    SQLiteStatement smt;

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음

    /**
     * @param context 요청 컨텍스트
     * @param name    DB 이름
     * @param factory 정확히 모름
     * @param version 버전 정보
     */
    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
        this.dbName = name;
        this.mfactory = factory;
        this.mVersion = version;
    }

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음 생성 쿼리를 추가로 받음

    /**
     * @param context  요청 컨텍스트
     * @param name     DB 이름
     * @param factory  정확히 모름
     * @param version  버전 정보
     * @param TableSql 생성할 테이블의 정보를 저장하는 배열 String 하나당 하나의 테이블 생성
     */
    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, String[] TableSql) {
        super(context, name, factory, version);
        mContext = context;
        dbName = name;
        mfactory = factory;
        mVersion = version;
        mTableSql = TableSql;
        mDBHelper = new SqliteHelper(mContext, name, null, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        if (mTableSql == null) {
            mTableSql = new String[2];
            mTableSql[0] = "CREATE TABLE USER (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ",userId varchar2 not null unique" +
                    ",passwd varchar2 not null" +
                    ",email varchar2 not null)";

            mTableSql[1] = "CREATE TABLE USERGROUP (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ",userId varchar2 not null unique" +
                    ",passwd varchar2 not null" +
                    ",email varchar2 not null)";
        }
        for (int i = 0; i < mTableSql.length; i++) {
            Log.e("DB 생성 확인", mTableSql[i]);
            db.execSQL(mTableSql[i]);
        }
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * @param table  테이블이름
     * @param Values 입력할 데이터
     */
    public void insert(String table, String[] Values) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가

        sql = "SELECT * FROM " + table + ";";
        Cursor cursor = db.rawQuery(sql, null);
        String incolumn = "";
        String inValue = "";
        for (int i = 1; i < cursor.getColumnCount(); i++) {
            if (i == 1) {
                incolumn = cursor.getColumnNames()[i];
                inValue = "?";
            } else {// 0은 자동증가로 제외
                incolumn += "," + cursor.getColumnNames()[i];
                inValue += ",?";
            }
        }
        sql = "INSERT INTO " + table + "(" + incolumn + ") VALUES(" + inValue + ");";
        smt = db.compileStatement(sql);
        for (int i = 0; i < Values.length; i++) {
            smt.bindString((i + 1), Values[i]);
        }
        smt.executeInsert();
        db.close();
    }

    /**
     * @param table  테이블이름
     * @param Values 변경데이터(순서대로)
     * @param wheres 조건문
     */
    public void update(String table, String[] Values, String wheres) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table, null);
        String inValue = null;
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            if (i == 1) {
                inValue = cursor.getColumnNames()[i] + "=" + Values[i];
            } else if (i != 0) {// 0은 자동증가로 제외
                inValue += "," + cursor.getColumnNames()[i] + "=" + Values[i];
            }
        }
        sql = "UPDATE " + table + " SET " + inValue + " " + wheres + ";";
        // 입력한 항목과 일치하는 행의 정보 수정
        db.execSQL(sql);
        db.close();

    }

    /**
     * 입력한 항목과 일치하는 행 삭제
     *
     * @param table  삭제작업 타겟 테이블
     * @param wheres 삭제할 행
     */
    public void delete(String table, String wheres) {
        SQLiteDatabase db = getWritableDatabase();
        sql = "DELETE FROM " + table + " " + wheres + ";";
        db.execSQL(sql);
        db.close();
    }

    /**
     * 검색한 테이블의 내용을 리스트에 배열으로 행을 저장한다.
     *
     * @param table
     * @return
     */
    public ArrayList<String[]> select(String table) {
        /**
         * @param db       DB호출
         * @param columns  내용을 저장하는 List
         * @param cursor   커서 생성
         * @param data     데이터 저장
         */
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String[]> columns = new ArrayList<String[]>();

        sql = "select * FROM " + table + ";";
        Cursor cursor = db.rawQuery(sql, null);

        String[] data = new String[cursor.getColumnCount()];
        while (cursor.moveToNext()) {
            /**
             * 모든데이터를 String배열에 넣어줌
             */
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                data[i] = cursor.getString(i);
                Log.e("모두뿌려준다 " + i + "번째", data[i]);
            }
            columns.add(data);
        }
        db.close();
        return columns;
    }

    /**
     * 테이블에서 필요한 값을 추출한다.
     *
     * @param column     추출할 컬럼
     * @param table      테이블 이름
     * @param wheres     조건문 ex) where id =?
     * @param whereitemp 조건문에 들어갈 값(위의 ? 대응)
     * @return
     */
    public String[] pointselect(String column, String table, String wheres, String whereitemp) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor;
        String[] value;
        sql = "SELECT " + column + " FROM " + table + " " + wheres + ";";
        Log.e("이게 무슨일입니까!!!!! ", "...왜 아래꺼는 안찍히나??" + sql);
        if (!whereitemp.equals("") && whereitemp != null) {
            cursor = db.rawQuery(sql, new String[]{whereitemp});
        } else {
            cursor = db.rawQuery(sql, null);
        }

        value = new String[cursor.getColumnCount()];
        while (cursor.moveToNext()) {
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                value[i] = cursor.getString(i);
                Log.e("모두뿌려준다 " + i + "번째", cursor.getString(i));
            }
        }

        db.close();
        return value;
    }

    /**
     * 테이블의 컬럼이 몇개인지 확인한다.
     *
     * @param table 테이블 이름
     * @return
     */
    public int columnCount(String table) {
        SQLiteDatabase db = getReadableDatabase();
        sql = "SELECT * FROM " + table + ";";
        Cursor cursor = db.rawQuery(sql, null);
        int Values = cursor.getColumnCount();
        db.close();
        return Values;
    }

    /**
     * 테이블의 컬럼 이름을 전부 전달한다.
     *
     * @param table 테이블명
     * @return
     */
    public String[] columnNames(String table) {
        SQLiteDatabase db = getReadableDatabase();
        sql = "select * FROM " + table + ";";
        Cursor cursor = db.rawQuery(sql, null);
        String[] Values = cursor.getColumnNames();
        db.close();
        return Values;
    }

    /**
     * 테이블의 행갯수를 전달한다.
     *
     * @param table 테이블명
     * @return
     */
    public int lowCount(String table, String wheres) {
        SQLiteDatabase db = getReadableDatabase();
        sql = "select id FROM " + table + " " + wheres + ";";
        Cursor cursor = db.rawQuery(sql, null);
        int Values = cursor.getCount();
        db.close();
        return Values;
    }

    /**
     * 키값으로 사용되는 컬럼에 같은 값이 들어오는지 확인한다.
     *
     * @param table  테이블 명
     * @param culunm 컬럼 명
     * @param check  컬럼 값
     * @return
     */
    public boolean checker(String table, String culunm, String check) {
        SQLiteDatabase db = getWritableDatabase();
        sql = "SELECT * FROM " + table + " where " + culunm + "=?;";
        Cursor cursor = db.rawQuery(sql, new String[]{check});
        if (cursor.moveToNext()) {
            db.close();
            return false;
        }
        db.close();
        return true;
    }

    public SqliteHelper open() throws SQLException {
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDB.close();
    }
}


