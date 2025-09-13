package com.gamehubcdac;
import com.gamehubcdac.game.Game;
import com.gamehubcdac.game.GameManager;

import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Game> games = new HashSet<Game>();

        games.add(new Game(101,"The Witcher 3", "RPG", 5, "PC"));
        games.add(new Game(102,"God of War", "Action", 5, "Console"));
//        games.add(new Game("Minecraft", "Sandbox", 4, "PC"));
//        games.add(new Game("FIFA 23", "Sports", 3, "Console"));
//        games.add(new Game("The Witcher 3", "RPG", 5, "PC"));

        GameManager gM= new GameManager();

        gM.addGame(games,103,"Minecraft", "Sandbox", 4, "PC" );
        System.out.println(games);


        gM.removeGame(games, 102);
        System.out.println(games);

        ArrayList<Game> allgames = new ArrayList<Game>(games);
        gM.viewGames(allgames, "ID");
        System.out.println(allgames);

        gM.searchGame(games, "RPG");

    }
}