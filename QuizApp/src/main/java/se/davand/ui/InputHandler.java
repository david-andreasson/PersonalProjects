package se.davand.ui;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            System.out.printf("Enter your choice (%d-%d): ", min, max);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
        return choice;
    }
}
