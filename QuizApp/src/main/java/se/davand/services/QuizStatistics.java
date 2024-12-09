package se.davand.services;

public class QuizStatistics {
    public void showStatistics(int correctAnswers, int totalQuestions) {
        double errorRate = ((double) (totalQuestions - correctAnswers) / totalQuestions) * 100;
        System.out.printf("Right answers so far: %d%n", correctAnswers);
        System.out.printf("Error rate: %.2f%%%n", errorRate);
    }
}