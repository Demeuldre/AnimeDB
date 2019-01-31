package com.wincest.animedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AnimeView extends AppCompatActivity
{
    ImageView imgAnime;
    TextView episodes, title, status, plot, genreTypes, rating;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_view);

        // Obtener el objeto anime
        Anime anime = (Anime) getIntent().getSerializableExtra("anime");

        imgAnime = findViewById(R.id.imgAnime);
        episodes = findViewById(R.id.txtboxEpisodes);
        title = findViewById(R.id.txtboxTitle);
        status = findViewById(R.id.txtboxStatus);
        plot = findViewById(R.id.txtboxPlot);
        genreTypes = findViewById(R.id.txtboxGenreTypes);
        rating = findViewById(R.id.txtboxRating);

        // set image
        try
        {
            Picasso.get().load(anime.getImageURL()).into(imgAnime);

        } catch (Exception e)
        {
            Picasso.get().load(R.drawable.placeholder).into(imgAnime);
        }

        String str = episodes.getText() + Integer.toString(anime.getEpisodes());
        episodes.setText(str);

        title.setText(anime.getTitle());

        String st = status.getText() + anime.getStatus();
        status.setText(st);

        plot.setText(anime.getSynopsis());

        genreTypes.setText(anime.getGenres());

        String r = rating.getText() + Double.toString(anime.getRating());
        rating.setText(r);
    }
}