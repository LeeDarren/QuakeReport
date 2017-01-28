package com.example.android.quakereport;

/**
 * Created by Darren on 1/26/2017.
 */

public class Earthquake {

    private String mPlace; //place of earthquake in text
    private double mMagnitude;
    private String mDate; //time/date in text

    public Earthquake(double magnitude, String place, String date){
        mMagnitude=magnitude;
        mPlace=place;
        mDate=date;
    }

    public String getPlace(){ return mPlace;}
    public double getMagnitude(){ return mMagnitude;}
    public String getDate(){ return mDate;}
}
