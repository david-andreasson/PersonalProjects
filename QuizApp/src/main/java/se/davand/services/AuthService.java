package se.davand.services;

import se.davand.models.User;

import java.sql.*;

public class AuthService {

    public User login(String username) {
        String selectSql = "SELECT user_id FROM users WHERE username = ?";
        String insertSql = "INSERT INTO users (username) VALUES (?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:data/quiz.db")) {

            // Försök att hämta användaren från databasen
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
                selectStmt.setString(1, username);
                ResultSet rs = selectStmt.executeQuery();

                if (rs.next()) {
                    return new User(rs.getInt("user_id"), username);
                }
            }

            // Om användaren inte finns, lägg till dem i databasen
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                insertStmt.setString(1, username);
                insertStmt.executeUpdate();

                ResultSet generatedKeys = insertStmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return new User(generatedKeys.getInt(1), username);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
