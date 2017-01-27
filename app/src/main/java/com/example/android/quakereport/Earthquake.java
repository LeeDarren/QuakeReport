package com.example.android.quakereport;

/**
 * Created by Darren on 1/26/2017.
 */

public class Earthquake {

    String mPlace; //place of earthquake in text
    double mMagnitude;
    String mDate; //time/date in text

    public Earthquake(double magnitude, String place, String date){
        mMagnitude=magnitude;
        mPlace=place;
        mDate=date;
    }
}
