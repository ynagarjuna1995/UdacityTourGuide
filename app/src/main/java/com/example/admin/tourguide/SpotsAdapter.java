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

public class SpotsAdapter extends ArrayAdapter<Spots> {

    public SpotsAdapter(Activity context, ArrayList<Spots> spots) {
        super(context, 0, spots);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Spots currentTopSpot = getItem(position);

        TextView spotName = (TextView) listItemView.findViewById(R.id.spot_name);

        spotName.setText(currentTopSpot.getSpotName());

        TextView spotDescription = (TextView) listItemView.findViewById(R.id.spot_desc);

        spotDescription.setText(currentTopSpot.getSpotDescription());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        imageView.setImageResource(currentTopSpot.getImageResourseId());

        return listItemView;
    }
}
