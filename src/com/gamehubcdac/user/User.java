package com.gamehubcdac.user;

import com.gamehubcdac.game.Game;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String email;
    List<Game> borrowedGames;


    public User(String userName , String email) {
        this.userName = userName;
        this.email = email;

        borrowedGames = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Game> getBorrowedGames() {
        return borrowedGames;
    }

    public void setBorrowedGames(List<Game> borrowedGames) {
        this.borrowedGames = borrowedGames;
    }

    public void addBorrowedGame(Game g) {
        borrowedGames.add(g);
    }
    public void removeBorrowedGame(Game g) {
        borrowedGames.remove(g);
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", borrowedGames=" + borrowedGames.size() +
                '}';
    }
}

