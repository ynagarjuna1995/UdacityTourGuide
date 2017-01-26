package io.github.ynagarjuna1995.tourguide.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import io.github.ynagarjuna1995.tourguide.R;
import io.github.ynagarjuna1995.tourguide.PlaceDetailActivity;
import io.github.ynagarjuna1995.tourguide.Places;
import io.github.ynagarjuna1995.tourguide.adapters.PlacesAdapter;

import java.util.ArrayList;


public class MuseumsFragment extends Fragment {

    private static final String PLACE_IMAGE = "PLACE_IMAGE";
    private static final String PLACE_NAME = "PLACE_NAME";
    private static final String PLACE_DESC = "PLACE_DESC";
    private static final String CATEGORY_NAME = "CATEGORY_NAME";

    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(R.string.museum1_name, R.string.museum1_brief, R.drawable.salarjung, R.string.salarjung_museum));
        places.add(new Places(R.string.museum2_name, R.string.museum2_brief, R.drawable.birlaplant, R.string.birla_planetorium));


        final PlacesAdapter adapter = new PlacesAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.places_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Places popularPlaces = (Places) adapter.getItem(position);
                Integer placeName = (Integer) popularPlaces.getPlaceName();
                Integer placeImage = (Integer) popularPlaces.getPlaceImageResourceID();
                Integer placeDesc = (Integer) popularPlaces.getPlaceDetail();

                Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);

                Bundle bundle = new Bundle();

                bundle.putInt(PLACE_IMAGE, placeImage);
                bundle.putInt(PLACE_NAME, placeName);
                bundle.putInt(PLACE_DESC, placeDesc);
                bundle.putInt(CATEGORY_NAME, R.string.category_Monuments);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        return rootView;
    }

}
