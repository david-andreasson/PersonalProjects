package se.davand.services;

import se.davand.database.QuizDatabase;
import se.davand.models.Question;

import java.util.Collections;
import java.util.List;

public class QuestionFetcher {
    public List<Question> fetchQuestions(String courseName, String orderType) {
        List<Question> questions = QuizDatabase.getQuestionsForCourse(courseName);

        if (questions.isEmpty()) {
            System.out.println("No questions found for this course.");
            return questions;
        }

        switch (orderType) {
            case "RANDOM" -> Collections.shuffle(questions);
            case "REVERSE" -> Collections.reverse(questions);
        }

        return questions;
    }
}