package com.example.wilsona.mastermind;

import android.graphics.Color;
import android.graphics.Interpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class EasyBoard extends AppCompatActivity {

    private int clrOne, clrTwo, clrThree, clrFour;
    private Button submit;
    private Button btnPegOne, btnPegTwo, btnPegThree, btnPegFour;
    private peg[] masterCode;
    private String[] allColors;
    private int numColors = 6;
    private int guess = 0;
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

        allColors = new String[]{"red", "yellow", "blue", "green", "pink", "magenta"};

        createMasterCode();
    }

    private void createMasterCode() {
        ArrayList<String> unusedColors= new ArrayList<String>();
        masterCode = new peg[3];
        String color;
        int pos=0;

        for(int i=1; i<=allColors.length; i++){
            unusedColors.add(allColors[i-1]);
        }

        do while(masterCode[masterCode.length-1]==null){
            color=allColors[(int) ((Math.random()*6)+1)];
            if (unusedColors.contains(color)){
                masterCode[pos]= new peg(pos,color);
                pos++;
            }

        }

    }


    public void submit(View view) {
        peg pegOne = new peg(1,clrOne);
        peg pegTwo = new peg(2,clrTwo);
        peg pegThree= new peg(3,clrThree);
        peg pegFour = new peg(4,clrFour);

        clrOne=0;
        clrTwo=0;
        clrThree=0;
        clrFour=0;

        submit.setEnabled(false);

    }


    public void buttonOneChange(View view) {
        if(clrOne>=6)
            clrOne=1;
        else
            clrOne++;
        changeColor(btnPegOne,clrOne);
    }

    public void buttonTwoChange(View view) {
        if(clrTwo>=6)
            clrTwo=1;
        else
            clrTwo++;
        changeColor(btnPegTwo,clrTwo);
    }

    public void buttonThreeChange(View view) {
        if(clrThree>=6)
            clrThree=1;
        else
            clrThree++;
        changeColor(btnPegThree,clrThree);
    }

    public void buttonFourChange(View view) {
        if(clrFour>=6)
            clrFour=1;
        else
            clrFour++;
        changeColor(btnPegFour,clrFour);
    }

    private void changeColor(Button peg, int clr) {
        switch (clr){
            case 0: peg.setBackgroundColor(Color.GRAY);
                break;
            case 1: peg.setBackgroundColor(Color.RED);
                break;
            case 2: peg.setBackgroundColor(Color.YELLOW);
                break;
            case 3: peg.setBackgroundColor(Color.BLUE);
                break;
            case 4: peg.setBackgroundColor(Color.GREEN);
                break;
            case 5: peg.setBackgroundColor(Color.rgb(255,105,180));
                break;
            case 6: peg.setBackgroundColor(Color.MAGENTA);
                break;
            default: return;
        }

        if (clrOne>0&&clrTwo>0&&clrThree>0&&clrFour>0){
            submit.setEnabled(true);
        }
    }
}

