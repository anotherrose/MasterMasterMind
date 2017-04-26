package com.example.wilsona.mastermind;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class EasyBoard extends AppCompatActivity {

    private int clrOne, clrTwo, clrThree, clrFour;
    private Button submit;
    private Button btnPegOne, btnPegTwo, btnPegThree, btnPegFour;


    private String[] imgNameData = { "green", "red"};

    private HashMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_board);

        submit = (Button) findViewById(R.id.btnSubmit);
        submit.setEnabled(false);

        btnPegOne = (Button) findViewById(R.id.btnPegOne);
        clrOne = 0;
        btnPegTwo = (Button) findViewById(R.id.btnPegTwo);
        clrTwo = 0;
        btnPegThree = (Button) findViewById(R.id.btnPegThree);
        clrThree = 0;
        btnPegFour = (Button) findViewById(R.id.btnPegFour);
        clrFour = 0;

    }


    public void submit(View view) {
        peg pegOne = new peg(1,clrOne);
        peg pegTwo = new peg(2,clrTwo);
        peg pegThree= new peg(1,clrThree);
        peg pegFour = new peg(1,clrFour);
    }


    public void buttonOneChange(View view) {
        if(clrOne+1>4)
            clrOne=1;
        else
            clrOne++;
        changeColor(btnPegOne,clrOne);
    }

    public void buttonTwoChange(View view) {
        if(clrTwo+1>4)
            clrTwo=1;
        else
            clrTwo++;
        changeColor(btnPegTwo,clrTwo);
    }

    public void buttonThreeChange(View view) {
        if(clrThree+1>4)
            clrThree=1;
        else
            clrThree++;
        changeColor(btnPegThree,clrThree);
    }

    public void buttonFourChange(View view) {
        if(clrFour+1>4)
            clrFour=1;
        else
            clrFour++;
        changeColor(btnPegFour,clrFour);
    }

    private void changeColor(Button peg, int clrOne) {
        switch (clrOne){
            case 1: peg.setBackgroundColor(Color.RED);
                break;
            case 2: peg.setBackgroundColor(Color.YELLOW);
                break;
            case 3: peg.setBackgroundColor(Color.BLUE);
                break;
            case 4: peg.setBackgroundColor(Color.GREEN);
                break;
            default: return;

        }

        if (clrOne>0&&clrTwo>0&&clrThree>0&&clrFour>0){
            submit.setEnabled(true);
        }
    }
}

