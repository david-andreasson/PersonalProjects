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
        for (Movie m : watchlist) {
            if (m.getTitle().equalsIgnoreCase(movie.getTitle())) {
                System.out.println("Movie already exists in watchlist: " + movie.getTitle());
                return false;
            }
        }
        watchlist.add(movie);
        System.out.println("Movie added to watchlist: " + movie.getTitle());
        return true;
    }


    public boolean removeMovie(String title) {
        boolean removed = watchlist.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Movie removed: " + title);
        } else {
            System.out.println("Movie not found: " + title);
        }
        return removed;
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
}
