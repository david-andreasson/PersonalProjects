package se.davand.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizServiceTest {

    @Test
    void getQuestionCountOOP() {
        QuizService quizService = new QuizService();
        int questionCount = quizService.getQuestionCount("OOP Advanced");
        assertTrue(questionCount >= 165);
    }

    @Test
    void getQuestionCountTest() {
        QuizService quizService = new QuizService();
        int questionCount = quizService.getQuestionCount("OOP Basics");
        assertFalse(questionCount >= 165);
    }
}