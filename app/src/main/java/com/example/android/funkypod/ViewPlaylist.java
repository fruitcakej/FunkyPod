package com.example.android.funkypod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

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

        if (getIntent().getParcelableExtra("items") != null) {
            // get parcelable extra data

            // Need to get intent from MoreInfo (via parcelable) and add to newly created arraylist

            Intent playListIntent = getIntent();
            receive = playListIntent.getParcelableExtra("items");

            int imageID = receive.getImageResourceId();
            String mix = receive.getMixName();
            String artist = receive.getArtistName();

            // Initialise global variable so that it takes data from intent and stores ---
            // Don't think I need this anymore

//            GlobalClass globalvariable = (GlobalClass) getApplicationContext();
//
//            globalvariable.setImageIDToPlaylist(imageID);
//            globalvariable.setMixNameToPlaylist(mix);
//            globalvariable.setMixArtistToPlaylist(artist);
//
//            int globalImageID = globalvariable.getImageIDToPlaylist();
//            String globalMixName = globalvariable.getMixNameToPlaylist();
//            String globalArtistName = globalvariable.getMixArtistToPlaylist();


            // Playlist to store ViewPlaylist items now moved to GlobalClass so that it can persist.

            final PlaylistAdapter playlistAdapter = new PlaylistAdapter(this, mixes);

            // Get a reference to the ListView, and attach the adapter to the listView.
            ListView listView = (ListView) findViewById(R.id.playlist_view);
            listView.setAdapter(playlistAdapter);




        } else {
            // processing when no extra data received
            return;
        }

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
