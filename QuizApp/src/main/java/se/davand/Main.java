package se.davand;

import se.davand.database.QuizDatabase;
import se.davand.ui.MenuHandler;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            QuizDatabase.connect();  // Testar databasanslutningen och fångar eventuella fel
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
            return;  // Avsluta programmet om anslutningen misslyckas
        }

        MenuHandler menuHandler = new MenuHandler();
        menuHandler.startMenu();  // Startar menyhanteringen
    }
}
