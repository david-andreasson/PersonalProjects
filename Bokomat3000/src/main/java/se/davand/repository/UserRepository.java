package se.davand.repository;

import se.davand.database.DatabaseConfig;
import se.davand.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    // Method to add a new user to the database
    public boolean addUser(User user) {
        String sql = "INSERT INTO Users (name, apartmentNumber, email, phonenumber, password_hash) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getApartmentNumber());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhoneNumber());
            //pstmt.setString(5, user.getPasswordHash());  // Password should be hashed before storing
            //TODO password hashing function

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
