package se.davand.app;

import se.davand.database.DatabaseConfig;
import se.davand.repository.BookingRepository;
import se.davand.repository.UserRepository;
import se.davand.model.Booking;
import se.davand.model.User;
import se.davand.model.Timeslot;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Initialize the database and ensure tables are created
        DatabaseConfig.initializeDatabase();

        // Initialize repositories
        UserRepository userRepo = new UserRepository();
        BookingRepository bookingRepo = new BookingRepository();

        // Create a new user to ensure the userId exists in the database
        User user = new User(101, "Test User", "A101", "testuser@example.com", "123456789", "passwordHash");
        boolean userAdded = userRepo.addUser(user); // Add user to the database
        System.out.println("User added: " + userAdded); // Print confirmation

        // Create a new booking for the user
        Booking booking = new Booking(1, 101, LocalDate.now(), Timeslot.MORNING); // All required parameters
        boolean bookingAdded = bookingRepo.addBooking(booking); // Add booking to the database
        System.out.println("Booking added: " + bookingAdded); // Print confirmation

        // Retrieve and print the booking
        Booking retrievedBooking = bookingRepo.getBookingById(booking.getId()); // Fetch the booking by ID
        System.out.println("Retrieved Booking: " + retrievedBooking); // Print the booking details

        // Update the booking to a different timeslot
        booking.setTimeslot(Timeslot.EVENING); // Change timeslot
        boolean bookingUpdated = bookingRepo.updateBooking(booking); // Update booking in database
        System.out.println("Booking updated: " + bookingUpdated); // Print confirmation

        // Verify the update
        Booking updatedBooking = bookingRepo.getBookingById(booking.getId()); // Fetch the updated booking
        System.out.println("Updated Booking: " + updatedBooking); // Print updated details

        // Delete the booking
        boolean bookingDeleted = bookingRepo.deleteBooking(booking.getId()); // Delete the booking
        System.out.println("Booking deleted: " + bookingDeleted); // Print confirmation

        // Verify deletion
        Booking deletedBooking = bookingRepo.getBookingById(booking.getId()); // Try fetching deleted booking
        System.out.println("Deleted Booking (should be null): " + deletedBooking); // Should print null
    }
}
