package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    LinearLayout boxSR, boxVC, boxSP, boxET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // transition
        boxSR = (LinearLayout) findViewById(R.id.boxSR);
        boxSR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, StoryTaleActivity.class);
                startActivity(intent);
            }
        });

        boxVC = (LinearLayout) findViewById(R.id.boxVC);
        boxVC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, VocabCardsActivity.class);
                startActivity(intent);
            }
        });

        boxSP = (LinearLayout) findViewById(R.id.boxSP);
        boxSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SentencePuzzleActivity.class);
                startActivity(intent);
            }
        });

        boxET = (LinearLayout) findViewById(R.id.boxET);
        boxET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EvaluationTestActivity.class);
                startActivity(intent);
            }
        });
    }
}