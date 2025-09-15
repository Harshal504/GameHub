package com.gamehubcdac.game;

import com.gamehubcdac.exceptions.InvalidRatingException;

import java.util.Comparator;

public abstract class Game implements Comparable<Game>{
    private String name;
    private String genre;
    private int rating;
    private String platform;
    private int id;
    private boolean isBorrowed;
    private static int idCounter = 1;

    public Game(String name, String genre, int rating, String platform) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.platform = platform;
        this.id=idCounter++;
        this.isBorrowed=false;
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
        try{
            if(rating<0 || rating>5){
                throw new InvalidRatingException("Invalid Rating");
            }
            this.rating = rating;

        }catch (InvalidRatingException e){

        }
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
        this.id = idCounter++;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", platform='" + platform + '\'' +
                ", id=" + id +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    abstract void displayDetails();

    @Override
    public int compareTo(Game o) {
        return Integer.compare(this.id, o.id);
    }
}

