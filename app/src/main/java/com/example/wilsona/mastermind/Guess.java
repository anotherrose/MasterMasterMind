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

    private void setGuesses(ImageView gOne, ImageView gTwo, ImageView gThree, ImageView gFour) {
        guesses[0]=gOne;
        guesses[1]=gTwo;
        guesses[2]=gThree;
        guesses[3]=gFour;

    }

    private void setAnswers(ImageView aOne, ImageView aTwo, ImageView aThree, ImageView aFour) {
        answers[0]=aOne;
        answers[1]=aTwo;
        answers[2]=aThree;
        answers[3]=aFour;
    }

    public ImageView[] getAnswers() {
        return answers;
    }

    public ImageView[] getGuesses() {
        return guesses;
    }
}

/*
string n = "name";
int n = 24;
name+1=25;

for (int i=0; i>5; i++){
 int n+i = i;
 }

 name1 = i
 name2 = i+1
 ...
 */