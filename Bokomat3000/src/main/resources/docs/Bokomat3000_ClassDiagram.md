# Klassdiagram för Bokomat3000

```mermaid
classDiagram
    class User {
        +int id
        +String name
        +int apartmentNumber
    }

    class Booking {
        +int id
        +int userId
        +Date date
        +Time timeslot
    }

    class BookingRepository {
        +addUser(User user)
        +addBooking(Booking booking)
        +getBookingById(int id) Booking
        +getBookingsByUser(User user) List~Booking~
        +deleteBooking(int id)
    }

    class BookingService {
        +isTimeslotAvailable(Date date, Time timeslot) boolean
        +createBooking(User user, Date date, Time timeslot)
        +cancelBooking(int bookingId)
        +getBookingsForUser(User user) List~Booking~
    }

    User "1" --> "*" Booking : bokar
    BookingService --> BookingRepository : använder
    ```
