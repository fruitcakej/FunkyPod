package com.example.android.funkypod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewPlaylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_playlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Playlist");


        // Create an arraylist to receive items added to playlist from moreInfo activity

        // Need to add to array via add(getIntent()) ?

        final ArrayList<String> addedToPlaylist = new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter <String>(ViewPlaylist.this, 0, addedToPlaylist);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.playlist_view);
        listView.setAdapter(adapter);

/**
 * Associate to Views
 */
        ImageView pl_icon = (ImageView) findViewById(R.id.pl_icon);
        TextView plMixName = (TextView) findViewById(R.id.pl_mix_name);
        TextView plArtistName = (TextView) findViewById(R.id.pl_artist_name);

        addedToPlaylist.add(getIntent().toString());
        Intent toPlaylist = getIntent();
        int imageID = toPlaylist.getIntExtra("imageID", 0);
        String mix = toPlaylist.getStringExtra("mix");
        String artist = toPlaylist.getStringExtra("artist");

        /**
         * Set on the above Views
         */
        pl_icon.setImageResource(imageID);
        plMixName.setText(mix);
        plArtistName.setText(artist);



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
