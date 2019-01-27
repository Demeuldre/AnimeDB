package com.wincest.animedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class AnimeList extends AppCompatActivity {

    TextView seriesList;
    RecyclerView RVSeries;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_list);

        seriesList = findViewById(R.id.txtSeriesList);
        RVSeries = findViewById(R.id.RecyclerSeries);

        //TODO cargar toda la lista de animes de la bd

        //TODO crear evento click para abrir la pagina de la ficha tecnica de la serie

        //TODO manera para volver a la pagina anterior(no se si el navigation view sigue estando)

        //TODO mostrar miniatura del anime y titulo en la lista
    }

}
