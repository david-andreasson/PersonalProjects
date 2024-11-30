package se.davand.models;

public class Movie {
    private String title;
    private String genre;
    private boolean isWatched;
    private int rating;

    public Movie(String title, String genre, boolean isWatched, int rating) {
        this.title = title;
        this.genre = genre;
        this.isWatched = isWatched;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", isWatched=" + isWatched +
                ", rating=" + rating +
                '}';
    }
}
