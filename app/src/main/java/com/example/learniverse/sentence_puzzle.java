package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.learniverse.Model.Puzzle;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class sentence_puzzle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_puzzle);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(config);

        clearAllPuzzle();

        simpanDataPuzzle(new Puzzle(R.drawable.sleeping_cat, new String[]{"cat", "sleeping", "dog", "The", "is"},
                new String[]{"The", "cat", "is", "sleeping", ""}, new String[]{"", "", "", "", "", ""}));
    }

    private void simpanDataPuzzle(Puzzle puzzle) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realmInstance -> realmInstance.copyToRealmOrUpdate(puzzle));
        realm.close();
    }

    private void clearAllPuzzle() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(Puzzle.class);
        realm.commitTransaction();
        realm.close();
    }
}
