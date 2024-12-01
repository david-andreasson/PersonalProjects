package se.davand;

import se.davand.models.Movie;
import se.davand.services.WatchlistService;

public class Main {
    public static void main(String[] args) {


        WatchlistService watchlistService = new WatchlistService();

        watchlistService.addMovie(new Movie("The Shawshank Redemption", "Drama", false, 9, 1994));
        watchlistService.addMovie(new Movie("The Godfather", "Crime", false, 9, 1972));
        watchlistService.addMovie(new Movie("The Dark Knight", "Action", false, 8, 2008));
        watchlistService.addMovie(new Movie("The Godfather: Part II", "Crime", false, 9, 1974));
        watchlistService.addMovie(new Movie("12 Angry Men", "Drama", false, 8, 1957));

        watchlistService.listAllMoviesInWatchlist();
    }

}