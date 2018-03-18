package com.example.android.funkypod;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Jamie C on 15/03/2018.
 *
 * Used to store items for the playlist, globally, so that it is not trashed upon change of activity
 * otherwise only the most recent values would be shown in the ViewPlaylist arrayadapter.
 */


public class GlobalClass extends Application{

    private String mixNameToPlaylist;
    private String mixArtistToPlaylist;
    private int imageIDToPlaylist;
    private ArrayList<Mixes> mixes;

    public void addMixes(Mixes mix) {
        mixes = new ArrayList<>();

    }


    public String getMixNameToPlaylist() {
        return mixNameToPlaylist;
    }

    public void setMixNameToPlaylist(String mixNameToPlaylist) {
        this.mixNameToPlaylist = mixNameToPlaylist;
    }

    public String getMixArtistToPlaylist() {
        return mixArtistToPlaylist;
    }

    public void setMixArtistToPlaylist(String mixArtistToPlaylist) {
        this.mixArtistToPlaylist = mixArtistToPlaylist;
    }

    public int getImageIDToPlaylist() {
        return imageIDToPlaylist;
    }

    public void setImageIDToPlaylist(int imageIDToPlaylist) {
        this.imageIDToPlaylist = imageIDToPlaylist;
    }
}
