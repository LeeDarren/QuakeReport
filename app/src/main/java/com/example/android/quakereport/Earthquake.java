package com.example.android.quakereport;

/**
 * Created by Darren on 1/26/2017.
 */

public class Earthquake {

    private String mLocation; //place of earthquake in text
    private double mMagnitude;
    private long mTimeInMilliseconds; //time/date in text

    public Earthquake(double magnitude, String location, long TimeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = TimeInMilliseconds;
    }

    public String getLocation() {
        return mLocation;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
