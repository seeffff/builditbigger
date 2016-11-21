package com.example;

import java.util.ArrayList;

public class Jokes {

    private ArrayList<String> jokes = new ArrayList<>();

    public Jokes(){
        jokes.add("Why did the cookie go to the hospital?Because he felt crummy!");
        jokes.add("Why did Johnny throw the clock out of the window?Because he wanted to see time fly!");
        jokes.add("What do lawyers wear to court?Lawsuits!");
        jokes.add("Why wouldn't the shrimp share his treasure?Because he a little shellfish!");
        jokes.add("What do you call a fake noodle?An impasta!");
        jokes.add("How do you make a tissue dance?Put a little boogey in it!");
        jokes.add("Why did the birdie go to the hospital?To get a tweetment!");
        jokes.add("What season is it when you jump on a trampoline?Spring time!");
        jokes.add("What word is always spelled wrong in the dictionary?Wrong!");
        jokes.add("Why couldn't the bicycle stand up by itself?It was two-tired!");
        jokes.add("What do you call a fake noodle?An impasta!");
    }

    public ArrayList<String> getJokes(){
        return jokes;
    }

}
