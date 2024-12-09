package se.davand.services;

import se.davand.database.QuizDatabase;
import se.davand.models.Question;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizService {

    public void runQuiz(String courseName, String orderType) {
        List<Question> questions = fetchAndOrderQuestions(courseName, orderType);

        if (questions.isEmpty()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        askQuestions(questions, scanner);
    }

    private List<Question> fetchAndOrderQuestions(String courseName, String orderType) {
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

    private void askQuestions(List<Question> questions, Scanner scanner) {
        int correctAnswers = 0;
        int totalQuestions = 0;

        for (Question question : questions) {
            // Visa frågan med boxad stil
            System.out.println("==========================================================================================================");
            System.out.println( question.getQuestionText());
            System.out.println("==========================================================================================================");
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A, B, C, D), or type E to exit to the main menu: ");
            String userAnswer = getUserAnswer(scanner);

            if (userAnswer.equals("E")) {
                System.out.println("Exiting to the main menu...");
                return;
            }

            totalQuestions++;
            if (question.isCorrect(userAnswer)) {
                System.out.println("+------------------+");
                System.out.println("|     Correct!     |");
                System.out.println("+------------------+");
                correctAnswers++;
            } else {
                System.out.println("+------------------+");
                System.out.printf("|      Wrong!       |\n");
                System.out.printf("|    Correct: %s    |\n", question.getCorrectOption());
                System.out.println("+------------------+");
            }

            showStatistics(correctAnswers, totalQuestions);
        }
    }

    private void showStatistics(int correctAnswers, int totalQuestions) {
        double errorRate = ((double) (totalQuestions - correctAnswers) / totalQuestions) * 100;
        System.out.printf("Right answers so far: %d%n", correctAnswers);
        System.out.printf("Error rate: %.2f%%%n", errorRate);
    }

    private String getUserAnswer(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("[A-E]")) {
                return input;
            }
            System.out.println("Invalid input. Please enter A, B, C, D, or E to exit.");
        }
    }
}
