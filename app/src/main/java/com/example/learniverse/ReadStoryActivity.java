package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ReadStoryActivity extends AppCompatActivity {
    ImageView backButton, buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);

        // transition
        backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadStoryActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        buttonNext = (ImageView) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadStoryActivity.this, ReadStoryEndActivity.class);
                startActivity(intent);
            }
        });
    }
}