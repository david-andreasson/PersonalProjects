package se.davand.ui;

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

}
