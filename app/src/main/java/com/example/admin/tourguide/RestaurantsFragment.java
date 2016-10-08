package com.example.admin.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    private static final String SPOT_IMAGE = "SPOT_IMAGE";
    private static final String SPOT_NAME = "SPOT_NAME";
    private static final String SPOT_DESC = "SPOT_DESC";
    private static final String CATEGORY_NAME = "CATEGORY_NAME";

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.spots_list, container, false);

        final ArrayList<Spots> spots = new ArrayList<Spots>();
        spots.add(new Spots(R.string.restaurant1_name, R.string.restaurant1_brief, R.drawable.bbqnation, R.string.bbq_nation));
        spots.add(new Spots(R.string.restaurant2_name, R.string.restaurant2_brief, R.drawable.patang, R.string.neelkanth_patang));
        spots.add(new Spots(R.string.restaurant3_name, R.string.restaurant3_brief, R.drawable.vishalla, R.string.vishala));

        final SpotsAdapter adapter = new SpotsAdapter(getActivity(), spots);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Spots restaurants = (Spots) adapter.getItem(position);
                Integer spotName = (Integer) restaurants.getSpotName();
                Integer spotImage = (Integer) restaurants.getImageResourceId();
                Integer spotDesc = (Integer) restaurants.getSpotDetail();

                Intent intent = new Intent(getActivity(), SpotDetailActivity.class);

                Bundle bundle = new Bundle();

                bundle.putInt(SPOT_IMAGE, spotImage);
                bundle.putInt(SPOT_NAME, spotName);
                bundle.putInt(SPOT_DESC, spotDesc);
                bundle.putInt(CATEGORY_NAME, R.string.category_restaurants);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
