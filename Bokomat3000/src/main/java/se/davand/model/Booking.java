package se.davand.model;

import java.time.LocalDate;

public class Booking {
    private int id;
    private int userId;
    private LocalDate date;        // Day for the booking
    private Timeslot timeslot;     // Timeslot for the booking

    // Constructor without apartmentId
    public Booking(int id, int userId, LocalDate date, Timeslot timeslot) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.timeslot = timeslot;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", timeslot=" + timeslot +
                '}';
    }
}
