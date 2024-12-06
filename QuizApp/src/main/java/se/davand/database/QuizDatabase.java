package se.davand.database;

import se.davand.models.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDatabase {

    private static final String DATABASE_URL = "data/quiz.db";

    // Method to connect to the SQLite database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_URL);
            System.out.println("Connection to SQLite successful.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
        return conn;
    }
    // Method to fetch questions for a specific course
    public static List<Question> getQuestionsForCourse(String courseName) {
        List<Question> questions = new ArrayList<>();

        String sql = "SELECT * FROM questions WHERE course_name = ?";

        try (Connection conn = connect(); // Use the connect() method to establish a database connection
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, courseName); // Bind course name to SQL query
            ResultSet rs = pstmt.executeQuery();

            // Loop through the result set and create Question objects
            while (rs.next()) {
                String questionText = rs.getString("question_text");
                List<String> options = List.of(
                        "A) " + rs.getString("option_a"),
                        "B) " + rs.getString("option_b"),
                        "C) " + rs.getString("option_c"),
                        "D) " + rs.getString("option_d")
                );
                String correctOption = rs.getString("correct_option"); // Fetch the correct option (e.g., 'B')

                // Create a new Question object and add it to the list
                questions.add(new Question(questionText, options, correctOption));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching questions: " + e.getMessage());
            e.printStackTrace();
        }

        return questions;
    }
}

