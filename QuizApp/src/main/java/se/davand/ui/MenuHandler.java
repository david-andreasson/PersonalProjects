package se.davand.ui;

import java.util.Scanner;

public class MenuHandler {

    public void startMenu() {
        boolean menuRunning = true;

        while (menuRunning) {
            showMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> showCourseMenu("OOP Basics");
                case 2 -> showCourseMenu("Databases and Design");
                case 3 -> showCourseMenu("OOP Advanced");
                case 4 -> {
                    System.out.println("Goodbye!");
                    menuRunning = false;
                }
                default -> System.out.println("Invalid choice! This should never happen.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. OOP Basics");
        System.out.println("2. Databases and Design");
        System.out.println("3. OOP Advanced");
        System.out.println("4. Exit");
    }

    private void showCourseMenu(String courseName) {
        boolean inCourseMenu = true;

        while (inCourseMenu) {
            System.out.printf("\n=== COURSE MENU: %s ===%n", courseName);
            System.out.println("1. Ask questions in order");
            System.out.println("2. Ask questions randomly");
            System.out.println("3. Ask questions in reverse order");
            System.out.println("4. Back to main menu");

            int choice = getUserChoice();

            switch (choice) {
                case 1 -> System.out.printf("Asking questions in order for %s...%n", courseName);
                case 2 -> System.out.printf("Asking questions randomly for %s...%n", courseName);
                case 3 -> System.out.printf("Asking questions in reverse order for %s...%n", courseName);
                case 4 -> {
                    System.out.println("Returning to main menu...");
                    inCourseMenu = false;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice < 1 || choice > 4) {
            System.out.print("Enter your choice (1-4): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Consume invalid input
            }
        }

        return choice;
    }
}
