package com.example.learniverse.Model;

public class Story {
    private String namaStory;
    private String descStory;
    private int gambarStory;

    public Story(String namaStory, String descStory, int gambarStory) {
        this.namaStory = namaStory;
        this.descStory = descStory;
        this.gambarStory = gambarStory;
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
