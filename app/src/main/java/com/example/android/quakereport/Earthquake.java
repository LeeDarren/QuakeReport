package com.example.android.quakereport;

/**
 * Created by Darren on 1/26/2017.
 */

public class Earthquake {

    private String mPlace; //place of earthquake in text
    private double mMagnitude;
    private long mTimeInMilliseconds; //time/date in text

    public Earthquake(double magnitude, String place, long TimeInMilliseconds) {
        mMagnitude = magnitude;
        mPlace = place;
        mTimeInMilliseconds = TimeInMilliseconds;
    }

    public String getPlace() {
        return mPlace;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
