package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Story extends RealmObject {
    @PrimaryKey
    private long idStory;
    @Required
    private String namaStory;
    private String descStory;
    private int gambarStory;

    public Story() {
    }

    public Story(String namaStory, String descStory, int gambarStory) {
        this.namaStory = namaStory;
        this.descStory = descStory;
        this.gambarStory = gambarStory;
    }

    public long getIdStory() {
        return idStory;
    }

    public String getNamaStory() {
        return namaStory;
    }

    public void setNamaStory(String namaStory) {
        this.namaStory = namaStory;
    }

    public String getDescStory() {
        return descStory;
    }

    public void setDescStory(String descStory) {
        this.descStory = descStory;
    }

    public int getGambarStory() {
        return gambarStory;
    }

    public void setGambarStory(int gambarStory) {
        this.gambarStory = gambarStory;
    }
}
