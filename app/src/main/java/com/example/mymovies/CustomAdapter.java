package com.example.mymovies;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);
        //images
        ImageView ivRated = rowView.findViewById(R.id.imageViewRated);
        ImageView ivPoster = rowView.findViewById(R.id.imageViewPoster);
        //small rating bar
        RatingBar rbSmall = rowView.findViewById(R.id.ratingBarSmall);

        Movie currentItem = movieList.get(position);

        if (currentItem.getYear() == Calendar.getInstance().get(Calendar.YEAR)) {
            tvTitle.setTextColor(ContextCompat.getColor(parent_context, android.R.color.holo_red_dark));
            tvYear.setTextColor(ContextCompat.getColor(parent_context, android.R.color.holo_red_dark));
            tvGenre.setTextColor(ContextCompat.getColor(parent_context, android.R.color.holo_red_dark));
        }

        tvTitle.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear() + "");
        tvGenre.setText(currentItem.getGenre());

        //rating image
        if (currentItem.getRated().equalsIgnoreCase("g"))
            ivRated.setImageResource(R.drawable.rating_g);
        else if (currentItem.getRated().equalsIgnoreCase("pg"))
            ivRated.setImageResource(R.drawable.rating_pg);
        else if (currentItem.getRated().equalsIgnoreCase("pg13"))
            ivRated.setImageResource(R.drawable.rating_pg13);
        else if (currentItem.getRated().equalsIgnoreCase("nc16"))
            ivRated.setImageResource(R.drawable.rating_nc16);
        else if (currentItem.getRated().equalsIgnoreCase("m18"))
            ivRated.setImageResource(R.drawable.rating_m18);
        else
            ivRated.setImageResource(R.drawable.rating_r21);

        //poster image
        if (currentItem.getTitle().equals("The Avengers"))
            ivPoster.setImageResource(R.drawable.avengers);
        else if (currentItem.getTitle().equals("Planes"))
            ivPoster.setImageResource(R.drawable.planes);
        else
            ivPoster.setImageResource(R.drawable.sonic);

        //rating bar
        rbSmall.setRating(currentItem.getRate());

        return rowView;

    }
}
