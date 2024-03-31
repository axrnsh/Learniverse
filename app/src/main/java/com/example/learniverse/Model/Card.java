package com.example.learniverse.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Card extends RealmObject {
    @PrimaryKey
    private long idCard;
    @Required
    private String namaCard;
    private int gambarCard;
    private String suaraCard;

    public Card() {
    }

    public Card(String namaCard, int gambarCard, String suaraCard) {
        this.namaCard = namaCard;
        this.gambarCard = gambarCard;
        this.suaraCard = suaraCard;
    }

    public long getIdCard() {
        return idCard;
    }


    public String getNamaCard() {
        return namaCard;
    }

    public void setNamaCard(String namaCard) {
        this.namaCard = namaCard;
    }

    public int getGambarCard() {
        return gambarCard;
    }

    public void setGambarCard(int gambarCard) {
        this.gambarCard = gambarCard;
    }

    public String getSuaraCard() {
        return suaraCard;
    }

    public void setSuaraCard(String suaraCard) {
        this.suaraCard = suaraCard;
    }
}
