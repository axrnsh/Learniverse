package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {
    private long idUser;
    private String username;
    private String password;
    private Story idStory;

    public User() {
    }

    public User(long idUser, String username, String password, Story idStory) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.idStory = idStory;
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
}


