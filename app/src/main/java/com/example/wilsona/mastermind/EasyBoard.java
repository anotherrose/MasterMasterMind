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

    private int[] imgData = {R.drawable.greenpeg, R.drawable.redpeg};

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

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getBaseContext(),R.layout.spinner_row,null,imgData);
        spinnerOne.setAdapter(adapter);

    }


    public void submit(View view) {}



    private void initializeImageList() {
        for (int i = 0; i < imgNameData.length; i++) {
            map = new HashMap<String, Object>();

            map.put("Name", imgNameData[i]);
            map.put("Icon", imgData[i]);
            spinnerOne.add(map);
        }
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource((spinnerOne.get(0).get("Icon")));
        spinnerOne.get(0).get("Name");
    }

    public void createAddDialog() {
        Spinner spin = (Spinner) findViewById(R.id.spnUserPegOne);
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this,
                spinnerData, R.layout.spinner_row, new String[] { "Name",
                "Icon" }, new int[] { R.id.imageNameSpinner,
                R.id.imageIconSpinner });
        spin.setAdapter(adapter);
    }


}

