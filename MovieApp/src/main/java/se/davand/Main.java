package se.davand;

import se.davand.models.Movie;
import se.davand.services.WatchlistService;
import se.davand.ui.MenuHandler;

public class Main {
    public static void main(String[] args) {


        MenuHandler menuHandler = new MenuHandler();
        menuHandler.runMenu();
    }

}