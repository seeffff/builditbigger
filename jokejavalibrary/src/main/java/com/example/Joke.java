package com.example;

import java.io.Serializable;

public class Joke implements Serializable{

    private String mQuestion;
    private String mAnswer;

    public Joke(String question, String answer){
        mQuestion = question;
        mAnswer = answer;
    }

    public String getQuestion(){
        return mQuestion;
    }

    public String getAnswer(){
        return mAnswer;
    }

}
