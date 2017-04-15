//package com.example.khj.kku_myhome_helper.DataBase;
//
//import android.database.Cursor;
//import android.database.CursorWrapper;
//
//import com.example.khj.kku_myhome_helper.DataBase.CrimeDbSchema.CrimeTable;
//import com.example.khj.kku_myhome_helper.Other.Crime;
//
//import java.util.Date;
//import java.util.UUID;
//
//public class CrimeCursorWrapper extends CursorWrapper {
//    public CrimeCursorWrapper(Cursor cursor) {
//        super(cursor);
//    }
//
//    public Crime getCrime() {
//        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
//        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
//        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
//        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
//
//        Crime crime = new Crime(UUID.fromString(uuidString));
//        crime.setmTitle(title);
//        crime.setmDate(new Date(date));
//        crime.setmSolved(isSolved != 0);
//
//        return crime;
//
//    }
//}