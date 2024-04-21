package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SentencePuzzleActivity extends AppCompatActivity {
    private LinearLayout line1;
    private TextView[] optionTextViews;
    private StringBuilder userSentence;
    private Button submitButton;
    private int questionIndex = 0;

    private int[] imageResources = {
            R.drawable.sleeping_cat,
            R.drawable.piano_kid,
            R.drawable.giraffe
    };
    private String[][] options = {
            {"sleeping", "The", "cat", "is"},
            {"piano", "is", "playing", "He"},
            {"is", "It", "giraffe", "a"}
    };
    private String[] correctSentences = {
            "The cat is sleeping",
            "He is playing piano",
            "It is a giraffe"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_puzzle);

        // Transition
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentencePuzzleActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        line1 = findViewById(R.id.line1);
        optionTextViews = new TextView[]{
                findViewById(R.id.text1),
                findViewById(R.id.text2),
                findViewById(R.id.text3),
                findViewById(R.id.text4)
        };
        userSentence = new StringBuilder();
        submitButton = findViewById(R.id.submit_button);

        setQuestion(questionIndex);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserSentence();
            }
        });

        for (final TextView optionTextView : optionTextViews) {
            optionTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveOption(optionTextView);
                }
            });
        }
    }

    private void setQuestion(int index) {
        ImageView gambarCard = findViewById(R.id.gambarCard);
        gambarCard.setImageResource(imageResources[index]);

        LinearLayout allOptionLayout = findViewById(R.id.all_option);
        allOptionLayout.removeAllViews();

        for (int i = 0; i < optionTextViews.length; i++) {
            TextView optionTextView = optionTextViews[i];
            ViewGroup parent = (ViewGroup) optionTextView.getParent();
            if (parent != null) {
                parent.removeView(optionTextView);
            }
            optionTextView.setText(options[index][i]);
            allOptionLayout.addView(optionTextView);
        }

        line1.removeAllViews();
        userSentence.setLength(0);

        submitButton.setEnabled(false);
    }

    private void moveOption(TextView optionTextView) {
        LinearLayout parentLayout = (LinearLayout) optionTextView.getParent();
        if (parentLayout != null) {
            if (parentLayout.getId() == R.id.line1) {
                parentLayout.removeView(optionTextView);
                LinearLayout allOptionLayout = findViewById(R.id.all_option);
                allOptionLayout.addView(optionTextView);
                String clickedText = optionTextView.getText().toString();
                int startIndex = userSentence.lastIndexOf(clickedText);
                if (startIndex != -1) {
                    userSentence.delete(startIndex, startIndex + clickedText.length());
                }
            } else {
                parentLayout.removeView(optionTextView);
                line1.addView(optionTextView);
                userSentence.append(optionTextView.getText()).append(" ");
            }
        }
        checkOptionSelection();
    }

    private void checkOptionSelection() {
        boolean allOptionsSelected = true;
        for (TextView optionTextView : optionTextViews) {
            if (line1.indexOfChild(optionTextView) == -1) {
                allOptionsSelected = false;
                break;
            }
        }
        submitButton.setEnabled(allOptionsSelected);
    }

    private void checkUserSentence() {
        String userSentenceStr = userSentence.toString().trim();
        String correctSentence = correctSentences[questionIndex];

        if (userSentenceStr.equalsIgnoreCase(correctSentence)) {
            Toast.makeText(SentencePuzzleActivity.this, "Correct sentence!", Toast.LENGTH_SHORT).show();
            if (questionIndex < options.length - 1) {
                questionIndex++;
                setQuestion(questionIndex);
            } else {
                Intent intent = new Intent(SentencePuzzleActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        } else {
            Toast.makeText(SentencePuzzleActivity.this, "Incorrect sentence. Try again!", Toast.LENGTH_SHORT).show();
            LinearLayout allOptionLayout = findViewById(R.id.all_option);
            for (TextView optionTextView : optionTextViews) {
                ViewGroup parent = (ViewGroup) optionTextView.getParent();
                if (parent != null) {
                    parent.removeView(optionTextView);
                }
                allOptionLayout.addView(optionTextView);
            }
            line1.removeAllViews();
            userSentence.setLength(0);
            submitButton.setEnabled(false);
        }
    }}