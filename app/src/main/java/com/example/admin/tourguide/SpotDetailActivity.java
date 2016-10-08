package com.example.admin.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 10/6/2016.
 */

public class SpotDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        Integer spotImage = bundle.getInt("SPOT_IMAGE");
        String spotName = bundle.getString("SPOT_NAME");
        Integer spotDesc = bundle.getInt("SPOT_DESC");
        Integer categoryName = bundle.getInt("CATEGORY_NAME");

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle(categoryName);

        TextView textView1 = (TextView) findViewById(R.id.spot_name);
        textView1.setText(spotName);

        ImageView imageView = (ImageView) findViewById(R.id.spot_image);
        imageView.setImageResource(spotImage);

        TextView textView = (TextView) findViewById(R.id.spot_desc);
        textView.setText(spotDesc);
    }
}
