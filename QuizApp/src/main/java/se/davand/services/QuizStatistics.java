package se.davand.services;

import se.davand.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizStatistics {
    public void showStatistics(int correctAnswers, int totalQuestions) {
        double errorRate = ((double) (totalQuestions - correctAnswers) / totalQuestions) * 100;
        System.out.printf("Right answers so far: %d%n", correctAnswers);
        System.out.printf("Error rate: %.2f%%%n", errorRate);
    }

    public void showResults(User user) {
        String sql = "SELECT course_name, score, total_questions FROM results WHERE user_id = ? ORDER BY rowid DESC LIMIT 10";

        try (Connection conn = se.davand.database.QuizDatabase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getId());
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n=== Last 10 Quiz Results ===");
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                int score = rs.getInt("score");
                int totalQuestions = rs.getInt("total_questions");

                System.out.printf("Course: %s | Score: %d/%d%n", courseName, score, totalQuestions);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}