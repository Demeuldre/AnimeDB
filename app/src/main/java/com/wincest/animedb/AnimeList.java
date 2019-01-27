package com.wincest.animedb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private static void jsonToText(JSONArray jsonArray)
    {
        String s = "";

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject json;
            try
            {
                json = jsonArray.getJSONObject(i);
                s = json.getString("idAnime");

            } catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    // Obtener todos los animes de la BD
    private static class GetAllAnimes extends AsyncTask<DBConnector, Long, JSONArray>
    {

        @Override
        protected JSONArray doInBackground(DBConnector... dbConnectors)
        {
            // Ejecuta la obtencion de los animes en un thread en background
            return dbConnectors[0].GetAllAnimes();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray)
        {
            // pasa la informacion de los animes en una lista
            jsonToText(jsonArray);
        }
    }
}
