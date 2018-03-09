package com.example.android.funkypod;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jamie C on 05/03/2018.
 */

public class Mixes implements Parcelable{

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Mixes createFromParcel(Parcel in) {
            return new Mixes(in);
        }

        public Mixes[] newArray(int size) {
            return new Mixes[size];
        }
    };

    /** String for Artist Name */
    private String mArtistName;
    /** String for Name of Podcast/Mix */
    private String mMixName;
    /** String for Info for the Podcast/Mix */
    private String mInfo;
    // Drawable resource ID
    private int mImageResourceId;

    /**
     * Create a new Mix object.
     *
     * @param mixName is the name of the mix / podcast created by the artist
     * @param artistName is the name of the artist / group who created the podcast / mix
     * @param info is the information about the mix / podcast
     * @param imageResourceId contains the image resource for the mix/podcast
     */
    public Mixes(String mixName, String artistName, String info, int imageResourceId) {
        mMixName = mixName;
        mArtistName = artistName;
        mInfo = info;
        mImageResourceId = imageResourceId;
    }

    public Mixes(Parcel in){
        mMixName = in.readString();
        mArtistName = in.readString();
        mInfo = in.readString();
        mImageResourceId = in.readInt();
            }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mMixName);
        dest.writeString(mArtistName);
        dest.writeString(mInfo);
        dest.writeInt(mImageResourceId);
    }

    public int describeContents() {
        return 0;
    }


    /**
     * Get the name of the mix
     */
    public String getMixName() {
        return mMixName;
    }

    /**
     * Get the name of the artist
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the Info for the Mix/Podcast
     */
    public String getInfo() {
        return mInfo;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}


