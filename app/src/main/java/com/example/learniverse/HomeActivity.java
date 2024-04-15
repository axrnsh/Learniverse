package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    Button startStory, startVocab, startAlphabet, startEvaluation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // transition
        startStory = (Button) findViewById(R.id.startStory);
        startStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, StoryTaleActivity.class);
                startActivity(intent);
            }
        });

        startVocab = (Button) findViewById(R.id.startVocab);
        startVocab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, VocabCardsActivity.class);
                startActivity(intent);
            }
        });

        startAlphabet = (Button) findViewById(R.id.startAlphabet);
        startAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SentencePuzzleActivity.class);
                startActivity(intent);
            }
        });

        startEvaluation = (Button) findViewById(R.id.startEvaluation);
        startEvaluation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EvaluationTestActivity.class);
                startActivity(intent);
            }
        });
    }
}