package com.wincest.animedb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder>
{
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView)
        {
            super (itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    private List<Anime> animeList;

    // Constructor
    public AnimeAdapter(List<Anime> animeList)
    {
        this.animeList = animeList;
    }

    // Usar el layout que hemos creado
    @Override
    public AnimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // inflate the custom layout
        View animeView = inflater.inflate(R.layout.recycler_layout, parent, false);

        // Retunr the holder instance
        ViewHolder viewHolder = new ViewHolder(animeView);
        return viewHolder;
    }

    // Mete los datos en el item holder
    @Override
    public void onBindViewHolder(AnimeAdapter.ViewHolder viewHolder, int position)
    {
        // Get the data model based on position
        Anime anime = animeList.get(position);

        // Set items views based on your views and data model
        ImageView imageView = viewHolder.imageView;
        // imageView. -> set the imageview to get the img
        TextView textView = viewHolder.textView;
        textView.setText(anime.getTitle());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount()
    {
        return animeList.size();
    }
}
