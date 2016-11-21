package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.Jokes;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.newwesterndev.jokesandroidlibrary.JokeActivity;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private ArrayList<String> jokeList = new ArrayList<>();
    Jokes jokes = new Jokes();
    InterstitialAd mInterstitialAd;
    AdView adView;
    ProgressBar progressBar;
    boolean isPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isPaid = getResources().getBoolean(R.bool.paid);
        adView = (AdView) findViewById(R.id.adView);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        if (isPaid) {
            adView.setVisibility(View.GONE);
        } else {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
            requestNewInterstitial();
        }

        jokeList = jokes.getJokes();
    }

    public void tellJoke(View view) {
        final Intent i = new Intent(getApplicationContext(), JokeActivity.class);
        progressBar.setVisibility(View.VISIBLE);

        if (!isPaid) {
            new JokeEndpointsAsync() {
                @Override
                protected void onPostExecute(ArrayList<String> jokeList) {
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("jokes", jokeList);

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        progressBar.setVisibility(View.GONE);
                        startActivity(i);
                    }
                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            requestNewInterstitial();
                            progressBar.setVisibility(View.GONE);
                            startActivity(i);
                        }
                    });
                }
            }.execute();
        } else {
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
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
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
