package io.github.ynagarjuna1995.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class PlaceDetailActivity extends AppCompatActivity {

    private static final String PLACE_IMAGE = "PLACE_IMAGE";
    private static final String PLACE_NAME = "PLACE_NAME";
    private static final String PLACE_DESC = "PLACE_DESC";
    private static final String CATEGORY_NAME = "CATEGORY_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        Integer placeImage = bundle.getInt(PLACE_IMAGE);
        Integer placeName = bundle.getInt(PLACE_NAME);
        Integer placeDesc = bundle.getInt(PLACE_DESC);
        Integer categoryName = bundle.getInt(CATEGORY_NAME);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle(categoryName);

        TextView textView1 = (TextView) findViewById(R.id.place_name);
        textView1.setText(placeName);

        ImageView imageView = (ImageView) findViewById(R.id.place_image);
        imageView.setImageResource(placeImage);

        TextView textView = (TextView) findViewById(R.id.place_desc);
        textView.setText(placeDesc);
    }
}
