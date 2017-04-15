package com.example.khj.kku_myhome_helper.Data;

import java.util.Date;
import java.util.UUID;

/**
 * Created by KHJ on 2017-04-11.
 * 프래그먼트뷰에 필요한 리소스들을 생성한다.
 */

public class listItemDataSet {

    // 생성자
    public listItemDataSet(int type) {
        // 최초 생성시에는 랜덤한 값으로 ID를 설정한다.
        this(UUID.randomUUID());
        // 최초 생성시 날짜를 저장한다.
        mDate = new Date();
        // 생성시 type을 지정하며 생성한다.
        mType = type;
    }

    public listItemDataSet(UUID id)
    {
        // 데이터를 가져와서 셋팅할때는 받아온 id값을 지정한다.
        mId = id;
    }
    // 고유값을 가지는 변수(ID로 생각할수 있다.)
    private UUID mId;
    // 아이디의 변경은 불가능 하고 가져올수만 있다.
    public UUID getmId() {
        return mId;
    }

    // 메인 이미지 경로
    private String mImage;
    // 메인 이미지 불러오기
    public String getmImage() {
        return mImage;
    }
    // 메인 이미지 경로 재저장
    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    // 타이틀 텍스트
    private String mTitle;
    // 저장된 타이틀 텍스트 불러오기
    public String getmTitle() {
        return mTitle;
    }

    // 타이틀 텍스트 저장
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    // 아이템 경로(방의 경우 우리집)
    private String mPos;

    public String getmPos() {
        return mPos;
    }

    public void setmPos(String mPos) {
        this.mPos = mPos;
    }

    // 아이템에 대한 설명
    private String mExp;

    public String getmExp() {
        return mExp;
    }

    public void setmExp(String mExp) {
        this.mExp = mExp;
    }

    // 방,가구,아이템(타입) 확인
    // 1 방 2 가구 3 아이템
    private int mType;

    public int getmType() {
        return mType;
    }

    // 아이템을 생성한 최초 날짜.
    private Date mDate;

    public Date getmDate() {
        return mDate;
    }

}
