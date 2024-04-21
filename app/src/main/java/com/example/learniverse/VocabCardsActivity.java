package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class VocabCardsActivity extends AppCompatActivity {
    ImageView backButton;
    ImageView soundButton;
    TextToSpeech textToSpeech;

    private int currentCardIndex = 0;
    private int[] cardImages = {R.drawable.card_apple, R.drawable.card_apple, R.drawable.card_apple, R.drawable.card_apple, R.drawable.card_apple};
    private String[] cardNames = {"APPLE", "TOOTHBRUSH", "SOCKS", "SKY", "PEN"};
    private String[] cardDescriptions = {"A fruit with red bright color", "The tool to brush our teeth", "Something we wear on our feet", "The color of the sky", "The tool we use to write on paper"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_cards);

        // transition
        backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabCardsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        soundButton = findViewById(R.id.sound);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                } else {
                    Toast.makeText(VocabCardsActivity.this, "Text-to-speech initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView namaCardTextView = findViewById(R.id.namaCard);
                String word = namaCardTextView.getText().toString();

                textToSpeech.speak(word, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        TextView txtTap = findViewById(R.id.txtTap);
        txtTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCardIndex++;

                if (currentCardIndex >= cardImages.length) {
                    currentCardIndex = 0;
                }

                ImageView gambarCardImageView = findViewById(R.id.gambarCard);
                TextView namaCardTextView = findViewById(R.id.namaCard);
                TextView descCardTextView = findViewById(R.id.descCard);

                gambarCardImageView.setImageResource(cardImages[currentCardIndex]);
                namaCardTextView.setText(cardNames[currentCardIndex]);
                descCardTextView.setText(cardDescriptions[currentCardIndex]);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
