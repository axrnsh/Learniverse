package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Story extends RealmObject {
    private long idStory;
    private String namaKategori;
    private String namaStory;
    private String descStory;
    private int gambarStory;

    public Story() {
    }

    public Story(long idStory, String namaKategori, String namaStory, String descStory, int gambarStory) {
        this.idStory = idStory;
        this.namaKategori = namaKategori;
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

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
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
