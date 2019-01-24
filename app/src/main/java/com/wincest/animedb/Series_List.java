package com.wincest.animedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class Series_List extends AppCompatActivity {

    TextView seriesList;
    RecyclerView RVSeries;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.series_list);

        seriesList = findViewById(R.id.txtSeriesList);
        RVSeries = findViewById(R.id.RecyclerSeries);
    }

}
