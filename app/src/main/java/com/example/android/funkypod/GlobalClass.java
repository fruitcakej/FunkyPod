package com.example.android.funkypod;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Jamie C on 15/03/2018.
 *
 * Used to store arraylist for the playlist, globally, so that it is not trashed upon change of activity
 * otherwise only the most recent values would be shown in the (old) ViewPlaylist arrayadapter.
 */

public class GlobalClass extends Application {

    private ArrayList<Mixes> mixes;

    public ArrayList<Mixes> getMixes() {
        return mixes;
    }

    public void addMixes(Mixes mix) {

        if (mixes == null) {
            mixes = new ArrayList<>();
        }
            mixes.add(mix);
        }
}