package com.example.wilsona.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class EasyBoard extends AppCompatActivity {

    private int clrOne, clrTwo, clrThree, clrFour;
    private int[] userColors;
    private Button submit;
    private ImageButton btnPegOne, btnPegTwo, btnPegThree, btnPegFour;
    private ImageButton[] gameButtons;
    private peg[] userPegs;
    private peg[] masterCode;
    private String[] allColors;
    private int numColors = 6;
    private int guess = 0;
    //private int imgEmpty, imgBlue, imgGreen, imgRed, imgOrange, imgYellow, imgMagenta;

    ImageView imgGuessAnswerTL;
    ImageView imgGuessAnswerTR;
    ImageView imgGuessAnswerBL;
    ImageView imgGuessAnswerBR;

    ImageView imgGuessOne;
    ImageView imgGuessTwo;
    ImageView imgGuessThree;
    ImageView imgGuessFour;

    private int[] imgColors;
    private ImageView[] guessDisplay;
    private ImageView[] guessAnswers;
    private ImageView[][]guessOne;
    private ImageView[][] masterTurnHolder;

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

        imgColors = new int[]{R.drawable.peg_blue, R.drawable.peg_green, R.drawable.peg_red, R.drawable.peg_orange, R.drawable.peg_yellow, R.drawable.peg_magenta};

        createMasterCode();
        createImages();
    }



    private void createImages() {
        imgGuessAnswerTL = (ImageView) findViewById(R.id.imgRowOneAnswerPegOne);
        imgGuessAnswerTR = (ImageView) findViewById(R.id.imgRowOneAnswerPegTwo);
        imgGuessAnswerBL = (ImageView) findViewById(R.id.imgRowOneAnswerPegThree);
        imgGuessAnswerBR = (ImageView) findViewById(R.id.imgRowOneAnswerPegFour);

        imgGuessOne = (ImageView) findViewById(R.id.imgRowOnePegOne);
        imgGuessTwo = (ImageView) findViewById(R.id.imgRowOnePegTwo);
        imgGuessThree = (ImageView) findViewById(R.id.imgRowOnePegThree);
        imgGuessFour = (ImageView) findViewById(R.id.imgRowOnePegFour);

        guessDisplay = new ImageView[]{imgGuessOne, imgGuessTwo, imgGuessThree, imgGuessFour};
        guessAnswers = new ImageView[]{imgGuessAnswerTL, imgGuessAnswerTR,imgGuessAnswerBL, imgGuessAnswerBR};

        masterTurnHolder = new ImageView[][]{guessAnswers,guessDisplay};
    }



    private void createMasterCode() {
        ArrayList<Integer> unusedColors= new ArrayList<Integer>();
        masterCode = new peg[4];
        int color;
        int pos=0;

        for(int i=1; i<=allColors.length; i++){
            unusedColors.add(imgColors[i-1]);
        }

        do {
            color=imgColors[(int) ((Math.random()*6)+1)];
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

        userColors = new int[]{clrOne, clrTwo, clrThree, clrFour};
        userPegs = new peg[]{pegOne, pegTwo, pegThree, pegFour};

        for(int i=0; i<gameButtons.length;i++)
            changeColor(gameButtons[i],R.drawable.peg_empty);

        submit.setEnabled(false);

    }


    public void buttonOneChange(View view) {
        if(clrOne>=allColors.length)
            clrOne=1;
        else
            clrOne++;
        changeColor(btnPegOne,clrOne);
    }

    public void buttonTwoChange(View view) {
        if(clrTwo>=allColors.length)
            clrTwo=1;
        else
            clrTwo++;
        changeColor(btnPegTwo,clrTwo);
    }

    public void buttonThreeChange(View view) {
        if(clrThree>=allColors.length)
            clrThree=1;
        else
            clrThree++;
        changeColor(btnPegThree,clrThree);
    }

    public void buttonFourChange(View view) {
        if(clrFour>=allColors.length)
            clrFour=1;
        else
            clrFour++;
        changeColor(btnPegFour,clrFour);
    }

    private void changeColor(ImageButton peg, int clr) {
        switch (clr){
            case 0: peg.setImageResource(imgEmpty);
                break;
            case R.drawable.peg_red: peg.setImageResource(imgRed);
                break;
            case R.drawable.peg_yellow: peg.setImageResource(imgYellow);
                break;
            case R.drawable.peg_blue: peg.setImageResource(imgBlue);
                break;
            case R.drawable.peg_green: peg.setImageResource(imgGreen);
                break;
            case R.drawable.peg_orange: peg.setImageResource(imgOrange);
                break;
            case R.drawable.peg_magenta: peg.setImageResource(imgMagenta);
                break;
            default: return;
        }

        if (clrOne>0&&clrTwo>0&&clrThree>0&&clrFour>0){
            submit.setEnabled(true);
        }
    }
}

