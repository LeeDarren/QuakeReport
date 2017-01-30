package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.Locale;

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
        TextView magnitudeText = (TextView) convertView.findViewById(R.id.magnitude);
        magnitudeText.setText(String.format(Locale.US, "%.1f", earthquake.getMagnitude()));

        //Setup the place
        TextView placeText = (TextView) convertView.findViewById(R.id.location);
        placeText.setText(earthquake.getPlace());

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
}
