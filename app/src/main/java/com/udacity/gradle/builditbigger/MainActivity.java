package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.Jokes;
import com.newwesterndev.jokesandroidlibrary.JokeActivity;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayList<String> jokeList = new ArrayList<>();
    Jokes jokes = new Jokes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeList = jokes.getJokes();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        new JokeEndpointsAsync(){
            @Override
            protected void onPostExecute(ArrayList<String> jokeList){
                Intent i = new Intent(getApplicationContext(), JokeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("jokes", jokeList);
                Log.e("In", "post execute");
                startActivity(i);
            }
        }.execute();

    }


}
