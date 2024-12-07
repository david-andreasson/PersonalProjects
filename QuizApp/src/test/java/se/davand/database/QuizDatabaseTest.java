package se.davand.database;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class QuizDatabaseTest {

    @Test
    public void testConnect_SuccessfulConnection() {
        // Försök att ansluta till en riktig databasfil
        try (Connection connection = QuizDatabase.connect()) {
            assertNotNull(connection, "Connection should not be null");
            assertTrue(connection.isValid(2), "Connection should be valid");
        } catch (SQLException e) {
            fail("Connection should be established without exception: " + e.getMessage());
        }
    }
}
