package se.davand.services;

import se.davand.models.Question;

import java.util.List;
import java.util.Scanner;

public class QuizRunner {
    public void runQuiz(List<Question> questions) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        int totalQuestions = 0;

        for (Question question : questions) {
            System.out.println("==========================================================================================================");
            System.out.println(question.getQuestionText());
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

            new QuizStatistics().showStatistics(correctAnswers, totalQuestions);
        }
    }

    private String getUserAnswer(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("[A-E]")) {
                return input;
            }
            System.out.println("Invalid input. Please enter A, B, C, D, or press E to exit.");
        }
    }
}