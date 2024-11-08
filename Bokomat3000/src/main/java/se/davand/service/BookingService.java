package se.davand.service;

import se.davand.model.Booking;
import se.davand.model.Timeslot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();

    public BookingService() {
        bookings.add(new Booking(1, 101, 201, LocalDate.now(), Timeslot.MORNING));
        bookings.add(new Booking(2, 102, 202, LocalDate.now(), Timeslot.LATE_MORNING));
        bookings.add(new Booking(3, 102, 203, LocalDate.now(), Timeslot.AFTERNOON));
        bookings.add(new Booking(4, 104, 204, LocalDate.now(), Timeslot.LATE_AFTERNOON));
        bookings.add(new Booking(5, 105, 205, LocalDate.now(), Timeslot.EVENING));
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Booking getBooking(int id) {
        return bookings.stream().filter(booking -> booking.getId() == id).findFirst().orElse(null);
    }

    public boolean isTimeslotAvailable(LocalDate date, Timeslot timeslot) {
        return bookings.stream()
                .noneMatch(booking -> booking.getDate().equals(date) && booking.getTimeslot() == timeslot);
    }

    public void addBooking(Booking booking) {
        if (getBooking(booking.getId()) != null) {
            System.out.println("Booking with this ID already exists.");
        } else if (!isTimeslotAvailable(booking.getDate(), booking.getTimeslot())) {
            System.out.println("The selected timeslot is not available.");
        } else {
            bookings.add(booking);
        }
    }

    public void updateBooking(int id, Booking booking) {
        Booking oldBooking = getBooking(id);
        if (oldBooking != null) {
            oldBooking.setDate(booking.getDate());
            oldBooking.setTimeslot(booking.getTimeslot());
            oldBooking.setUserId(booking.getUserId());
            oldBooking.setApartmentId(booking.getApartmentId());
        }
    }

    public void deleteBooking(int id) {
        bookings.removeIf(booking -> booking.getId() == id);
    }
}