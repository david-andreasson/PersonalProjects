package se.davand.services;

import se.davand.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class WatchlistService {

    private List<Movie> watchlist;

    public WatchlistService() {
        this.watchlist = new ArrayList<>();
    }

    public boolean addMovie(Movie movie) {
        if (movie == null || movie.getTitle() == null || movie.getTitle().isBlank()) {
            System.out.println("Invalid movie. Please provide a valid movie with a title.");
            return false;
        }

        // Använd hjälpmetoden för att söka efter filmen
        if (findMovieByTitle(movie.getTitle()) != null) {
            System.out.println("Movie already exists in watchlist: " + movie.getTitle());
            return false;
        }
        watchlist.add(movie);
        System.out.println("Movie added to watchlist: " + movie.getTitle());
        return true;
    }


    public boolean removeMovie(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie != null) {
            watchlist.remove(movie);
            System.out.println("Movie removed from watchlist: " + title);
            return true;
        }
        System.out.println("Movie not found: " + title);
        return false;
    }

    public void listAllMoviesInWatchlist() {
        if (watchlist.isEmpty()) {
            System.out.println("Watchlist is empty.");
        } else {
            System.out.println("####======= WATCHLIST =======####");
            System.out.println();
            for (Movie movie : watchlist) {
                System.out.println(movie.getTitle() + " - " + movie.getYear());
            }
            System.out.println();
            System.out.println("####=========================####");
        }
    }

    public void markMovieAsWatched(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie == null) {
            System.out.println("Movie not found: " + title);
            return;
        }
        if (movie.isWatched()) {
            System.out.println("Movie is already marked as watched: " + movie.getTitle());
            return;
        }

        if (movie != null) {
            movie.setWatched(true);
            System.out.println("Movie marked as watched: " + movie.getTitle());
        } else {
            System.out.println("Movie not found: " + title);
        }
    }


    //Helper function to find a movie by title
    private Movie findMovieByTitle(String title) {
        for (Movie movie : watchlist) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

}
