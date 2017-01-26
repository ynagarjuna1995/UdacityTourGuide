package io.github.ynagarjuna1995.tourguide;

public class Places {
    private int mPlaceImageResourceID;
    private int mPlaceName;
    private int mPlaceDescription;
    private int mPlaceDetail;

    public Places(int placeName, int placeDescription, int placeImageResourceID, int placeDetail) {
        mPlaceName = placeName;
        mPlaceDescription = placeDescription;
        mPlaceImageResourceID = placeImageResourceID;
        mPlaceDetail = placeDetail;
    }

    public int getPlaceName() {
        return mPlaceName;
    }

    public int getPlaceDescription() {
        return mPlaceDescription;
    }

    public int getPlaceImageResourceID() {
        return mPlaceImageResourceID;
    }

    public int getPlaceDetail() {
        return mPlaceDetail;
    }

}
