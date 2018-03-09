package com.example.android.funkypod;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jamie C on 05/03/2018.
 */

public class MixAdapter extends ArrayAdapter<Mixes> {

    /**
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param mixes A List of mixes objects to display in a list
     */

    public MixAdapter(Context context, ArrayList<Mixes> mixes) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0,mixes);
    }

    /**
     * Provides a view for an AdapterView (ListView)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link mixes} object located at this position in the list
        Mixes mixes = getItem(position);

        // Find the TextView in the list_item.xml layout with the mix name text view
        TextView mixNameTextView = (TextView) listItemView.findViewById(R.id.mixName);

        // Get the mix name from com.example.android.funkypod.Mixes object
        // set this text on the mixname TextView
        mixNameTextView.setText(mixes.getMixName());

        // Find the TextView in the list_item.xml layout with the artist text view
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artistName);

        // Get the artist name from com.example.android.funkypod.Mixes object
        // set this text on the artistname TextView
       artistNameTextView.setText(mixes.getArtistName());

        // Find the TextView in the list_item.xml layout with the info text view
        TextView infoTextView = (TextView) listItemView.findViewById(R.id.info);

        // Get the info from com.example.android.funkypod.Mixes object
        // set this text on the info TextView
        infoTextView.setText(mixes.getInfo());

        // Find the ImageView in the list_item.xml layout with the ID mix_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.mix_icon);

        // Get the image resource ID from com.example.android.funkypod.Mixes object and
        // set the image to iconView
        iconView.setImageResource(mixes.getImageResourceId());

        return listItemView;
    }
}


