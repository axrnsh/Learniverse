package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learniverse.Model.GuessingQuestions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuessingGameActivity extends AppCompatActivity {
    ImageView backButton;
    TextView questionCounter, question, answer1, answer2, answer3;
    List<GuessingQuestions> guessingQuestionsList;
    int currentQuestions = 0;
    int correct = 0, wrong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);

        // transition
        backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuessingGameActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        questionCounter = findViewById(R.id.questionCounter);
        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        loadAllQuestion();
        setQuestionScreen(currentQuestions);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessingQuestionsList.get(currentQuestions).getAnswer1().equals(guessingQuestionsList.get(currentQuestions).getCorrect())) {
                    correct++;
                    answer1.setBackgroundResource(R.color.green);
                    answer1.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wrong++;
                    answer1.setBackgroundResource(R.color.red);
                    answer1.setTextColor(getResources().getColor(R.color.white));
                }

                if(currentQuestions < guessingQuestionsList.size()-1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            answer1.setBackgroundResource(R.color.white);
                            answer1.setTextColor(getResources().getColor(R.color.logo_dark_green));
                            answer1.setBackgroundResource(R.drawable.rounded_dotted_border);
                        }
                    }, 500);
                }else {
                    Intent intent = new Intent(GuessingGameActivity.this, GuessingGameScoreActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessingQuestionsList.get(currentQuestions).getAnswer2().equals(guessingQuestionsList.get(currentQuestions).getCorrect())) {
                    correct++;
                    answer2.setBackgroundResource(R.color.green);
                    answer2.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wrong++;
                    answer2.setBackgroundResource(R.color.red);
                    answer2.setTextColor(getResources().getColor(R.color.white));
                }

                if(currentQuestions < guessingQuestionsList.size()-1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            answer2.setBackgroundResource(R.color.white);
                            answer2.setTextColor(getResources().getColor(R.color.logo_dark_green));
                            answer2.setBackgroundResource(R.drawable.rounded_dotted_border);
                        }
                    }, 500);
                }else {
                    Intent intent = new Intent(GuessingGameActivity.this, GuessingGameScoreActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessingQuestionsList.get(currentQuestions).getAnswer3().equals(guessingQuestionsList.get(currentQuestions).getCorrect())) {
                    correct++;
                    answer3.setBackgroundResource(R.color.green);
                    answer3.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wrong++;
                    answer3.setBackgroundResource(R.color.red);
                    answer3.setTextColor(getResources().getColor(R.color.white));
                }

                if(currentQuestions < guessingQuestionsList.size()-1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            answer3.setBackgroundResource(R.color.white);
                            answer3.setTextColor(getResources().getColor(R.color.logo_dark_green));
                            answer3.setBackgroundResource(R.drawable.rounded_dotted_border);
                        }
                    }, 500);
                }else {
                    Intent intent = new Intent(GuessingGameActivity.this, GuessingGameScoreActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int currentQuestions) {
        questionCounter.setText(guessingQuestionsList.get(currentQuestions).getQuestionCounter());
        question.setText(guessingQuestionsList.get(currentQuestions).getQuestion());
        answer1.setText(guessingQuestionsList.get(currentQuestions).getAnswer1());
        answer1.setBackgroundResource(R.drawable.rounded_dotted_border);
        answer2.setText(guessingQuestionsList.get(currentQuestions).getAnswer2());
        answer2.setBackgroundResource(R.drawable.rounded_dotted_border);
        answer3.setText(guessingQuestionsList.get(currentQuestions).getAnswer3());
        answer3.setBackgroundResource(R.drawable.rounded_dotted_border);
    }

    private void loadAllQuestion() {
        guessingQuestionsList = new ArrayList<>();
        String jsonquiz = loadJsonFormAsset("guessingquestions.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questions = jsonObject.getJSONArray("guessingquestions");
            for (int i = 0; i < questions.length(); i++) {
                JSONObject question = questions.getJSONObject(i);

                String questionCounterString = question.getString("questionCounter");
                String questionsString = question.getString("question");
                String answer1String = question.getString("answer1");
                String answer2String = question.getString("answer2");
                String answer3String = question.getString("answer3");
                String correctString = question.getString("correct");

                guessingQuestionsList.add(new GuessingQuestions(questionCounterString, questionsString, answer1String, answer2String, answer3String, correctString));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJsonFormAsset(String s) {
        String json = "";
        try {
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF8");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(GuessingGameActivity.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Are you sure you want to exit Quiz?");
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(GuessingGameActivity.this, HomeActivity.class));
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