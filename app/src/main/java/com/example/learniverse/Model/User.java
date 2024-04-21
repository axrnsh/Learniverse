package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {
    private long idUser;
    private String username;
    private String password;
    private Story idStory;
    private Card idCard;
    private HistoryQuiz historyQuiz;

    public User() {
    }

    public User(long idUser, String username, String password, Story idStory, Card idCard, HistoryQuiz historyQuiz) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.idStory = idStory;
        this.idCard = idCard;
        this.historyQuiz = historyQuiz;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Story getIdStory() {
        return idStory;
    }

    public void setIdStory(Story idStory) {
        this.idStory = idStory;
    }

    public Card getIdCard() {
        return idCard;
    }

    public void setIdCard(Card idCard) {
        this.idCard = idCard;
    }

    public HistoryQuiz getHistoryQuiz() {
        return historyQuiz;
    }

    public void setHistoryQuiz(HistoryQuiz historyQuiz) {
        this.historyQuiz = historyQuiz;
    }
}


