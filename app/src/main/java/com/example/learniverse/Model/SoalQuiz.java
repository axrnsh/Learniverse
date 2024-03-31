package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class SoalQuiz extends RealmObject {
    @PrimaryKey
    private long idSoalQuiz;
    @Required
    private int poinSoal;
    private Puzzle puzzle;

    public SoalQuiz() {
    }

    public SoalQuiz(long idSoalQuiz, int poinSoal, Puzzle puzzle) {
        this.idSoalQuiz = idSoalQuiz;
        this.poinSoal = poinSoal;
        this.puzzle = puzzle;
    }

    public long getIdSoalQuiz() {
        return idSoalQuiz;
    }

    public void setIdSoalQuiz(long idSoalQuiz) {
        this.idSoalQuiz = idSoalQuiz;
    }

    public int getPoinSoal() {
        return poinSoal;
    }

    public void setPoinSoal(int poinSoal) {
        this.poinSoal = poinSoal;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }
}
