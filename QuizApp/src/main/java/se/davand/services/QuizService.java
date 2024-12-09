package se.davand.services;

import se.davand.models.Question;

import java.util.List;

public class QuizService {
    private final QuestionFetcher questionFetcher = new QuestionFetcher();
    private final QuizRunner quizRunner = new QuizRunner();

    public void runQuiz(String courseName, String orderType) {
        List<Question> questions = questionFetcher.fetchQuestions(courseName, orderType);
        if (!questions.isEmpty()) {
            quizRunner.runQuiz(questions);
        }
    }
}