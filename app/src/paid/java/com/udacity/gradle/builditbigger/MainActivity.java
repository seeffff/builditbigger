package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.Jokes;
import com.newwesterndev.jokesandroidlibrary.JokeActivity;
import com.udacity.gradle.builditbigger.JokeEndpointsAsync;
import com.udacity.gradle.builditbigger.R;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private ArrayList<String> jokeList = new ArrayList<>();
    Jokes jokes = new Jokes();
    ProgressBar progressBar;
    boolean isPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isPaid = getResources().getBoolean(R.bool.paid);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        jokeList = jokes.getJokes();
    }

    public void tellJoke(View view) {
        final Intent i = new Intent(getApplicationContext(), JokeActivity.class);
        progressBar.setVisibility(View.VISIBLE);

        new JokeEndpointsAsync() {
            @Override
            protected void onPostExecute(ArrayList<String> jokeList) {
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("jokes", jokeList);
                progressBar.setVisibility(View.GONE);
                startActivity(i);
            }
        }.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
