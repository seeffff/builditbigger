package com.example;

public class Joke {

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
