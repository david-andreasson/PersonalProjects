package se.davand.ui;

import se.davand.models.Movie;
import se.davand.services.WatchlistService;

import java.util.Scanner;

public class MenuHandler {
    private boolean menuIsRunning = true;

    Scanner scanner = new Scanner(System.in);
    WatchlistService watchlistService = new WatchlistService();

    public void displayMenu() {
        System.out.println("1. Add movie to watchlist");
        System.out.println("2. Mark movie as watched");
        System.out.println("3. Remove movie from watchlist");
        System.out.println("4. List all movies in watchlist");
        System.out.println("5. Exit");
    }

    public void runMenu() {
        while (menuIsRunning) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    Movie movie = movieFromUserInput();
                    watchlistService.addMovie(movie);
                    System.out.println(movie.getTitle() + " added to watchlist.");
                    break;
                }
                case 2 -> {
                    System.out.println("Enter movie title: ");
                    String watchedTitle = scanner.nextLine();
                    watchlistService.markMovieAsWatched(watchedTitle);
                    break;
                }
                case 3 -> {
                    System.out.println("Enter movie title: ");
                    String removeTitle = scanner.nextLine();
                    watchlistService.removeMovie(removeTitle);
                    break;
                }
                case 4 -> {
                    watchlistService.listAllMoviesInWatchlist();
                    break;
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    menuIsRunning = false;
                    break;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private Movie movieFromUserInput() {
        System.out.println("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.println("Enter movie year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter movie genre: ");
        String genre = scanner.nextLine();
        System.out.println("Enter movie rating: ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter movie watched status. Enter true for watched or false for not watched: ");
        boolean watched = scanner.nextBoolean();
        scanner.nextLine();
        Movie movie = new Movie(title, genre, watched, rating, year);
        return movie;
    }
}
