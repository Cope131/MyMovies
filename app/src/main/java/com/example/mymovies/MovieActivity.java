package com.example.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {

    TextView tvTitle, tvYear, tvGenre, tvDesc, tvWatchedOn, tvTheatre;
    ImageView ivRated, ivPoster, ivTrailer;
    RatingBar rb;

    String title = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        //binding
        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvGenre = findViewById(R.id.textViewGenre);
        tvDesc = findViewById(R.id.textViewDesc);
        tvWatchedOn = findViewById(R.id.textViewWatchedOn);
        tvTheatre = findViewById(R.id.textViewTheatre);
        ivRated = findViewById(R.id.imageViewRated);
        rb = findViewById(R.id.ratingBar);
        ivPoster = findViewById(R.id.imageViewPoster2);
        ivTrailer = findViewById(R.id.imageViewTrailer);


        Intent intentReceived = getIntent();

        title = intentReceived.getStringExtra("movieTitle");
        int year = intentReceived.getIntExtra("movieYear", 0);
        String genre = intentReceived.getStringExtra("movieGenre");
        String rated = intentReceived.getStringExtra("movieRated");
        String watchedOn = intentReceived.getStringExtra("movieWatchedOn");
        String desc = intentReceived.getStringExtra("movieDesc");
        String inTheatre = intentReceived.getStringExtra("movieInTheatre");
        float rate = intentReceived.getFloatExtra("movieRate", 0);

        if (rated.equalsIgnoreCase("g"))
            ivRated.setImageResource(R.drawable.rating_g);
        else if (rated.equalsIgnoreCase("pg"))
            ivRated.setImageResource(R.drawable.rating_pg);
        else if (rated.equalsIgnoreCase("pg13"))
            ivRated.setImageResource(R.drawable.rating_pg13);
        else if (rated.equalsIgnoreCase("nc16"))
            ivRated.setImageResource(R.drawable.rating_nc16);
        else if (rated.equalsIgnoreCase("m18"))
            ivRated.setImageResource(R.drawable.rating_m18);
        else
            ivRated.setImageResource(R.drawable.rating_r21);

        tvTitle.setText(title);
        tvYear.setText(year + "");
        tvGenre.setText(genre);
        tvDesc.setText(desc);
        tvWatchedOn.setText("Watch On: " + watchedOn);
        tvTheatre.setText("In Theatre: " + inTheatre);

        //poster image
        if (title.equals("The Avengers")) {
            ivPoster.setImageResource(R.drawable.avengers);
            ivTrailer.setImageResource(R.drawable.avengers_trailer);
        }
        else if (title.equals("Planes")) {
            ivPoster.setImageResource(R.drawable.planes);
            ivTrailer.setImageResource(R.drawable.planes_trailer);
        }
        else {
            ivPoster.setImageResource(R.drawable.sonic);
            ivTrailer.setImageResource(R.drawable.sonic_trailer);
        }

        rb.setRating(rate);

        ivTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                if (title.equals("The Avengers"))
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=eOrNdBpGMv8"));
                else if (title.equals("Planes"))
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=YRjztG65XgI"));
                else
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=szby7ZHLnkA"));
                startActivity(intent);
            }
        });
    }
}