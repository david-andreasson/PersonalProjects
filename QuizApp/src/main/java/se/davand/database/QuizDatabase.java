package se.davand.database;

import se.davand.models.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDatabase {

    private static final String DATABASE_URL = "data/quiz.db";

    // Method to establish a database connection
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + DATABASE_URL);
    }

    // Method to fetch questions for a specific course
    public static List<Question> getQuestionsForCourse(String courseName) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions WHERE course_name = ?";

        try (Connection conn = connect();  // Establish the connection
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, courseName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String questionText = rs.getString("question_text");
                List<String> options = List.of(
                        "A) " + rs.getString("option_a"),
                        "B) " + rs.getString("option_b"),
                        "C) " + rs.getString("option_c"),
                        "D) " + rs.getString("option_d")
                );
                String correctOption = rs.getString("correct_option");
                questions.add(new Question(questionText, options, correctOption));
            }

        } catch (SQLException e) {
            System.err.println("Error fetching questions: " + e.getMessage());
            e.printStackTrace();
        }

        return questions;
    }
}
