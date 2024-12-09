package se.davand;

import se.davand.database.QuizDatabase;
import se.davand.models.User;
import se.davand.services.AuthService;
import se.davand.ui.MenuHandler;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Testar databasanslutningen och fångar eventuella fel
        try {
            QuizDatabase.connect();
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
            return;  // Avsluta programmet om anslutningen misslyckas
        }

        // Hantera inloggning
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        User user = authService.login(username);

        if (user != null) {
            System.out.println("Welcome, " + user.getUsername() + "!");
            MenuHandler menuHandler = new MenuHandler(user);
            menuHandler.startMenu();  // Startar menyhanteringen med inloggad användare
        } else {
            System.out.println("Login failed. Exiting...");
        }
    }
}
