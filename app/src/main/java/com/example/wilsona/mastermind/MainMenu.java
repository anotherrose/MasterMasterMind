package com.example.wilsona.mastermind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        TextView title = (TextView) findViewById(R.id.txtTitel);
        String text = "MASTER MIND";
        title.setText(text);

    }

    //changes screens
    public void StartEasy(View view) {
        Intent intent = new Intent(this, EasyBoard.class);
        startActivity(intent);
    }
}
