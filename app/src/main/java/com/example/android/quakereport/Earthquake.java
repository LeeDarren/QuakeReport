package com.example.android.quakereport;

/**
 * Created by Darren on 1/26/2017.
 */

public class Earthquake {

    private String mLocation; //place of earthquake in text
    private double mMagnitude;
    private long mTimeInMilliseconds; //time/date in text
    private String mUrl;

    /**
     * Constructs a new (@link Earthquake) object
     * @param magnitude is the magnitude of the earthquake
     * @param location the text description of the location of the earthquake
     * @param TimeInMilliseconds is the time of earthquake in Epochtime
     * @param url is a url of the usgs website data for this earthquake
     */
    public Earthquake(double magnitude, String location, long TimeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = TimeInMilliseconds;
        mUrl = url;
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

    public String getUrl() { return mUrl; }
}
