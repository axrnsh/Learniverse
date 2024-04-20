package com.example.learniverse.Model;

public class GuessingQuestions {
    private long idGuessingQuestions;
    private String questions, answer1, answer2, answer3, correct;

    public GuessingQuestions(long idGuessingQuestions, String questions, String answer1, String answer2, String answer3, String correct) {
        this.idGuessingQuestions = idGuessingQuestions;
        this.questions = questions;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correct = correct;
    }

    public long getIdGuessingQuestions() {
        return idGuessingQuestions;
    }

    public void setIdGuessingQuestions(long idGuessingQuestions) {
        this.idGuessingQuestions = idGuessingQuestions;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
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
