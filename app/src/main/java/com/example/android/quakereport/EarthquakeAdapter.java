package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.RotateDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

/**
 * Array Adapter to display Earthquake class data in a listview
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        //Get the data
        Earthquake earthquake = getItem(position);

        //Setup the magnitude
        //Get the view
        TextView magnitudeText = (TextView) convertView.findViewById(R.id.magnitude);
        //Set the text
        magnitudeText.setText(String.format(Locale.US, "%.1f", earthquake.getMagnitude()));
        //Find the circle and change color
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeColor = ContextCompat.getColor(getContext(), magnitudeColor);
        magnitudeCircle.setColor(magnitudeColor);

        //Setup the location data
        String fullLocation = earthquake.getLocation();
        TextView locationOffsetView = (TextView) convertView.findViewById(R.id.location_offset);
        TextView primaryLocationView = (TextView) convertView.findViewById(R.id.primary_location);
        String locationOffset;
        String primaryLocation;
        //See if it has an offset, by looking for "of"
        if(fullLocation.contains("of")){
            //Include everything from the start to the end of "of"
            locationOffset = fullLocation.substring(0, fullLocation.indexOf("of")+2);
            //Everything from after "of"
            primaryLocation = fullLocation.substring(fullLocation.indexOf("of")+3);
        }else{
            locationOffset = getContext().getString(R.string.near_the); //just call it near the
            primaryLocation = fullLocation; // and the location
        }
        //Set the text
        locationOffsetView.setText(locationOffset);
        primaryLocationView.setText(primaryLocation);

        //Setup the date
        TextView dateText = (TextView) convertView.findViewById(R.id.date);
        Date date = new Date(earthquake.getTimeInMilliseconds());
        dateText.setText(formatDate(date));
        //Setup the time
        TextView timeText = (TextView) convertView.findViewById(R.id.time);
        timeText.setText(formatTime(date));

        //Setup the place
        return convertView;
    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Returns a color for different magnitude
     * @param magnitude
     * @return a color
     */
    private int getMagnitudeColor(double magnitude){
        int intMagnitude = (int) magnitude; //convert to int without rounding
        switch (intMagnitude){
            case 0:
            case 1:
                return R.color.magnitude1;
            case 2:
                return R.color.magnitude2;
            case 3:
                return R.color.magnitude3;
            case 4:
                return R.color.magnitude4;
            case 5:
                return R.color.magnitude5;
            case 6:
                return R.color.magnitude6;
            case 7:
                return R.color.magnitude7;
            case 8:
                return R.color.magnitude8;
            case 9:
                return R.color.magnitude9;
            case 10:
            default:
                return R.color.magnitude10plus;
        }
    }
}
