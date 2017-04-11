package com.example.wilsona.mastermind;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

class CustomSpinnerAdapter extends SimpleAdapter {

    LayoutInflater mInflater;
    private List<? extends Map<String, ?>> dataRecieved;

    public CustomSpinnerAdapter(Context context, List<? extends Map<String, ?>> data,
                                int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        dataRecieved =data;
        mInflater=LayoutInflater.from(context);
    }

    @SuppressWarnings("unchecked")
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.spinner_row,
                    null);
        }
        //  HashMap<String, Object> data = (HashMap<String, Object>) getItem(position);
        ((TextView) convertView.findViewById(R.id.imageNameSpinner))
                .setText((String) dataRecieved.get(position).get("Name"));
        ((ImageView) convertView.findViewById(R.id.imageIconSpinner))
                .setBackgroundResource(dataRecieved.get(position).get("Icon")));
        return convertView;
    }
}
