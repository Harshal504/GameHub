package com.gamehubcdac.game;

public class ConsoleGame extends Game {
    public ConsoleGame(String name, String genre, int rating) {
        super(name, genre, rating, "Console");
    }

    @Override
    void displayDetails() {
        System.out.println(this.toString());
    }
}
