package com.example.android.funkypod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewPlaylist extends AppCompatActivity {

    private Mixes receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_playlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Playlist");

        // Need to get intent from MoreInfo (via parcelable) and add to newly created arraylist

        Intent playListIntent = getIntent();
        receive = playListIntent.getParcelableExtra("items");

        int imageID = receive.getImageResourceId();
        String mix = receive.getMixName();
        String artist = receive.getArtistName();

        /**
         * Initialise global variable so that it takes data from intent and stores in global variable
         * also adds values to new int and string values
         */
        GlobalClass globalvariable = (GlobalClass) getApplicationContext();

        globalvariable.setImageIDToPlaylist(imageID);
        globalvariable.setMixNameToPlaylist(mix);
        globalvariable.setMixArtistToPlaylist(artist);

        int globalImageID = globalvariable.getImageIDToPlaylist();
        String globalMixName = globalvariable.getMixNameToPlaylist();
        String globalArtistName = globalvariable.getMixArtistToPlaylist();


        // Create an arraylist to receive items added to playlist from moreInfo activity

        ArrayList<Mixes> addedToPlaylist = new ArrayList<>();

        //Add received data to arraylist
        addedToPlaylist.add(new Mixes(globalImageID, globalMixName, globalArtistName));

        // also tried addedToPlaylist.add(new GlobalClass(globalImageID, globalMixName, globalArtistName));
        // regardless, data is not persistent and errors on 'new GlobalClass' above

        final PlaylistAdapter playlistAdapter = new PlaylistAdapter(this, addedToPlaylist);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.playlist_view);
        listView.setAdapter(playlistAdapter);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.showPlaylistIcon) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /* Code to hide the playlist icon when actually in the playlist activity
    */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (menu.findItem(R.id.showPlaylistIcon) != null)
            menu.findItem(R.id.showPlaylistIcon).setVisible(false);
        return true;
    }

}
