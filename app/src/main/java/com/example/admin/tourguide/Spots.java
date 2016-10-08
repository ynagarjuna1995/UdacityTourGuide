package com.example.admin.tourguide;

/**
 * Created by admin on 9/26/2016.
 */

public class Spots {
    private int mImageResourseId;
    private String mSpotName;
    private String mSpotDescription;
    private int mSpotDetail;

    public Spots(String spotName, String spotDescription, int imageResourseId, int spotDetail) {
        mSpotName = spotName;
        mSpotDescription = spotDescription;
        mImageResourseId = imageResourseId;
        mSpotDetail = spotDetail;
    }

    public String getSpotName() {
        return mSpotName;
    }

    public String getSpotDescription() {
        return mSpotDescription;
    }

    public int getImageResourseId() {
        return mImageResourseId;
    }

    public int getSpotDetail() {
        return mSpotDetail;
    }

}
