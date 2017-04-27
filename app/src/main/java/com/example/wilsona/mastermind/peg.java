package com.example.wilsona.mastermind;

import android.graphics.Color;

/**
 * Created by wilsona on 4/26/2017.
 */

public class peg {
    private int color;
    private int position;

    public peg (int n, int c){
        position = n;
        color = c;
    }

    public int getPosition(){
        return position;
    }

    public String getColor() {
        switch (color){
            case 1: return  "red";
            case 2: return "yellow";
            case 3: return "blue";
            case 4: return "green";
            case 5: return "pink";
            case 6: return "magenta";
            default: return "error";
        }
    }
}
