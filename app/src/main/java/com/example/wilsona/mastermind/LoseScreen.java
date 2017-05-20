package com.example.wilsona.mastermind;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoseScreen extends AppCompatActivity {
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable(){
        @Override
        public void run() {
            closeScreen();
            //handler.postDelayed(runnable, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_screen);

        handler.postDelayed(runnable,5000);
    }

    //changes screens
    private void closeScreen() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}
