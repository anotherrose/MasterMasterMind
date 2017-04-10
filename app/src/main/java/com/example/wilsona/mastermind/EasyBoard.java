package com.example.wilsona.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EasyBoard extends AppCompatActivity {

    private Spinner spinnerOne, spinnerTwo, spinnerThree, spinnerFour;
    private Button submit;

    private int[] imgData = {R.drawable.greenpeg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_board);

        spinnerOne = (Spinner) findViewById(R.id.spnUserPegOne);
        spinnerTwo = (Spinner) findViewById(R.id.spnUserPegTwo);
        spinnerThree = (Spinner) findViewById(R.id.spnUserPegThree);
        spinnerFour = (Spinner) findViewById(R.id.spnUserPegFour);

        submit = (Button) findViewById(R.id.btnSubmit);

        CustomAdapter adapter = new CustomAdapter(getBaseContext(),R.layout.spinner_row,null,imgData);
        spinnerOne.setAdapter(adapter);

    }


    public void submit(View view) {}

}

