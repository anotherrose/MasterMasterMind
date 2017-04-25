package com.example.wilsona.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.HashMap;

public class EasyBoard extends AppCompatActivity {

    private Spinner spinnerOne, spinnerTwo, spinnerThree, spinnerFour;
    private Button submit;
    private Button pegOne, pegTwo, pegThree, pegFour;


    private String[] imgNameData = { "green", "red"};

    private HashMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_board);

        //spinnerOne = (Spinner) findViewById(R.id.spnUserPegOne);
        spinnerTwo = (Spinner) findViewById(R.id.spnUserPegTwo);
        spinnerThree = (Spinner) findViewById(R.id.spnUserPegThree);
        spinnerFour = (Spinner) findViewById(R.id.spnUserPegFour);

        submit = (Button) findViewById(R.id.btnSubmit);

        pegOne = (Button) findViewById(R.id.btnPegOne);
        pegTwo = (Button) findViewById(R.id.btnPegTwo);
        pegThree = (Button) findViewById(R.id.btnPegThree);
        pegFour = (Button) findViewById(R.id.btnPegFour);

    }


    public void submit(View view) {}




}

