package com.gamehubcdac.game;

public interface GameActions {
    void addGame(String name, String genre, int rating, String platform);

    void removeGame(int id);

    void viewGames(String sortBy);

    void searchGame(String keyword);

    void registerUser(String username, String email);

    void viewUsers();

    void issueGame(int gameId, String username);

    void returnGame(int gameId, String username);

    void displayBorrowedQueue();

    void collectionStatistics();

    void userStatistics();
}
