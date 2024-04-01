package com.example.learniverse.Model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Puzzle extends RealmObject {
    @PrimaryKey
    private long idPuzzle;

    private int gambarPuzzle;
    private RealmList<String> opsiPuzzle;
    private RealmList<String> benarPuzzle;
    private RealmList<String> opsiTerpilihPuzzle;

    public Puzzle() {
    }

    public Puzzle(long idPuzzle, RealmList<String> opsiPuzzle, RealmList<String> benarPuzzle, RealmList<String> opsiTerpilihPuzzle) {
        this.idPuzzle = idPuzzle;
        this.gambarPuzzle = gambarPuzzle;
        this.opsiPuzzle = opsiPuzzle;
        this.benarPuzzle = benarPuzzle;
        this.opsiTerpilihPuzzle = opsiTerpilihPuzzle;
    }

    public RealmList<String> getOpsiPuzzle() {
        return opsiPuzzle;
    }

    public void setOpsiPuzzle(RealmList<String> opsiPuzzle) {
        this.opsiPuzzle = opsiPuzzle;
    }

    public RealmList<String> getBenarPuzzle() {
        return benarPuzzle;
    }

    public void setBenarPuzzle(RealmList<String> benarPuzzle) {
        this.benarPuzzle = benarPuzzle;
    }

    public RealmList<String> getOpsiTerpilihPuzzle() {
        return opsiTerpilihPuzzle;
    }

    public void setOpsiTerpilihPuzzle(RealmList<String> opsiTerpilihPuzzle) {
        this.opsiTerpilihPuzzle = opsiTerpilihPuzzle;
    }
}
