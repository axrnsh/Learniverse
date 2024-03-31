package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Quiz extends RealmObject {
    @PrimaryKey
    private long idQuiz;
    @Required
    private int nilaiQuiz;

    private SoalQuiz soalQuiz;

    public Quiz() {
    }

    public Quiz(long idQuiz, int nilaiQuiz, SoalQuiz soalQuiz) {
        this.idQuiz = idQuiz;
        this.nilaiQuiz = nilaiQuiz;
        this.soalQuiz = soalQuiz;
    }

    public long getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(long idQuiz) {
        this.idQuiz = idQuiz;
    }

    public int getNilaiQuiz() {
        return nilaiQuiz;
    }

    public void setNilaiQuiz(int nilaiQuiz) {
        this.nilaiQuiz = nilaiQuiz;
    }

    public SoalQuiz getSoalQuiz() {
        return soalQuiz;
    }

    public void setSoalQuiz(SoalQuiz soalQuiz) {
        this.soalQuiz = soalQuiz;
    }
}
