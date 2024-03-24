package com.example.learniverse.Model;

import io.realm.RealmObject;

public class Puzzle extends RealmObject {
    private int gambarPuzzle;
    private String[] opsiPuzzle;
    private String[] benarPuzzle;
    private String[] opsiTerpilihPuzzle;

    public Puzzle() {
    }

    public Puzzle(int gambarPuzzle, String[] opsiPuzzle, String[] benarPuzzle, String[] opsiTerpilihPuzzle) {
        this.gambarPuzzle = gambarPuzzle;
        this.opsiPuzzle = opsiPuzzle;
        this.benarPuzzle = benarPuzzle;
        this.opsiTerpilihPuzzle = opsiTerpilihPuzzle;
    }

    public int getGambarPuzzle() {
        return gambarPuzzle;
    }

    public void setGambarPuzzle(int gambarPuzzle) {
        this.gambarPuzzle = gambarPuzzle;
    }

    public String[] getOpsiPuzzle() {
        return opsiPuzzle;
    }

    public void setOpsiPuzzle(String[] opsiPuzzle) {
        this.opsiPuzzle = opsiPuzzle;
    }

    public String[] getBenarPuzzle() {
        return benarPuzzle;
    }

    public void setBenarPuzzle(String[] benarPuzzle) {
        this.benarPuzzle = benarPuzzle;
    }

    public String[] getOpsiTerpilihPuzzle() {
        return opsiTerpilihPuzzle;
    }

    public void setOpsiTerpilihPuzzle(String[] opsiTerpilihPuzzle) {
        this.opsiTerpilihPuzzle = opsiTerpilihPuzzle;
    }
}
