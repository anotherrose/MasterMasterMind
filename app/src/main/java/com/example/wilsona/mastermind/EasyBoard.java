package com.example.wilsona.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class EasyBoard extends AppCompatActivity {

    private int clrOne, clrTwo, clrThree, clrFour;
    private Button submit;
    private ImageButton btnPegOne, btnPegTwo, btnPegThree, btnPegFour;
    private ImageButton[] gameButtons;
    private peg[] userPegs;
    private peg[] masterCode;
    private int guess = 0;
    //private int imgEmpty, imgBlue, imgGreen, imgRed, imgOrange, imgYellow, imgMagenta;
    private int[] imgColors;
    private Guess[] masterRowHolder = new Guess[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_board);

        submit = (Button) findViewById(R.id.btnSubmit);
        submit.setEnabled(false);

        btnPegOne = (ImageButton) findViewById(R.id.btnPegOne);
        clrOne = 0;
        btnPegTwo = (ImageButton) findViewById(R.id.btnPegTwo);
        clrTwo = 0;
        btnPegThree = (ImageButton) findViewById(R.id.btnPegThree);
        clrThree = 0;
        btnPegFour = (ImageButton) findViewById(R.id.btnPegFour);
        clrFour = 0;

        gameButtons = new ImageButton[]{btnPegOne, btnPegTwo,btnPegThree,btnPegFour};

        imgColors = new int[]{R.drawable.peg_red, R.drawable.peg_yellow, R.drawable.peg_blue, R.drawable.peg_green, R.drawable.peg_orange, R.drawable.peg_magenta};


        createMasterCode();
        createImages();
    }



    private void createImages() {
        masterRowHolder[0] = new Guess((ImageView) findViewById(R.id.imgRowOneAnswerPegOne),(ImageView) findViewById(R.id.imgRowOneAnswerPegTwo), (ImageView) findViewById(R.id.imgRowOneAnswerPegThree), (ImageView) findViewById(R.id.imgRowOneAnswerPegFour),
                (ImageView) findViewById(R.id.imgRowOnePegOne), (ImageView) findViewById(R.id.imgRowOnePegTwo), (ImageView) findViewById(R.id.imgRowOnePegThree), (ImageView) findViewById(R.id.imgRowOnePegFour));

        masterRowHolder[1] = new Guess((ImageView) findViewById(R.id.imgRowTwoAnswerPegOne),(ImageView) findViewById(R.id.imgRowTwoAnswerPegTwo), (ImageView) findViewById(R.id.imgRowTwoAnswerPegThree), (ImageView) findViewById(R.id.imgRowTwoAnswerPegFour),
                (ImageView) findViewById(R.id.imgRowTwoPegOne), (ImageView) findViewById(R.id.imgRowTwoPegTwo), (ImageView) findViewById(R.id.imgRowTwoPegThree), (ImageView) findViewById(R.id.imgRowTwoPegFour));

        masterRowHolder[2] = new Guess((ImageView) findViewById(R.id.imgRowThreeAnswerPegOne),(ImageView) findViewById(R.id.imgRowThreeAnswerPegTwo), (ImageView) findViewById(R.id.imgRowThreeAnswerPegThree), (ImageView) findViewById(R.id.imgRowThreeAnswerPegFour),
                (ImageView) findViewById(R.id.imgRowThreePegOne), (ImageView) findViewById(R.id.imgRowThreePegTwo), (ImageView) findViewById(R.id.imgRowThreePegThree), (ImageView) findViewById(R.id.imgRowThreePegFour));

        masterRowHolder[3] = new Guess((ImageView) findViewById(R.id.imgRowFourAnswerPegOne),(ImageView) findViewById(R.id.imgRowFourAnswerPegTwo), (ImageView) findViewById(R.id.imgRowFourAnswerPegThree), (ImageView) findViewById(R.id.imgRowFourAnswerPegFour),
                (ImageView) findViewById(R.id.imgRowFourPegOne), (ImageView) findViewById(R.id.imgRowFourPegTwo), (ImageView) findViewById(R.id.imgRowFourPegThree), (ImageView) findViewById(R.id.imgRowFourPegFour));
    }



    private void createMasterCode() {
        ArrayList<Integer> unusedColors= new ArrayList<>();
        masterCode = new peg[4];
        int color;
        int pos=0;

        for(int i=0; i<imgColors.length; i++){
            unusedColors.add(imgColors[i]);
        }

        do {
            color=imgColors[(int) ((Math.random()*5)+1)];
            if (unusedColors.contains(color)){
                masterCode[pos]= new peg(pos,color);
                unusedColors.remove(unusedColors.indexOf(color));
                pos++;
            }
        } while(masterCode[masterCode.length-1]==null);

        for (peg myPeg : masterCode){
            Log.i(myPeg.getPosition()+"",myPeg.getColorWord());
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

        userPegs = new peg[]{pegOne, pegTwo, pegThree, pegFour};

        for(int i=0; i<gameButtons.length;i++)
            changeColor(gameButtons[i],0);

        submit.setEnabled(false);
    }


    public void buttonOneChange(View view) {
        if(clrOne>=imgColors.length)
            clrOne=1;
        else
            clrOne++;
        changeColor(btnPegOne,clrOne);
    }

    public void buttonTwoChange(View view) {
        if(clrTwo>=imgColors.length)
            clrTwo=1;
        else
            clrTwo++;
        changeColor(btnPegTwo,clrTwo);
    }

    public void buttonThreeChange(View view) {
        if(clrThree>=imgColors.length)
            clrThree=1;
        else
            clrThree++;
        changeColor(btnPegThree,clrThree);
    }

    public void buttonFourChange(View view) {
        if(clrFour>=imgColors.length)
            clrFour=1;
        else
            clrFour++;
        changeColor(btnPegFour,clrFour);
    }

    private void changeColor(ImageButton peg, int clr) {
        switch (clr){
            case 0: peg.setImageResource(R.drawable.peg_empty);
                break;
            case 1: peg.setImageResource(imgColors[0]);
                break;
            case 2: peg.setImageResource(imgColors[1]);
                break;
            case 3: peg.setImageResource(imgColors[2]);
                break;
            case 4: peg.setImageResource(imgColors[3]);
                break;
            case 5: peg.setImageResource(imgColors[4]);
                break;
            case 6: peg.setImageResource(imgColors[5]);
                break;
            default: return;
        }

        if (clrOne>0&&clrTwo>0&&clrThree>0&&clrFour>0){
            submit.setEnabled(true);
        }
    }
}

