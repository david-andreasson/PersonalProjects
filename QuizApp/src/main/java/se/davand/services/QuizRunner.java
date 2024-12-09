package se.davand.services;

import se.davand.models.Question;
import se.davand.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class QuizRunner {
    public void runQuiz(User user, List<Question> questions, String courseName) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        int totalAskedQuestions = 0;  // Ny räknare för ställda frågor

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
                break;  // Avsluta quizet om användaren väljer "E"
            }

            totalAskedQuestions++;  // Öka räknaren för varje besvarad fråga

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

            new QuizStatistics().showStatistics(correctAnswers, totalAskedQuestions);  // Använd totalAskedQuestions
        }

        saveResult(user, correctAnswers, totalAskedQuestions, courseName);
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

    private void saveResult(User user, int correctAnswers, int totalAskedQuestions, String courseName) {
        String sql = "INSERT INTO results (user_id, course_name, score, total_questions) VALUES (?, ?, ?, ?)";

        try (Connection conn = se.davand.database.QuizDatabase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, courseName);
            pstmt.setInt(3, correctAnswers);
            pstmt.setInt(4, totalAskedQuestions);
            pstmt.executeUpdate();
            System.out.println("Result saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
