package com.example.wilsona.mastermind;

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
            case "red": return  R.drawable.peg_red;
            case "yellow": return R.drawable.peg_yellow;
            case "blue": return R.drawable.peg_blue;
            case "green": return R.drawable.peg_green;
            case "orange": return R.drawable.peg_orange;
            case "magenta": return R.drawable.peg_magenta;
            default: return 0;
        }
    }

    private String colorNumberToWord(int c){
        switch (c){
            case R.drawable.peg_red: return  "red";
            case R.drawable.peg_yellow: return "yellow";
            case R.drawable.peg_blue: return "blue";
            case R.drawable.peg_green: return "green";
            case R.drawable.peg_orange: return "Orange";
            case R.drawable.peg_magenta: return "magenta";
            default: return "error";
        }
    }

    public boolean compareColor(peg p){
        if (this.imgColor==p.getColorNum())
            return true;
        else
            return false;
    }

    public boolean comparePositionAndColor(peg p){
        if (this.imgColor==p.getColorNum() && this.position==p.getPosition())
            return true;
        else
            return false;
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
