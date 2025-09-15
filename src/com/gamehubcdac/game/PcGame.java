package com.gamehubcdac.game;

public class PcGame extends Game {
    public PcGame(String name, String genre, int rating) {
        super(name, genre, rating, "PC");
    }

    @Override
    void displayDetails() {
        System.out.println(this.toString());
    }
}
