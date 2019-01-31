package com.wincest.animedb;

import java.io.Serializable;

public class Anime implements Serializable
{
    private int idAnime, episodes;
    private double rating;
    private boolean favorite;
    private String title, genres, imageURL, synopsis, status;

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