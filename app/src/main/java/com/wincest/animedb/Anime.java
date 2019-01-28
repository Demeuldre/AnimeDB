package com.wincest.animedb;

public class Anime
{
    private int idAnime;
    private int episodes;
    private double rating;
    private boolean favourite;
    private String status;
    private String title;
    private String genres;
    private String synopsis;
    private String image;

    // Constructor
    Anime(int idAnime, int episodes, double rating, String title,
                 String genres, String status, String synopsis, String image)
    {
        this.idAnime = idAnime;
        this.episodes = episodes;
        this.rating = rating;
        this.title = title;
        this.genres = genres;
        this.status = status;
        this.synopsis = synopsis;
        this.image = image;
    }


    public int getIdAnime()
    {
        return idAnime;
    }

    public int getEpisodes()
    {
        return episodes;
    }

    public float getRating()
    {
        return rating;
    }

    public boolean isFavourite()
    {
        return favourite;
    }

    public String getStatus()
    {
        return status;
    }

    public String getTitle()
    {
        return title;
    }

    public String getGenres()
    {
        return genres;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public String getImage()
    {
        return image;
    }
}
