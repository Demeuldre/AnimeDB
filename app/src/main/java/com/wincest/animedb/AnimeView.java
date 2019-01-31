package com.wincest.animedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AnimeView extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_view);

        // Obtener el objeto anime
        Anime anime = (Anime) getIntent().getSerializableExtra("anime");
    }
}