package com.example.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;

    ArrayList<Movie> alMovies;

    CustomAdapter caMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding
        lvMovies = findViewById(R.id.listViewMovie);

        //initialize array list
        alMovies = new ArrayList<>();

        //add items
        Calendar watchedOn1 = Calendar.getInstance();
        watchedOn1.set(2014, 11, 15);
        alMovies.add(new Movie("The Avengers", 2012, "pg13",
                    "Action | Sci-fi", watchedOn1, "Golden Village - Bishan",
                    "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to " +
                              "save the planet from Loki and his army.", 4));

        Calendar watchedOn2 = Calendar.getInstance();
        watchedOn2.set(2015, 11, 15);
        alMovies.add(new Movie("Planes", 2013, "pg",
                "Animation | Comedy", watchedOn2, "Golden Village - Bishan",
                "A cropdusting plane with a fear of heights lives his dream of competing " +
                          "in a famous around-the-world aerial race.", 4));

        Calendar watchedOn3 = Calendar.getInstance();
        watchedOn3.set(2015, 11, 15);
        alMovies.add(new Movie("Sonic the Hedgehog", 2020, "pg",
                "Action | Adventure | Comedy", watchedOn3, "Golden Village - Bishan",
                "After discovering a small, blue, fast hedgehog, a small-town police " +
                           "officer must help him defeat an evil genius who wants to do experiments on him.\n", 4));

        //initialize adapter
        caMovies = new CustomAdapter(this, R.layout.row, alMovies);

        //bridging
        lvMovies.setAdapter(caMovies);

        //select movie
        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = alMovies.get(i);
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                intent.putExtra("movieTitle", movie.getTitle());
                intent.putExtra("movieYear", movie.getYear());
                intent.putExtra("movieGenre", movie.getGenre());
                intent.putExtra("movieRated", movie.getRated());
                intent.putExtra("movieWatchedOn", movie.toString());
                intent.putExtra("movieDesc", movie.getDescription());
                intent.putExtra("movieInTheatre", movie.getIn_theatre());
                intent.putExtra("movieRate", movie.getRate());
                startActivity(intent);
            }
        });

    }
}