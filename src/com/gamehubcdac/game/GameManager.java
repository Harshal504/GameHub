package com.gamehubcdac.game;

import java.util.*;

public class GameManager {

//        games.add(new Game("Minecraft", "Sandbox", 4, "PC"));
//        games.add(new Game("FIFA 23", "Sports", 3, "Console"));
//        games.add(new Game("The Witcher 3", "RPG", 5, "PC"));
//  ● Add Game
//➔ Input: Name, Genre, Rating (1-5), Platform (Console/PC)
//➔ Validation: Rating must be 1-5
//➔ Action: Add game to allGames list
//➔ Output: Success message with game ID
    public void addGame(Set<Game> games,int id, String name, String genre, int rating, String platform){
        try {
            if (rating < 01 || rating > 5) {
                throw new IllegalArgumentException("Invalid Rating");
            }

            games.add(new Game(id, name, genre, rating, platform));
            System.out.println("Successfully added Game Id:"+id);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }








//● Remove Game
//➔ Input: Game ID
//➔ Validation: Cannot remove if game is borrowed
//➔ Output: Success/Error message
    public void removeGame(Set<Game> games, int id){
        
        try{
            int count=0;
            for(Game g: games){

                if(g.getId()==id){
                    games.remove(g);
                    System.out.println("Successfully removed Game with Id:"+id);
                    count++;
                }
            }
            if(count==0){
                throw new IllegalArgumentException("Error: Invalid Id");
            }
        }catch (Exception e){
          System.out.println(e.getMessage());
        }


    }









//● View Games
//➔ Options: Sort by ID, Name, Rating
//➔ Output: List of games with all details (platform-specific info included)
    public void viewGames(List<Game> allgames, String sort ){
        if(sort.equals("ID")){
            Collections.sort(allgames, new GameCompareId());
//            System.out.println(allgames);
        }else if(sort.equals("Name")){
            Collections.sort(allgames, new GameCompareName());
        }else if(sort.equals("Rating")){
            Collections.sort(allgames, new GameCompareRating());

        }
    }










//● Search Game
//➔ Input: Name or Genre
//➔ Output: Display matching games
    public void searchGame(Set<Game> games, String match){
        boolean b = false;
        try{
        for(Game g: games){
            if(g.getName().equals(match)||g.getGenre().equals(match)){
                System.out.println(g);
                b = true;
            }

        }
        if(!b){
            throw new IllegalArgumentException("No Such Name or Genre");
        }

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}
