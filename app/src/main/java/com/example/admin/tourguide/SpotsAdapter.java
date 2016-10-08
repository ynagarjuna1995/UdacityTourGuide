package com.example.admin.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 9/26/2016.
 */

class ViewHolder {
    TextView spotName;
    TextView spotDesc;
    ImageView spotImage;
}

public class SpotsAdapter extends ArrayAdapter<Spots> {

    public SpotsAdapter(Activity context, ArrayList<Spots> spots) {
        super(context, 0, spots);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            // inflate the layout
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.spotName = (TextView) convertView.findViewById(R.id.spot_name);
            viewHolder.spotDesc = (TextView) convertView.findViewById(R.id.spot_desc);
            viewHolder.spotImage = (ImageView) convertView.findViewById(R.id.spot_image);

            // store the holder with the view.
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // object item based on the position
        Spots currentSpot = getItem(position);

        // assign values if the object is not null
        if (currentSpot != null) {
            // get the views from the ViewHolder and then set the values
            viewHolder.spotName.setText(currentSpot.getSpotName());
            viewHolder.spotDesc.setText(currentSpot.getSpotDescription());
            viewHolder.spotImage.setImageResource(currentSpot.getImageResourseId());
        }

        return convertView;

    }
}
