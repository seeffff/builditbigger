package com.example;

import java.util.ArrayList;

public class Jokes {

    private ArrayList<Joke> jokes = new ArrayList<Joke>();

    public Jokes(){
        jokes.add(new Joke("Why did the cookie go to the hospital?", "Because he felt crummy!"));
        jokes.add(new Joke("Why did Johnny throw the clock out of the window?", "Because he wanted to see time fly!"));
        jokes.add(new Joke("What do lawyers wear to court?", "Lawsuits!"));
        jokes.add(new Joke("Why wouldn't the shrimp share his treasure?", "Because he a little shellfish!"));
        jokes.add(new Joke("What do you call a fake noodle?", "An impasta!"));
        jokes.add(new Joke("How do you make a tissue dance?", "Put a little boogey in it!"));
        jokes.add(new Joke("Why did the birdie go to the hospital?", "To get a tweetment!"));
        jokes.add(new Joke("What season is it when you jump on a trampoline?", "Spring time!"));
        jokes.add(new Joke("What word is always spelled wrong in the dictionary?", "Wrong!"));
        jokes.add(new Joke("Why couldn't the bicycle stand up by itself?", "It was two-tired!"));
        jokes.add(new Joke("What do you call a fake noodle?", "An impasta!"));
    }

    public ArrayList<Joke> getJokes(){
        return jokes;
    }

}
