package se.davand.models;

import java.util.List;

public class Question {
    private final String questionText;
    private final List<String> options;
    private final String correctOption;

    public Question(String questionText, List<String> options, String correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public boolean isCorrect(String userAnswer) {
        return correctOption.equalsIgnoreCase(userAnswer);
    }
}

