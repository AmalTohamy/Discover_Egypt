package com.egypt.channel.discoveregypt;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeScreen extends AppCompatActivity {
    private static int splashTime = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(WelcomeScreen.this, MainActivity.class);
            startActivity(homeIntent);
            finish();
        }, splashTime);
    }
}
