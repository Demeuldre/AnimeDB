package com.wincest.animedb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // Objeto POJO que representa un anime
    public class Anime implements Serializable
    {
        private int idAnime, episodes;
        private double rating;
        private boolean favorite;
        private String title, genres, imageURL, synopsis, status;

        public Anime(int idAnime, String title, String genres, String imageURL)
        {
            this.idAnime = idAnime;
            this.title = title;
            this.genres = genres;
            this.imageURL = imageURL;
        }

        public Anime(int idAnime, String title, String genres, String imageURL, String synopsis, int episodes, String status, double rating, int favorite)
        {
            this.idAnime = idAnime;
            this.title = title;
            this.genres = genres;
            this.imageURL = imageURL;
            this.synopsis = synopsis;
            this.episodes = episodes;
            this.status = status;
            this.rating = rating;

            // Set favourite value
            this.favorite = favorite != 0;
        }

        public int getIdAnime()     { return idAnime; }
        public String getTitle()    { return title; }
        public String getGenres()   { return genres; }
        public String getImageURL() { return imageURL; }
        public int getEpisodes()    { return episodes; }
        public double getRating()   { return rating; }
        public boolean isFavorite() { return favorite; }
        public String getSynopsis() { return synopsis; }
        public String getStatus()   { return status; }
    }

    // Adapter para el ListView
    public class ListViewAdapter extends BaseAdapter
    {
        Context c;
        ArrayList<Anime> animes;

        // obtener el contexto y el array de animes con el constructor
        public ListViewAdapter(Context c, ArrayList<Anime> animes)
        {
            this.c = c;
            this. animes = animes;
        }

        @Override
        // Devulve el numero de animes
        public int getCount() { return animes.size(); }

        @Override
        // Devuelve un item de la lista
        public Object getItem(int i) { return animes.get(i); }

        @Override
        // Devuelve la posicion del item
        public long getItemId(int i) { return i; }

        @Override
        // Establecer el layout personalizado para el ListView
        public View getView(int position, View view, ViewGroup viewGroup)
        {
            // inflamos el layout en el ListView
            if (view == null)
            {
                view = LayoutInflater.from(c).inflate(R.layout.row_model, viewGroup, false);
            }

            TextView animeName = view.findViewById(R.id.animeNameTextView);
            TextView animeGenres = view.findViewById(R.id.animeGenresTextView);
            ImageView animeImage = view.findViewById(R.id.animeImageView);

            final Anime anime = (Anime) getItem(position);

            animeName.setText(anime.getTitle());
            animeGenres.setText(anime.getGenres());

            // Cargar la imagen del anime
            if (anime.getImageURL() != null && anime.getImageURL().length() > 0)
            {
                Picasso.get().load(anime.imageURL).placeholder(R.drawable.placeholder).into(animeImage);

            } else
            {
                Toast.makeText(c, "Empty Image URL", Toast.LENGTH_LONG).show();
                Picasso.get().load(R.drawable.placeholder).into(animeImage);
            }

            //TODO Evento para abrir el anime en el AnimeView
            view.setOnClickListener(v ->
            {
                Intent intent = new Intent(MainActivity.this, AnimeView.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("anime", anime);
                intent.putExtras(bundle);

                startActivity(intent);
            });

            return view;
        }
    }

    // Clase para conectarse a la BD y obtener los datos
    public class DataRetriever
    {
        private static final String PHP_SITE_URL = "https://demeuldre-site.000webhostapp.com/";
        // Campos de la instancia
        private final Context c;
        private ListViewAdapter adapter;

        public DataRetriever(Context c) { this.c = c; }

        // Metodo para recibir/seleccionar/refrescar la informacion
        public void retreive(final ListView gv, final ProgressBar progressBar)
        {
            final ArrayList<Anime> animes = new ArrayList<>();

            progressBar.setIndeterminate(true);
            progressBar.setVisibility(View.VISIBLE);

            AndroidNetworking.get(PHP_SITE_URL)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONArray(new JSONArrayRequestListener()
                    {
                        @Override
                        public void onResponse(JSONArray response)
                        {
                            JSONObject jsonObject;
                            Anime anime;

                            try
                            {
                                for (int i = 0; i < response.length(); i++)
                                {
                                    // obtener la informacion de la base de datos en forma de json y pasarlo en variables basicas
                                    jsonObject = response.getJSONObject(i);

                                    int idAnime = jsonObject.getInt("idAnime");
                                    String title = jsonObject.getString("title");
                                    String genres = jsonObject.getString("genre");
                                    String imageURL = jsonObject.getString("image");
                                    String synopsis = jsonObject.getString("synopsis");
                                    int episodes = jsonObject.getInt("episodes");
                                    String status = jsonObject.getString("satus");
                                    double rating = jsonObject.getDouble("rating");
                                    int favorite = jsonObject.getInt("favorite");

                                    // Crear el objeto anime y agregarlo en la lista de animes
                                    Anime animeEntity = new Anime(idAnime, title, genres, imageURL, synopsis, episodes, status, rating, favorite);
                                    animes.add(animeEntity);
                                }

                                // Cargar el adapter con la informacion que hemos obtenido
                                adapter = new ListViewAdapter(c, animes);
                                gv.setAdapter(adapter);
                                progressBar.setVisibility(View.GONE);

                            } catch (JSONException e)
                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(c, "GOOD RESPONSE BUT JAVA CAN'T PARSE JSON IT RECEIEVED. " + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onError(ANError anError)
                        {
                            anError.printStackTrace();
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(c, "UNSUCCESSFUL :  ERROR IS : " + anError.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.animeListView);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        new DataRetriever(MainActivity.this).retreive(listView, progressBar);
    }
}
