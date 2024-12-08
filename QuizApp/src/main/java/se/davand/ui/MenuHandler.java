package se.davand.ui;

import se.davand.services.QuizService;

public class MenuHandler {

    private final QuizService quizService = new QuizService();
    private final InputHandler inputHandler = new InputHandler();

    public void startMenu() {
        boolean menuRunning = true;

        while (menuRunning) {
            showMainMenu();
            int choice = inputHandler.getUserChoice(0, 4);

            switch (choice) {
                case 1 -> showCourseMenu("OOP Basics");
                case 2 -> showCourseMenu("Databases and Design");
                case 3 -> showCourseMenu("OOP Advanced");
                case 4 -> showCourseMenu("Test");
                case 0 -> {
                    System.out.println("Goodbye!");
                    menuRunning = false;
                }
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. OOP Basics (No questions available in this version)");
        System.out.println("2. Databases and Design (No questions available in this version)");
        System.out.println("3. OOP Advanced (165 available questions)");
        System.out.println("4. Test (30 available questions)");
        System.out.println("0. Exit");
    }

    private void showCourseMenu(String courseName) {
        boolean inCourseMenu = true;

        while (inCourseMenu) {
            System.out.printf("\n=== COURSE MENU: %s ===%n", courseName);
            System.out.println("1. Ask questions in order");
            System.out.println("2. Ask questions randomly");
            System.out.println("3. Ask questions in reverse order");
            System.out.println("0. Back to main menu");

            int choice = inputHandler.getUserChoice(0, 3);

            switch (choice) {
                case 1 -> quizService.runQuiz(courseName, "ORDER");
                case 2 -> quizService.runQuiz(courseName, "RANDOM");
                case 3 -> quizService.runQuiz(courseName, "REVERSE");
                case 0 -> {
                    System.out.println("Returning to main menu...");
                    inCourseMenu = false;
                }
            }
        }
    }
}
