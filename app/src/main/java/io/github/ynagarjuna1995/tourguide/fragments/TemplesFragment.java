package io.github.ynagarjuna1995.tourguide.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import io.github.ynagarjuna1995.tourguide.PlaceDetailActivity;
import io.github.ynagarjuna1995.tourguide.Places;
import io.github.ynagarjuna1995.tourguide.R;
import io.github.ynagarjuna1995.tourguide.adapters.PlacesAdapter;

import java.util.ArrayList;


public class TemplesFragment extends Fragment {

    private static final String PLACE_IMAGE = "PLACE_IMAGE";
    private static final String PLACE_NAME = "PLACE_NAME";
    private static final String PLACE_DESC = "PLACE_DESC";
    private static final String CATEGORY_NAME = "CATEGORY_NAME";

    public TemplesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(R.string.temple1_name, R.string.temple1_brief, R.drawable.birla, R.string.birlaMandir));
        places.add(new Places(R.string.temple2_name, R.string.temple2_brief, R.drawable.golconda, R.string.chilukur));

        final PlacesAdapter adapter = new PlacesAdapter(getActivity(), places);

        final ListView listView = (ListView) rootView.findViewById(R.id.places_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Places events = (Places) adapter.getItem(position);
                Integer placeName = (Integer) events.getPlaceName();
                Integer placeImage = (Integer) events.getPlaceImageResourceID();
                Integer placeDesc = (Integer) events.getPlaceDetail();

                Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);

                Bundle bundle = new Bundle();

                bundle.putInt(PLACE_IMAGE, placeImage);
                bundle.putInt(PLACE_NAME, placeName);
                bundle.putInt(PLACE_DESC, placeDesc);
                bundle.putInt(CATEGORY_NAME, R.string.category_Temples);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
