package com.example.learniverse.Model;

import io.realm.RealmObject;

public class Notebook extends RealmObject {
    private String quiz;

    public Notebook() {
    }

    public Notebook(String quiz) {
        this.quiz = quiz;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }
}
