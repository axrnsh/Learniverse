package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {
    @PrimaryKey
    private long idUser;
    @Required
    private String namaUser;
    private String password;

    public User() {
    }

    public User(String namaUser, String password) {
        this.namaUser = namaUser;
        this.password = password;
    }

    public long getIdUser() {
        return idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


