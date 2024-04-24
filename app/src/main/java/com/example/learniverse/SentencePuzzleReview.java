package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SentencePuzzleReview extends AppCompatActivity {
    ImageView buttonReturnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_puzzle_review);

        // Transition
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentencePuzzleReview.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        // transition
        buttonReturnHome = (ImageView) findViewById(R.id.buttonReturnHome);
        buttonReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentencePuzzleReview.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}