package com.example.wilsona.mastermind;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by wilsona on 5/9/2017.
 */

public class Guess {
    private ImageView[] answers;
    private ImageView[] guesses;

    public Guess (ImageView aOne, ImageView aTwo, ImageView aThree, ImageView aFour, ImageView gOne, ImageView gTwo, ImageView gThree, ImageView gFour){
        setAnswers(aOne,aTwo,aThree,aFour);
        setGuesses(gOne,gTwo,gThree,gFour);
    }

    private void setGuesses(ImageView gOne, ImageView gTwo, ImageView gThree, ImageView gFour) {
    }

    private void setAnswers(ImageView aOne, ImageView aTwo, ImageView aThree, ImageView aFour) {
    }
}
