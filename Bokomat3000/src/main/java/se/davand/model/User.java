package se.davand.model;

public class User {
    private int id;
    private String name;
    private int apartmentNumber;
    private String email;
    private String phoneNumber;

    // Full constructor requiring all fields
    public User(int id, String name, int apartmentNumber, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.apartmentNumber = apartmentNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", apartmentNumber=" + apartmentNumber
                + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
    }
}
