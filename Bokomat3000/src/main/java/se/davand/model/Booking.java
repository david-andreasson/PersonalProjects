package se.davand.model;

import java.time.LocalDate;

public class Booking {
    private int id;
    private int userId;
    private int apartmentId;
    private LocalDate date;        // Day for the booking
    private Timeslot timeslot;     // Timeslot for the booking

    // Full constructor requiring all fields
    public Booking(int id, int userId, int apartmentId, LocalDate date, Timeslot timeslot) {
        this.id = id;
        this.userId = userId;
        this.apartmentId = apartmentId;
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

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
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
                ", apartmentId=" + apartmentId +
                ", date=" + date +
                ", timeslot=" + timeslot +
                '}';
    }
}
