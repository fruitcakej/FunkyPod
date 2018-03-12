package com.example.android.funkypod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MoreInfo extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("More Info");

        /**
         * Associate to Views
         */
        ImageView mix_icon = (ImageView) findViewById(R.id.mix_icon);
        TextView mixNameTextView = (TextView) findViewById(R.id.mixName);
        TextView artistNameTextView = (TextView) findViewById(R.id.artistName);
        TextView infoTextView = (TextView) findViewById(R.id.info);
        ImageButton addPlaylist = (ImageButton) findViewById(R.id.addToPlaylist);
        addPlaylist.setOnClickListener(this);

        /**
         * Get the selected intent
         */
        Intent moreInfoIntent = getIntent();
        int imageID = moreInfoIntent.getIntExtra("imageResourceID", 0);
        String mix = moreInfoIntent.getStringExtra("mixName");
        String info = moreInfoIntent.getStringExtra("info");
        String artist = moreInfoIntent.getStringExtra("artistName");

        /**
         * Set on the above Views
         */
        mix_icon.setImageResource(imageID);
        mixNameTextView.setText(mix);
        artistNameTextView.setText(artist);
        infoTextView.setText(info);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addToPlaylist:
                Toast.makeText(this, R.string.addedToPlaylist, Toast.LENGTH_SHORT).show();

                Intent playListIntent = new Intent(this, ViewPlaylist.class);
                playListIntent.putExtra("mix", 0);
                playListIntent.putExtra("info", 0);
                playListIntent.putExtra("artist", 0);
                playListIntent.putExtra("imageID", 0);
                startActivity(playListIntent);
                break;
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
            startActivity(new Intent(this, ViewPlaylist.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
