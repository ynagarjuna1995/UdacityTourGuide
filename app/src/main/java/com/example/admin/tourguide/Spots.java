package com.example.admin.tourguide;

/**
 * Created by admin on 9/26/2016.
 */

public class Spots {
    private int mImageResourseId;
    private int mSpotName;
    private int mSpotDescription;
    private int mSpotDetail;

    public Spots(int spotName, int spotDescription, int imageResourseId, int spotDetail) {
        mSpotName = spotName;
        mSpotDescription = spotDescription;
        mImageResourseId = imageResourseId;
        mSpotDetail = spotDetail;
    }

    public int getSpotName() {
        return mSpotName;
    }

    public int getSpotDescription() {
        return mSpotDescription;
    }

    public int getImageResourceId() {
        return mImageResourseId;
    }

    public int getSpotDetail() {
        return mSpotDetail;
    }

}
