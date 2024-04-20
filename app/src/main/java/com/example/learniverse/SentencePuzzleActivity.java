package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserSentence();
            }
        });

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(10, 0, 0, 0);

        for (TextView optionTextView : optionTextViews) {
            optionTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView clickedTextView = (TextView) v;
                    LinearLayout parentLayout = (LinearLayout) clickedTextView.getParent();
                    if (parentLayout != null) {
                        if (parentLayout.getId() == R.id.line1) {
                            line1.removeView(clickedTextView);
                            LinearLayout allOptionLayout = findViewById(R.id.all_option);
                            allOptionLayout.addView(clickedTextView);
                            String clickedText = clickedTextView.getText().toString();
                            int startIndex = userSentence.lastIndexOf(clickedText);
                            if (startIndex != -1) {
                                userSentence.delete(startIndex, startIndex + clickedText.length());
                            }
                            checkOptionSelection();
                        } else {
                            parentLayout.removeView(clickedTextView);
                            line1.addView(clickedTextView);
                            userSentence.append(clickedTextView.getText()).append(" ");
                            checkOptionSelection();
                        }
                    }
                }
            });
        }

        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserSentence();
            }
        });
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
        submitButton.setClickable(allOptionsSelected);
    }

    private void checkUserSentence() {
        String userSentenceStr = userSentence.toString().trim();
        String correctSentence = "The cat is sleeping";

        if (userSentenceStr.equalsIgnoreCase(correctSentence)) {
            Toast.makeText(SentencePuzzleActivity.this, "Correct sentence!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SentencePuzzleActivity.this, "Incorrect sentence. Nice try!", Toast.LENGTH_SHORT).show();
        }
    }
}