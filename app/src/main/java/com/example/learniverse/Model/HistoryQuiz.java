package com.example.learniverse.Model;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class HistoryQuiz extends RealmObject {
    @PrimaryKey
    private long idHistoryQuiz;
    private RealmList<Quiz> selesaiQuiz;

    public HistoryQuiz() {
    }

    public HistoryQuiz(long idHistoryQuiz, RealmList<Quiz> selesaiQuiz) {
        this.idHistoryQuiz = idHistoryQuiz;
        this.selesaiQuiz = selesaiQuiz;
    }

    public long getIdHistoryQuiz() {
        return idHistoryQuiz;
    }

    public void setIdHistoryQuiz(long idHistoryQuiz) {
        this.idHistoryQuiz = idHistoryQuiz;
    }

    public RealmList<Quiz> getSelesaiQuiz() {
        return selesaiQuiz;
    }

    public void setSelesaiQuiz(RealmList<Quiz> selesaiQuiz) {
        this.selesaiQuiz = selesaiQuiz;
    }
}
