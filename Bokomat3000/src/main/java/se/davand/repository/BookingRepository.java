package se.davand.repository;

import se.davand.database.DatabaseConfig;
import se.davand.model.Booking;
import se.davand.model.Timeslot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Booking getBookingById(int id) {
        String sql = "SELECT * FROM Booking WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Booking(
                        rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getDate("date").toLocalDate(),
                        Timeslot.valueOf(rs.getString("timeslot"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no booking found
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getDate("date").toLocalDate(),
                        Timeslot.valueOf(rs.getString("timeslot"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
    public boolean updateBooking(Booking booking) {
        String sql = "UPDATE Booking SET userId = ?, date = ?, timeslot = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, booking.getUserId());
            pstmt.setDate(2, java.sql.Date.valueOf(booking.getDate()));
            pstmt.setString(3, booking.getTimeslot().name());
            pstmt.setInt(4, booking.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteBooking(int id) {
        String sql = "DELETE FROM Booking WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
