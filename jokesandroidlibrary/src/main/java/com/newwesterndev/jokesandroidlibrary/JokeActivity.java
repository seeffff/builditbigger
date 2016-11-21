package com.newwesterndev.jokesandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class JokeActivity extends AppCompatActivity {

    private ArrayList<String> jokeList;
    private TextView jokeQuestion, jokeAnswer;
    private Button showQuestionButton, showAnswerButton;
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
        jokeList = (ArrayList<String>) i.getSerializableExtra("jokes");

        String firstJoke = jokeList.get(0);
        jokeQuestion.setText(getQuestion(firstJoke));

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
        String joke = jokeList.get(i);
        jokeQuestion.setText(getQuestion(joke));
        showAnswerButton.setVisibility(View.VISIBLE);
    }

    public void showAnswer() {
        String joke = jokeList.get(i);
        jokeAnswer.setVisibility(View.VISIBLE);
        jokeAnswer.setText(getAnswer(joke));
        showAnswerButton.setVisibility(View.INVISIBLE);
    }

    public String getQuestion(String joke){
        String question = "";
        int stop = 0;

        for(int k = 0; k < joke.length(); k++){
            if(joke.charAt(k) == '?'){
                stop = k + 1;
            }
        }

        for(int k = 0; k < stop; k++){
            question = question + joke.charAt(k);
        }
        return question;
    }

    public String getAnswer(String joke){
        String answer = "";
        int start = 0;

        for(int k = 0; k < joke.length(); k++){
            if(joke.charAt(k) == '?'){
                start = k + 1;
            }
        }

        for(int k = start; k < joke.length(); k++){
            answer = answer + joke.charAt(k);
        }

        Log.e("JokeAnswer", answer);
        return answer;
    }
}
