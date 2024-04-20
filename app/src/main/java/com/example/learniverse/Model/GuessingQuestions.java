package com.example.learniverse.Model;

public class GuessingQuestions {
    private String questionCounter, question, answer1, answer2, answer3, correct;

    public GuessingQuestions(String questionCounter, String question, String answer1, String answer2, String answer3, String correct) {
        this.questionCounter = questionCounter;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correct = correct;
    }

    public String getQuestionCounter() {
        return questionCounter;
    }

    public void setQuestionCounter(String questionCounter) {
        this.questionCounter = questionCounter;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
