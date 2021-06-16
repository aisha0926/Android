package com.example.materiaui_assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter {
    Context mContext;
    int resourceID;
    List<String> names;
    public Adapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.resourceID=resource;
        this.names= objects;
    }

    @Override
    public String getItem(int position) {
        return names.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(resourceID, parent, false);

        TextView text = (TextView) row.findViewById(R.id.textView1);

        text.setText(names.get(position));
        return row;
    }

}