package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Quiz extends RealmObject {
    @PrimaryKey
    private long idQuiz;
    @Required
    private String soalQuiz;
    private int nilaiQuiz;

    public Quiz() {
    }

    public Quiz(String soalQuiz, int nilaiQuiz) {
        this.soalQuiz = soalQuiz;
        this.nilaiQuiz = nilaiQuiz;
    }

    public long getIdQuiz() {
        return idQuiz;
    }

    public String getSoalQuiz() {
        return soalQuiz;
    }

    public void setSoalQuiz(String soalQuiz) {
        this.soalQuiz = soalQuiz;
    }

    public int getNilaiQuiz() {
        return nilaiQuiz;
    }

    public void setNilaiQuiz(int nilaiQuiz) {
        this.nilaiQuiz = nilaiQuiz;
    }
}
