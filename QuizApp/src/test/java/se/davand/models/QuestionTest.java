package se.davand.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    @Test
    void testIsCorrectWithCorrectAnswer() {
        Question question = new Question(
                "What is the capital of Sweden?",
                List.of("A) Stockholm", "B) Berlin", "C) Bangkok", "D) London"),
                "A"
        );
        assertTrue(question.isCorrect("A"));
    }

    @Test
    void testIsCorrectWithIncorrectAnswer() {
        Question question = new Question(
                "What is the capital of Sweden?",
                List.of("A) Stockholm", "B) Berlin", "C) Bangkok", "D) London"),
                "A"
        );
        assertFalse(question.isCorrect("B"));
    }
}
