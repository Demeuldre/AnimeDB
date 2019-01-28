package com.wincest.animedb;

import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnimeList extends AppCompatActivity {

    // Array que almacenara la url de la imagen y el nombre del anime
    private static ArrayList<Anime> animeList = new ArrayList<>();

    TextView seriesList;
    RecyclerView rvSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_list);

        seriesList = findViewById(R.id.txtSeriesList);
        rvSeries = findViewById(R.id.RecyclerSeries);

        //TODO cargar toda la lista de animes de la bd
        cargarRecyclerView();

        new GetAllAnimes().execute(new DBConnector());

        //TODO crear evento click para abrir la pagina de la ficha tecnica de la serie

        //TODO manera para volver a la pagina anterior(no se si el navigation view sigue estando)

        //TODO mostrar miniatura del anime y titulo en la lista


    }

    // Cargar el recycler view con la informacion de la base de datos
    private void cargarRecyclerView()
    {
        AnimeAdapter adapter = new AnimeAdapter(animeList);
        rvSeries.setAdapter(adapter);
    }


    // Convierte el valor json devuelto de la pagina web en un ArrayList
    private static void jsonToArrayList(JSONArray jsonArray)
    {
        for (int i = 0; i < jsonArray.length(); i++)
        {
            // objeto anime
            Anime newAnime;

            JSONObject json;
            try
            {
                json = jsonArray.getJSONObject(i);

                // Obtener los datos del anime
                int idAnime = json.getInt("idAnime");
                int episodes = json.getInt("episodes");
                double rating = json.getDouble("rating");
                String title = json.getString("title");
                String genres = json.getString("genre");
                String status = json.getString("status");
                String synopsis = json.getString("synopsis");
                String image = json.getString("image");

                newAnime = new Anime(idAnime, episodes, rating, title, genres, status, synopsis, image);

                animeList.add(newAnime);

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
            jsonToArrayList(jsonArray);
        }
    }
}
