package com.example.wilsona.mastermind;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int images[];

    public CustomAdapter(Context ctx, int txtViewResourceId, String[] objects, int[] images)
    {
        super(ctx, txtViewResourceId, objects);
        this.context=ctx;
        this.images = images;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return customView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return customView(position, convertView, parent);
    }

    public View customView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.spinner_row, parent, false);
        TextView imgPosition = (TextView) convertView.findViewById(R.id.txtPeg);
        imgPosition.setText(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        imageView.setImageResource(images[position]);
        return convertView;

    }
    //Override the getCount() because we are passing object as null in constructor
    //getCount() determines how many times the getView should b called
    @Override
    public int getCount() {
        return images.length;
    }

}