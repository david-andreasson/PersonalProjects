package se.davand.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    private static final String URL = "jdbc:h2:./bokomatdb";
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void main(String[] args) {
        // Test connection to database
        try (Connection connection = DatabaseConfig.getConnection()) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

// New method to initialize the database
    public static void initializeDatabase() {
        // Adjust the path to your SQL file in the resources directory
        String sqlFilePath = "src/main/resources/sql/create_tables.sql";

        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement()) {

            // Read the SQL file content
            String sql = Files.readString(Path.of(sqlFilePath));

            // Split SQL statements by semicolon and execute each one
            for (String statement : sql.split(";")) {
                if (!statement.trim().isEmpty()) {  // Ignore empty statements
                    stmt.execute(statement.trim());
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

