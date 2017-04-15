package com.example.khj.kku_myhome_helper.Data;

import java.util.Date;
import java.util.UUID;

/**
 * Created by KHJ on 2017-04-11.
 * 프래그먼트뷰에 필요한 리소스들을 생성한다.
 */

public class BoxDataSet {
    // 생성자
    public BoxDataSet() {
        this(UUID.randomUUID());
        // 생성 될때마다 고유한 ID를 부여한다.
//        mId = UUID.randomUUID();
        // 생성 될때 날짜데이터를 바로 넣을수 있게 초기화 한다.
//        mDate = new Date();
    }

    public BoxDataSet(UUID id)
    {
        mId = id;
        mDate = new Date();
    }
    // 고유값을 가지는 변수(ID로 생각할수 있다.)
    private UUID mId;
    // 아이디의 변경은 불가능 하고 가져올수만 있다.
    public UUID getmId() {
        return mId;
    }

    // 타이틀 텍스트에 사용한다.
    private String mTitle;
    // 저장된 타이틀 텍스트 불러오기
    public String getmTitle() {
        return mTitle;
    }

    // 타이틀 텍스트 저장
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    // 날짜를 저장하는 변수생성
    private Date mDate;
    // 저장된 날짜데이터를 불러온다
    public Date getmDate() {
        return mDate;
    }

    // 날짜 데이터를 변경한다.
    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    // 체크 박스등에 사용되는 성공,실패(선택 미선택)을 나타내는 변수
    private boolean mSolved;
    // 성공 실패 값을 불러온다.
    public boolean ismSolved() {
        return mSolved;
    }
    // 성공 실패여부를 저장한다.
    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
