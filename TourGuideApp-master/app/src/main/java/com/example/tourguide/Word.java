package com.example.tourguide;

public class Word {
    public boolean isOpen = false;
    private String mTitleOFinformation;
    private String mIformation;
    private String mLocation;
    private String mlocationForParsing;
    private  String mPhoneNumber;
    private int mImageResId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String titleInfo, String information, String location ,  int ImageResId,  String locationForParsing ){
        mTitleOFinformation=titleInfo;
        mIformation= information;
        mImageResId=ImageResId;
        mLocation=location;
        mlocationForParsing="geo:" + locationForParsing + "?20";


    }
    public Word(String titleInfo, String information, String location ,  int ImageResId,  String locationForParsing,String PhoneNumber  ){
        mTitleOFinformation=titleInfo;
        mIformation= information;
        mImageResId=ImageResId;
        mLocation=location;
        mlocationForParsing="geo:" + locationForParsing + "?20";
        mPhoneNumber = "tel:" +PhoneNumber;


    }



    public String getTitleOFinformation(){
        return mTitleOFinformation;
    }
    public String getIformation(){
        return mIformation;
    }

    public int getmImageResId(){
        return mImageResId;
    }
    public String getmLocation(){
        return mLocation;
    }
    public String getmlocationForParsing(){
        return mlocationForParsing;
    }
    public String getmPhoneNumber(){
        return mPhoneNumber;
    }

}
