package com.housseinzouari.weather.android.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.housseinzouari.weather.android.R;


public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // to display the splash screen just for 5 sc
        new Handler().postDelayed(new Runnable() {
            public void run() {
                // then move to the next Activity
               startNextActivity();
            }
        },  5000);
    }

    private void startNextActivity(){

        startActivity(new Intent(MainActivity.this, MenuActivity.class));
        finish();
        }


}