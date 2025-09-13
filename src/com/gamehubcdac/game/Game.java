package com.gamehubcdac.game;

import java.util.Comparator;

public class Game{
    private String name;
    private String genre;
    private int rating;
    private String platform;
    private int id;

    public Game(int id, String name, String genre, int rating, String platform) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.platform = platform;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", platform='" + platform + '\'' +
                ", id=" + id+ '\n';
    }
}


