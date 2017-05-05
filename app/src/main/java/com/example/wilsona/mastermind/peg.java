package com.example.wilsona.mastermind;

import android.graphics.Color;

/**
 * Created by wilsona on 4/26/2017.
 */

public class peg {
    private int imgColor;
    private int position;

    public peg (int n, int c){
        position = n;
        imgColor = c;
    }

    public peg(int n, String c){
        position = n;
        imgColor = colorWordToNumber(c);
    }

    private int colorWordToNumber(String c) {
        switch (c){
            case "red": return  R.drawable.pegRed;
            case "yellow": return R.drawable.pegYellow;
            case "blue": return R.drawable.pegBlue;
            case "green": return R.drawable.pegGreen;
            case "orange": return R.drawable.pegOrange;
            case "magenta": return R.drawable.pegMagenta;
            default: return 0;
        }
    }

    private String colorNumberToWord(int c){
        switch (c){
            case R.drawable.pegRed: return  "red";
            case R.drawable.pegYellow: return "yellow";
            case R.drawable.pegBlue: return "blue";
            case R.drawable.pegGreen: return "green";
            case R.drawable.pegOrange: return "Orange";
            case R.drawable.pegMagenta: return "magenta";
            default: return "error";
        }
    }

    public int getPosition(){
        return position;
    }

    public int getColorNum() {
        return imgColor;
    }
    public String getColorWord() {
        return colorNumberToWord(imgColor);
    }

    public void setColor(int color){
        imgColor=color;
    }
    public void setColor(String color){
        imgColor=colorWordToNumber(color);
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
