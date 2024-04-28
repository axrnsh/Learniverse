package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class GuessingGameScoreActivity extends AppCompatActivity {
    MaterialCardView home;
    TextView resultScore, correctCounter, wrongCounter;
    ImageView resultImage, buttonReturnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game_score);

        resultScore = findViewById(R.id.score);
        correctCounter = findViewById(R.id.correctCounter);
        wrongCounter = findViewById(R.id.wrongCounter);
        resultImage = findViewById(R.id.resultImage);

        int correct = getIntent().getIntExtra("correct", 0);
        int wrong = getIntent().getIntExtra("wrong", 0);
        int score = correct * 20;

        correctCounter.setText("" + correct);
        wrongCounter.setText("" + wrong);
        resultScore.setText("" + score);

        if (correct >= 0 && correct <= 2) {
            resultImage.setImageResource(R.drawable.owl_sad);
        }else if (correct >= 3 && correct <= 4) {
            resultImage.setImageResource(R.drawable.owl_happy);
            resultImage.setImageResource(R.drawable.owl_amaze);
        }else{
            getRequestedOrientation();
        }

        // transition
        buttonReturnHome = (ImageView) findViewById(R.id.buttonReturnHome);
        buttonReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuessingGameScoreActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(GuessingGameScoreActivity.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Are you sure you want to exit Quiz?");
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(GuessingGameScoreActivity.this, HomeActivity.class));
                finish();
            }
        });
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.show();
    }
}