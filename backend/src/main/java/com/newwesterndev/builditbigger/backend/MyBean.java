package com.newwesterndev.builditbigger.backend;

import com.example.Jokes;

import java.util.ArrayList;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private Jokes jokes;

    public ArrayList<String> getData() {
        jokes = new Jokes();
        return jokes.getJokes();
    }
}