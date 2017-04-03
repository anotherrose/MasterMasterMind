package com.example.wilsona.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

public class EasyBoard extends AppCompatActivity {

    private Spinner spinnerOne, spinnerTwo, spinnerThree, spinnerFour;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_board);

        spinnerOne = (Spinner) findViewById(R.id.spnUserPegOne);
        spinnerTwo = (Spinner) findViewById(R.id.spnUserPegTwo);
        spinnerThree = (Spinner) findViewById(R.id.spnUserPegThree);
        spinnerFour = (Spinner) findViewById(R.id.spnUserPegFour);

        addItemsToSpinners();
    }

    public void addItemsToSpinners() {

        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTwo.setAdapter(dataAdapter);
    }
}
