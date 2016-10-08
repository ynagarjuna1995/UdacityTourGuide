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
public class TopSpotsFragment extends Fragment {


    public TopSpotsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.spots_list, container, false);

        final ArrayList<Spots> spots = new ArrayList<Spots>();
        spots.add(new Spots("Sabarmati Ashram", "Spiritual site in Gandhiji's former home", R.drawable.gandhi_ashram, R.string.sabarmati_ashram));
        spots.add(new Spots("Kankaria Lake", "One of the largest lakes in the city", R.drawable.kankaria, R.string.kankaria_lake));


        final SpotsAdapter adapter = new SpotsAdapter(getActivity(), spots);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Spots topSpots = (Spots) adapter.getItem(position);
                String spotName = (String) topSpots.getSpotName();
                Integer spotImage = (Integer) topSpots.getImageResourseId();
                Integer spotDesc = (Integer) topSpots.getSpotDetail();

                Intent intent = new Intent(getActivity(), SpotDetailActivity.class);

                Bundle bundle = new Bundle();

                bundle.putInt("SPOT_IMAGE", spotImage);
                bundle.putString("SPOT_NAME", spotName);
                bundle.putInt("SPOT_DESC", spotDesc);
                bundle.putInt("CATEGORY_NAME", R.string.category_top_spots);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        return rootView;
    }

}
