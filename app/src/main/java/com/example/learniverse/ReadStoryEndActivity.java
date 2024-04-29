package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ReadStoryEndActivity extends AppCompatActivity {
    ImageView backButton, buttonClose;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story_end);

        backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadStoryEndActivity.this, StoryTaleActivity.class);
                startActivity(intent);
            }
        });

        buttonClose = (ImageView) findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadStoryEndActivity.this, StoryTaleActivity.class);
                startActivity(intent);
            }
        });
    }
}