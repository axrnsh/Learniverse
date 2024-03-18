package com.example.learniverse.Model;

import io.realm.RealmObject;

public class Card extends RealmObject {
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
