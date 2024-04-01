package com.example.learniverse.Model;

import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class HistoryQuiz extends RealmObject {
    @PrimaryKey
    private long idHistoryQuiz;
    @Required
    private ArrayList<Quiz> selesaiQuiz;

    public HistoryQuiz() {
    }

    public HistoryQuiz(long idHistoryQuiz, ArrayList<Quiz> selesaiQuiz) {
        this.idHistoryQuiz = idHistoryQuiz;
        this.selesaiQuiz = selesaiQuiz;
    }

    public long getIdHistoryQuiz() {
        return idHistoryQuiz;
    }

    public void setIdHistoryQuiz(long idHistoryQuiz) {
        this.idHistoryQuiz = idHistoryQuiz;
    }

    public ArrayList<Quiz> getSelesaiQuiz() {
        return selesaiQuiz;
    }

    public void setSelesaiQuiz(ArrayList<Quiz> selesaiQuiz) {
        this.selesaiQuiz = selesaiQuiz;
    }
}
