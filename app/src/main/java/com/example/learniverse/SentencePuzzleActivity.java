package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.learniverse.Model.Puzzle;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

public class SentencePuzzleActivity extends AppCompatActivity {
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_puzzle);

        // transition
        backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentencePuzzleActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(config);

        clearAllPuzzle();

        simpanDataPuzzle(new Puzzle(R.drawable.sleeping_cat, createRealmList("cat", "sleeping", "dog", "The", "is"),
                createRealmList("The", "cat", "is", "sleeping", ""), createRealmList("", "", "", "", "", "")));
    }

    private RealmList<String> createRealmList(String... elements) {
        RealmList<String> realmList = new RealmList<>();
        for (String element : elements) {
            realmList.add(element);
        }
        return realmList;
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
