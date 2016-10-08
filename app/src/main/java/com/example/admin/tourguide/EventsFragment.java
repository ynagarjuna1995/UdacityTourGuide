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
public class EventsFragment extends Fragment {


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.spots_list, container, false);

        final ArrayList<Spots> spots = new ArrayList<Spots>();
        spots.add(new Spots("Navratri", "Garba is a dance which people perform on Navratri", R.drawable.garba, R.string.garba));
        spots.add(new Spots("Kankaria Carnival", "Week-long cultural festival", R.drawable.kankaria, R.string.kankaria_carnival));

        final SpotsAdapter adapter = new SpotsAdapter(getActivity(), spots);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Spots events = (Spots) adapter.getItem(position);
                String spotName = (String) events.getSpotName();
                Integer spotImage = (Integer) events.getImageResourseId();
                Integer spotDesc = (Integer) events.getSpotDetail();

                Intent intent = new Intent(getActivity(), SpotDetailActivity.class);

                Bundle bundle = new Bundle();

                bundle.putInt("SPOT_IMAGE", spotImage);
                bundle.putString("SPOT_NAME", spotName);
                bundle.putInt("SPOT_DESC", spotDesc);
                bundle.putInt("CATEGORY_NAME", R.string.category_events);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
