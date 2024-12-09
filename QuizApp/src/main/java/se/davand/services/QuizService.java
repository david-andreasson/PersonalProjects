package se.davand.services;

import se.davand.models.User;
import se.davand.models.Question;

import java.util.List;

public class QuizService {
    private final QuestionFetcher questionFetcher = new QuestionFetcher();
    private final QuizRunner quizRunner = new QuizRunner();

    public void runQuiz(User user, String courseName, String orderType) {
        List<Question> questions = questionFetcher.fetchQuestions(courseName, orderType);

        if (!questions.isEmpty()) {
            quizRunner.runQuiz(user, questions, courseName);
        }
    }

    public int getQuestionCount(String courseName) {
        return questionFetcher.fetchQuestions(courseName, "ORDER").size();
    }
}
