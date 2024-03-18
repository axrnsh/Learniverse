package com.example.learniverse.Model;

import io.realm.RealmObject;

public class SoalQuiz extends RealmObject {
    private int poinSoal;
    private int nilaiQuiz;

    public SoalQuiz() {
    }

    public SoalQuiz(int poinSoal, int nilaiQuiz) {
        this.poinSoal = poinSoal;
        this.nilaiQuiz = nilaiQuiz;
    }

    public int getPoinSoal() {
        return poinSoal;
    }

    public void setPoinSoal(int poinSoal) {
        this.poinSoal = poinSoal;
    }

    public int getNilaiQuiz() {
        return nilaiQuiz;
    }

    public void setNilaiQuiz(int nilaiQuiz) {
        this.nilaiQuiz = nilaiQuiz;
    }
}
