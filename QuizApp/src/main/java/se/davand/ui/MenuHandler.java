package se.davand.ui;

import se.davand.models.User;
import se.davand.services.QuizService;

public class MenuHandler {
    private final QuizService quizService = new QuizService();
    private final InputHandler inputHandler = new InputHandler();
    private final User user;

    public MenuHandler(User user) {
        this.user = user;
    }

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
                case 0 -> menuRunning = false;
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. OOP Basics (No questions available in this version)");
        System.out.println("2. Databases and Design (No questions available in this version)");
        System.out.println("3. OOP Advanced (" + quizService.getQuestionCount("OOP Advanced") + " questions available)");
        System.out.println("4. Test (" + quizService.getQuestionCount("Test") + " questions available)");
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
                case 1 -> quizService.runQuiz(user, courseName, "ORDER");
                case 2 -> quizService.runQuiz(user, courseName, "RANDOM");
                case 3 -> quizService.runQuiz(user, courseName, "REVERSE");
                case 0 -> inCourseMenu = false;
            }
        }
    }

}
