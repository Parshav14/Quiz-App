package com.codecademy.unquote;

public class Question {
    private int imageId;
    private String questionText;
    private String answer0;
    private String answer1;
    private String answer2;
    private String answer3;
    private int correctAnswer;
    private int playerAnswer;

    public Question(int imageIdentifier,
                    String questionString,
                    String answerZero,
                    String answerOne,
                    String answerTwo,
                    String answerThree,
                    int correctAnswerIndex) {
        imageId = imageIdentifier;
        questionText = questionString;
        answer0 = answerZero;
        answer1 = answerOne;
        answer2 = answerTwo;
        answer3 = answerThree;
        correctAnswer = correctAnswerIndex;
        playerAnswer = -1;
    }

    public boolean isCorrect() {
        return correctAnswer == playerAnswer;
    }

    public String getAnswer0() {
        return answer0;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public int getPlayerAnswer() {
        return playerAnswer;
    }

    public void setPlayerAnswer(int answerSelected) {
        playerAnswer = answerSelected;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getImageId() {
        return imageId;
    }
}
