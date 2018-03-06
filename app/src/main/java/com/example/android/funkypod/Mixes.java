package com.example.android.funkypod;

/**
 * Created by Jamie C on 05/03/2018.
 */

public class Mixes {

    /** String for Artist Name */
    private String mArtistName;

    /** String for Name of Podcast/Mix */
    private String mMixName;

    /** String for Info for the Podcast/Mix */
    private String mInfo;

    /**
     * Create a new Mix object.
     *
     * @param mixName is the name of the mix / podcast created by the artist
     * @param artistName is the name of the artist / group who created the podcast / mix
     * @param info is the information about the mix / podcast
     */
    public Mixes(String mixName, String artistName, String info) {
        mMixName = mixName;
        mArtistName = artistName;
        mInfo = info;
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
}


