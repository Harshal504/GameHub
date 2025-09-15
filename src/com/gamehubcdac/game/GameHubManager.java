package com.gamehubcdac.game;

import com.gamehubcdac.comparator.GameCompareName;
import com.gamehubcdac.comparator.GameCompareRating;
import com.gamehubcdac.exceptions.GameNotFoundException;
import com.gamehubcdac.exceptions.InvalidRatingException;
import com.gamehubcdac.exceptions.UserNotFoundException;
import com.gamehubcdac.user.User;

import java.util.*;

public class GameHubManager implements GameActions {

    private ArrayList<Game> allGames = new ArrayList<>();
    private LinkedList<Game> borrowedQueue = new LinkedList<>();
    private HashSet<User> users = new HashSet<>();
    private HashMap<Integer, Game> gameMap = new HashMap<>();

    @Override
    public void addGame(String name, String genre, int rating, String platform) {
        try {
            if (rating < 1 || rating > 5)
                throw new InvalidRatingException("Rating must be between 1 and 5.");

            Game g;
            if (platform.equalsIgnoreCase("Console")) {
                g = new ConsoleGame(name, genre, rating);
            } else {
                g = new PcGame(name, genre, rating);
            }
            allGames.add(g);
            gameMap.put(g.getId(), g);
            System.out.println("Game added successfully! ID: " + g.getId());
        } catch (InvalidRatingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    @Override
    public void removeGame(int id) {
        try {
            Game g = gameMap.get(id);
            if (g == null) throw new GameNotFoundException("Game not found.");
            if (g.isBorrowed()) {
                System.out.println("Cannot remove: Game is borrowed.");
                return;
            }
            allGames.remove(g);
            gameMap.remove(id);
            System.out.println("Game removed successfully!");
        } catch (GameNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void viewGames(String sortBy) {
        List<Game> sorted = new ArrayList<>(allGames);
        if (sortBy.equalsIgnoreCase("Name")) {
            sorted.sort(new GameCompareName());
        } else if (sortBy.equalsIgnoreCase("Rating")) {
            sorted.sort(new GameCompareRating());
        } else {
            Collections.sort(sorted); // By ID
        }
        sorted.forEach(Game::displayDetails);
    }

    @Override
    public void searchGame(String keyword) {
        for (Game g : allGames) {
            if (g.getName().equalsIgnoreCase(keyword) || g.getGenre().equalsIgnoreCase(keyword)) {
                g.displayDetails();
            }
        }
    }

    // ---------------- User Management ----------------
//    2.2 User Management
//● Register User
//➔ Input: Username, Email
//➔ Validation: Username must be unique
//➔ Output: Confirmation message
//● View Users
//➔ Output: List of all registered users

    @Override
    public void registerUser(String username, String email) {
        for (User u : users) {
            if (u.getUserName().equalsIgnoreCase(username)) {
                System.out.println("Error: Username already exists.");
                return;
            }
        }
        User u = new User(username, email);
        users.add(u);
        System.out.println("User registered successfully!");
    }

    @Override
    public void viewUsers() {
        users.forEach(System.out::println);
    }

    // ---------------- Borrowing System ----------------
//    2.3 Borrowing System
//● Issue Game
//➔ Input: Game ID, Username
//➔ Validation: Game must be available, User must exist
//➔ Action: Move game to borrowedQueue, add game to user’s borrowed list
//➔ Output: Success/Error message
//● Return Game
//➔ Input: Game ID, Username
//➔ Validation: Only borrower can return the game
//➔ Action: Move game back to available list
//➔ Output: Success/Error message
//● Borrowed Games Queue
//➔ Output: Display current borrowed games in queue order

    @Override
    public void issueGame(int gameId, String username) {
        try {
            Game g = gameMap.get(gameId);
            if (g == null) throw new GameNotFoundException("Game not found.");
            if (g.isBorrowed()) {
                System.out.println("Game already borrowed.");
                return;
            }
            User user = null;
            for (User u : users) {
                if (u.getUserName().equalsIgnoreCase(username)) {
                    user = u;
                    break;
                }
            }            if (user == null) throw new UserNotFoundException("User not found.");

            g.setBorrowed(true);
            borrowedQueue.add(g);
            user.addBorrowedGame(g);
            System.out.println("Game issued successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void returnGame(int gameId, String username) {
        try {
            Game g = gameMap.get(gameId);
            if (g == null) throw new GameNotFoundException("Game not found.");
            User user = null;
            for (User u : users) {
                if (u.getUserName().equalsIgnoreCase(username)) {
                    user = u;
                    break;
                }
            }            if (user == null) throw new UserNotFoundException("User not found.");

            if (!user.getBorrowedGames().contains(g)) {
                System.out.println("Error: Only borrower can return.");
                return;
            }
            g.setBorrowed(false);
            borrowedQueue.remove(g);
            user.removeBorrowedGame(g);
            System.out.println("Game returned successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void displayBorrowedQueue() {
        borrowedQueue.forEach(Game::displayDetails);
    }

    // ---------------- Statistics ----------------
//    2.4 Reporting & Statistics
//● Collection Statistics
//➔ Total Games, Available Games, Borrowed Games
//● User Statistics
//➔ Total Registered Users
//● Borrowed Queue Display
//➔ Current games on loan
    @Override
    public void collectionStatistics() {
        long borrowed = allGames.stream().filter(Game::isBorrowed).count();
        System.out.println("Total Games: " + allGames.size());
        System.out.println("Available Games: " + (allGames.size() - borrowed));
        System.out.println("Borrowed Games: " + borrowed);
    }

    @Override
    public void userStatistics() {
        System.out.println("Total Registered Users: " + users.size());
    }
}

