package com.newwesterndev.jokesandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.Joke;

import java.util.ArrayList;

public class JokeActivity extends AppCompatActivity {

    private ArrayList<Joke> jokeList;
    private TextView jokeQuestion, jokeAnswer;
    private Button showQuestionButton, showAnswerButton, toMainButton;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        jokeQuestion = (TextView) findViewById(R.id.joke_question);
        jokeAnswer = (TextView) findViewById(R.id.joke_answer);
        showQuestionButton = (Button) findViewById(R.id.show_question_button);
        showAnswerButton = (Button) findViewById(R.id.show_answer_question);

        Intent i = getIntent();
        jokeList = (ArrayList<Joke>) i.getSerializableExtra("jokes");

        Joke firstJoke = jokeList.get(0);
        jokeQuestion.setText(firstJoke.getQuestion());
        Log.e("Question", firstJoke.getQuestion());

        showQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuestion();
            }
        });

        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnswer();
            }
        });
    }

    public void showQuestion() {
        i++;
        if (i == 11) {
            i = 0;
        }
        jokeAnswer.setVisibility(View.INVISIBLE);
        Joke joke = jokeList.get(i);
        jokeQuestion.setText(joke.getQuestion());
        Log.e("Question", joke.getQuestion());
        Log.e("i = ", Integer.toString(i));
        showAnswerButton.setVisibility(View.VISIBLE);
    }

    public void showAnswer() {
        Joke joke = jokeList.get(i);
        jokeAnswer.setVisibility(View.VISIBLE);
        jokeAnswer.setText(joke.getAnswer());
        Log.e("Answer", joke.getAnswer());
        showAnswerButton.setVisibility(View.INVISIBLE);
    }
}
