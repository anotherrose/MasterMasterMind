package com.example.wilsona.mastermind;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashScreen extends AppCompatActivity {
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable(){
        @Override
        public void run() {
            closeSplash();
            //handler.postDelayed(runnable, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView myText = (TextView) findViewById(R.id.txtSplashText);
        String text = "WELCOME TO MASTER MIND NEWB";
        myText.setText(text);

        handler.postDelayed(runnable,5000);
    }

    private void closeSplash() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}
