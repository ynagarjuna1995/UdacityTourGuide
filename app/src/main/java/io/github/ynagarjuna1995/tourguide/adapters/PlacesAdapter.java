package io.github.ynagarjuna1995.tourguide.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.ynagarjuna1995.tourguide.Places;
import io.github.ynagarjuna1995.tourguide.R;

import java.util.ArrayList;


class ViewHolder {
    TextView spotName;
    TextView spotDesc;
    ImageView spotImage;
}

public class PlacesAdapter extends ArrayAdapter<Places> {

    public PlacesAdapter(Activity context, ArrayList<Places> spots) {
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
            viewHolder.spotName = (TextView) convertView.findViewById(R.id.place_name);
            viewHolder.spotDesc = (TextView) convertView.findViewById(R.id.place_desc);
            viewHolder.spotImage = (ImageView) convertView.findViewById(R.id.place_image);

            // store the holder with the view.
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // object item based on the position
        Places currentSpot = getItem(position);

        // assign values if the object is not null
        if (currentSpot != null) {
            // get the views from the ViewHolder and then set the values
            viewHolder.spotName.setText(currentSpot.getPlaceName());
            viewHolder.spotDesc.setText(currentSpot.getPlaceDescription());
            viewHolder.spotImage.setImageResource(currentSpot.getPlaceImageResourceID());
        }

        return convertView;

    }
}
