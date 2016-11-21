package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;

import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.*;

public class emptyArrayListTest extends AndroidTestCase{

    public void test(){

        ArrayList<String> jokeList = new ArrayList<>();
        JokeEndpointsAsync jokeAsync = new JokeEndpointsAsync();
        jokeAsync.execute();
        try {
            jokeList = jokeAsync.get();
            Log.e("Got ", Integer.toString(jokeList.size()) + " jokes");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(jokeList.get(0));
    }

}