package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Story extends RealmObject {
    private long idStory;
    private String category;
    private String namaStory;
    private String descStory;
    private int gambarStory;

    public Story() {
    }

    public Story(long idStory, String category, String namaStory, String descStory, int gambarStory) {
        this.idStory = idStory;
        this.category = category;
        this.namaStory = namaStory;
        this.descStory = descStory;
        this.gambarStory = gambarStory;
    }

    public long getIdStory() {
        return idStory;
    }

    public void setIdStory(long idStory) {
        this.idStory = idStory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
