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

    public peg(int n, String c){
        position = n;
        color = colorWordToNumber(c);
    }

    private int colorWordToNumber(String c) {
        switch (c){
            case "red": return  1;
            case "yellow": return 2;
            case "blue": return 3;
            case "green": return 4;
            case "pink": return 5;
            case "magenta": return 6;
            default: return 0;
        }
    }

    private String colorNumberToWord(int c){
        switch (c){
            case 1: return  "red";
            case 2: return "yellow";
            case 3: return "blue";
            case 4: return "green";
            case 5: return "pink";
            case 6: return "magenta";
            default: return "error";
        }
    }

    public int getPosition(){
        return position;
    }

    public int getColorNum() {
        return color;
    }
    public String getColorWord() {
        return colorNumberToWord(color);
    }

    public void setColor(int color){
        this.color=color;
    }
    public void setColor(String color){
        this.color=colorWordToNumber(color);
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
