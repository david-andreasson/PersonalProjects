package se.davand.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QuizDatabase {

    private static final String DATABASE_URL = "data/quiz.db";

    // Method to connect to the SQLite database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_URL);
            System.out.println("Connection to SQLite successful.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
        return conn;
    }
}

