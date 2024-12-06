package se.davand.services;

import se.davand.database.QuizDatabase;
import se.davand.models.Question;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizService {

    public void runQuiz(String courseName, String orderType) {
        List<Question> questions = QuizDatabase.getQuestionsForCourse(courseName);

        if (questions.isEmpty()) {
            System.out.println("No questions found for this course.");
            return;
        }

        // Adjust the order of questions based on user's choice
        switch (orderType) {
            case "RANDOM" -> Collections.shuffle(questions);
            case "REVERSE" -> Collections.reverse(questions);
        }

        int correctAnswers = 0;
        int totalQuestions = 0;

        Scanner scanner = new Scanner(System.in);

        // Loop through the questions
        for (Question question : questions) {
            System.out.println("\n" + question.getQuestionText());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A, B, C, D), or type E to exit to the main menu: ");
            String userAnswer = getUserAnswer(scanner);

            // If the user types 'E', exit the quiz and return to the course menu
            if (userAnswer.equals("E")) {
                System.out.println("Exiting to the main menu...");
                return;
            }

            // Check the user's answer
            totalQuestions++;
            if (question.isCorrect(userAnswer)) {
                correctAnswers++;
                System.out.println("Correct!");
            } else {
                System.out.printf("Wrong! The correct answer was %s.%n", question.getCorrectOption());
            }

            // Calculate and display statistics
            double errorRate = ((double) (totalQuestions - correctAnswers) / totalQuestions) * 100;
            System.out.printf("Right answers so far: %d%n", correctAnswers);
            System.out.printf("Error rate: %.2f%%%n", errorRate);
        }
    }

    // Method to get the user's answer (A, B, C, D, or E)
    private String getUserAnswer(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();

            // Validate the input (must be A, B, C, D, or E)
            if (input.matches("[A-E]")) {
                return input; // Return valid input
            }

            System.out.println("Invalid input. Please enter A, B, C, D, or E to exit.");
        }
    }
}
