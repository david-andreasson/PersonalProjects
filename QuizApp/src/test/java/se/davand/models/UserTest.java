package se.davand.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGetUsernameWithCorrectName() {
        User user = new User(1, "Bengt");
        assertTrue(user.getUsername().equals("Bengt"));
    }

    @Test
    void testGetUsernameWithInorrectName() {
        User user = new User(1, "Bill");
        assertFalse(user.getUsername().equals("Billy"));
    }

    @Test
    void getIdwithCorrectId() {
        User user = new User(1, "Bengt");
        assertTrue(user.getId() == 1);
    }

    @Test
    void getIdwithIncorrectId() {
        User user = new User(1, "Bengt");
        assertFalse(user.getId() == 2);
    }
}