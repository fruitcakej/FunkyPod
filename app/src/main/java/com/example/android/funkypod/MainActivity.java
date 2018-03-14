package com.example.android.funkypod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);


        // Create an arraylist of the available mixes / podcasts available
         final ArrayList<Mixes> availableMixes = new ArrayList<Mixes>();
        availableMixes.add(new Mixes("The Story So Far Part 1", "Scratchmaster Dee",
                "This beautiful mix from Scratchmaster Dee will take you on an actual journey." +
                        " Elegantly chosen tracks come together beautifully to form this classic house mix",
                R.drawable.dee));

        availableMixes.add(new Mixes("House of Uxbridge!", "DJ Jamie C & DJ Phatman",
                "The last mix to be recorded with DJ Phatman before his unfortunate death in 2016." +
                        " This is just a random put together of tracks after a few drinks!",
                R.drawable.jcsi));

        availableMixes.add(new Mixes("House Mix Jan 09", "Jamie C & Scratchmaster Dee",
                "This mix was recorded while Jamie and Dee were working the London circit 3 nights a week." +
                        " a belend of commercial house tracks to keep you dancing!", R.drawable.jcdee));

        availableMixes.add(new Mixes("Winter Chill 2006", "DJ Phil Hewson",
                "An old classic mix from a great London House DJ. Full of classic disco tracks" +
                        " and some remixes. A cracking mix to play loud when you're out driving!",
                R.drawable.winterchill));

        availableMixes.add(new Mixes("Welcome Home", "K.D.S.",
                "On this year 2017 there was a lot of movement and this is only the beginning, " +
                        "this mix should have been recorded a year ago, however I added during my travels" +
                        " all the influences that was important to me." +
                        " So I give you a summary of my travels and meetings last year." +
                        " And the more years pass, the more enriching they are.", R.drawable.kdswh));

        availableMixes.add(new Mixes("Deep In Love (Nu Disco - Deep House Set)",
                "Ahmet Kılıç", "The deep house sounds from this mix are hypnotic," +
                " you'll find some tracks in this that are recognisable and deep. " +
                " Perfect for chillin' out. Beautifully mixed for you. Enjoy!", R.drawable.dil));

        // Create an {@link MixAdapterAdapter}, whose data source is a list of
        // {@link Mix'}s. The adapter knows how to create list item views for each item
        // in the list.
        final MixAdapter mixAdapter = new MixAdapter(this, availableMixes);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_mixes);
        listView.setAdapter(mixAdapter);

        /**
         * Set onItemClick listener for specific row clicks and prepare intent
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Mixes mixes = availableMixes.get(position);

                Intent moreInfoIntent = new Intent(MainActivity.this, MoreInfo.class);
                moreInfoIntent.putExtra("mixName", mixes.getMixName());
                moreInfoIntent.putExtra("info", mixes.getInfo());
                moreInfoIntent.putExtra("artistName", mixes.getArtistName());
                moreInfoIntent.putExtra("imageResourceID", mixes.getImageResourceId());
                startActivity(moreInfoIntent);

            }

        });

}

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
