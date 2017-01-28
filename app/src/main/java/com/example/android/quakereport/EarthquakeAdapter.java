package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

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
        TextView magnitudeText = (TextView) convertView.findViewById(R.id.magnitude_text);
        magnitudeText.setText(String.format(Locale.US, "%.1f", earthquake.getMagnitude()));

        //Setup the place
        TextView placeText = (TextView) convertView.findViewById(R.id.place_text);
        placeText.setText(earthquake.getPlace());

        //Setup the date
        TextView dateText = (TextView) convertView.findViewById(R.id.date_text);
        dateText.setText(earthquake.getDate());

        //Setup the place
        return convertView;
    }
}
