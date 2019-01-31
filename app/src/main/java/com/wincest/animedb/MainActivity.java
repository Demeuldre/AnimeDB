package com.wincest.animedb;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    // Objeto POJO que representa un anime
    public class Anime
    {
        private int idAnime;
        private String title, genres, imageURL;

        public Anime(int idAnime, String title, String genres, String imageURL)
        {
            this.idAnime = idAnime;
            this.title = title;
            this.genres = genres;
            this.imageURL = imageURL;
        }

        public int getIdAnime()     { return idAnime; }
        public String getTitle()    { return title; }
        public String getGenres()   { return genres; }
        public String getImageURL() { return imageURL; }
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
            if (view != null)
            {
                view = LayoutInflater.from(c).inflate(R.layout.row_model, viewGroup, false);

            } else
            {
                return null;
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
                Toast.makeText(c, "Abrir la pagina con los detalles del anime", Toast.LENGTH_LONG).show();
            });

            return view;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
