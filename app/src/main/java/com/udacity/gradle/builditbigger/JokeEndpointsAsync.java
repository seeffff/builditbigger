package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.newwesterndev.builditbigger.backend.jokesApi.JokesApi;
import com.newwesterndev.jokesandroidlibrary.JokeActivity;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JokeEndpointsAsync extends AsyncTask<Context, Void, ArrayList<String>> {
    private static JokesApi jokesApi = null;
    private Context context;

    @Override
    protected ArrayList<String> doInBackground(Context... params) {
        if(jokesApi == null) {  // Only do this once
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-150215.appspot.com/_ah/api/");

            jokesApi = builder.build();
        }

        context = params[0];

        try {
            ArrayList<String> jokeList = toArrayList(jokesApi.getJokeList().execute().getData());
            return jokeList;
        } catch (IOException e) {
            Log.e("Error", "error");
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<String> jokeList){
        Intent i = new Intent(context, JokeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("jokes", jokeList);
        Log.e("In", "post execute");
        context.startActivity(i);
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
