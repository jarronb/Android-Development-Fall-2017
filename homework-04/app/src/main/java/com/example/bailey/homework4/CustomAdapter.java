package com.example.bailey.homework4;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by baile on 9/26/2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] moviename;
    private final Integer[] imgid;
    private final String[] moviedescription;

    public CustomAdapter(Activity context, String[] moviename, Integer[] imgid, String[] moviedescription) {

        //ArrayAdapter(Context context, int resource, T[] objects)
        super(context, R.layout.listview, moviedescription);
        this.context = context;
        this.moviename = moviename;
        this.imgid = imgid;
        this.moviedescription = moviedescription;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View rowView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();

        //inflate(int resource, ViewGroup root, boolean attachToRoot)
            rowView = inflater.inflate(R.layout.listview,
                    null, true);


        ImageView imageView = (ImageView) (rowView.findViewById(R.id.imageView_movie));
        TextView textView_name = (TextView) (rowView.findViewById(R.id.textView_name));
        TextView textView_description = (TextView) (rowView.findViewById(R.id.textView_description));

        imageView.setImageResource(imgid[position]);
        textView_name.setText(moviename[position]);
        textView_description.setText(moviedescription[position]);
        return rowView;
    }
}
