package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.newwesterndev.builditbigger.backend.jokesApi.JokesApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JokeEndpointsAsync extends AsyncTask<Void, Void, ArrayList<String>> {
    private static JokesApi jokesApi = null;

    @Override
    protected ArrayList<String> doInBackground(Void... params) {
        if(jokesApi == null) {  // Only do this once
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-150215.appspot.com/_ah/api/");

            jokesApi = builder.build();
        }

        try {
            ArrayList<String> jokeList = toArrayList(jokesApi.getJokeList().execute().getData());
            return jokeList;
        } catch (IOException e) {
            Log.e("Error", "error");
            return null;
        }
    }

public ArrayList<String> toArrayList(List<String> jokeList){
        ArrayList<String> jokeArray = new ArrayList<>();

        for(int i = 0; i < jokeList.size(); i++){
            String currentJoke = jokeList.get(i);
            jokeArray.add(currentJoke);
        }

        return jokeArray;
    }
}
