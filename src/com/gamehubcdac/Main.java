package com.gamehubcdac;
import com.gamehubcdac.game.GameHubManager;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        GameHubManager manager = new GameHubManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== GAME HUB MENU ===");
            System.out.println("1. Add Game");
            System.out.println("2. Remove Game");
            System.out.println("3. View Games");
            System.out.println("4. Search Game");
            System.out.println("5. Register User");
            System.out.println("6. View Users");
            System.out.println("7. Issue Game");
            System.out.println("8. Return Game");
            System.out.println("9. Display Borrowed Queue");
            System.out.println("10. Collection Statistics");
            System.out.println("11. User Statistics");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter rating (1-5): ");
                    int rating = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter platform (Console/PC): ");
                    String platform = sc.nextLine();
                    manager.addGame(name, genre, rating, platform);
                    break;
                case 2:
                    System.out.print("Enter Game ID to remove: ");
                    int id = sc.nextInt();
                    manager.removeGame(id);
                    break;
                case 3:
                    System.out.print("Sort by (ID/Name/Rating): ");
                    String sortBy = sc.nextLine();
                    manager.viewGames(sortBy);
                    break;
                case 4:
                    System.out.print("Enter name/genre to search: ");
                    String keyword = sc.nextLine();
                    manager.searchGame(keyword);
                    break;
                case 5:
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    manager.registerUser(username, email);
                    break;
                case 6:
                    manager.viewUsers();
                    break;
                case 7:
                    System.out.print("Enter Game ID: ");
                    int gameId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter username: ");
                    String uname = sc.nextLine();
                    manager.issueGame(gameId, uname);
                    break;
                case 8:
                    System.out.print("Enter Game ID: ");
                    int returnId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter username: ");
                    String uReturn = sc.nextLine();
                    manager.returnGame(returnId, uReturn);
                    break;
                case 9:
                    manager.displayBorrowedQueue();
                    break;
                case 10:
                    manager.collectionStatistics();
                    break;
                case 11:
                    manager.userStatistics();
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}

