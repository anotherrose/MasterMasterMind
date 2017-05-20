package com.example.wilsona.mastermind;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by wilsona on 5/9/2017.
 */

public class Guess {
    private ImageView[] answers = new ImageView[4];
    private ImageView[] guesses = new ImageView[4];

    public Guess (ImageView aOne, ImageView aTwo, ImageView aThree, ImageView aFour, ImageView gOne, ImageView gTwo, ImageView gThree, ImageView gFour){
        setAnswers(aOne,aTwo,aThree,aFour);
        setGuesses(gOne,gTwo,gThree,gFour);
    }

    //changes the images in the guess array
    private void setGuesses(ImageView gOne, ImageView gTwo, ImageView gThree, ImageView gFour) {
        guesses[0]=gOne;
        guesses[1]=gTwo;
        guesses[2]=gThree;
        guesses[3]=gFour;

    }

    //changes the images in the answer array
    private void setAnswers(ImageView aOne, ImageView aTwo, ImageView aThree, ImageView aFour) {
        answers[0]=aOne;
        answers[1]=aTwo;
        answers[2]=aThree;
        answers[3]=aFour;
    }

    //returns array of images
    public ImageView[] getAnswers() {
        return answers;
    }

    public ImageView[] getGuesses() {
        return guesses;
    }

    //cchange the image of the answer and guess array
    public void changeImages (int black, int white, int colorOne, int colorTwo, int colorThree, int colorFour){
        int i;
        int j;
        for (i=0; i<black; i++)
            answers[i].setImageResource(R.drawable.peg_black);
        for(j=black; j<black+white; j++)
            answers[j].setImageResource(R.drawable.peg_white);

        guesses[0].setImageResource(colorOne);
        guesses[1].setImageResource(colorTwo);
        guesses[2].setImageResource(colorThree);
        guesses[3].setImageResource(colorFour);

    }
}