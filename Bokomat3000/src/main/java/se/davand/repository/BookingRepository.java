package se.davand.database;

import se.davand.model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingRepository {

    // Method to add a new booking to the database
    public boolean addBooking(Booking booking) {
        String sql = "INSERT INTO Booking (userId, date, timeslot) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, booking.getUserId());
            pstmt.setDate(2, java.sql.Date.valueOf(booking.getDate()));
            pstmt.setString(3, booking.getTimeslot().name());  // Save Timeslot as String

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
