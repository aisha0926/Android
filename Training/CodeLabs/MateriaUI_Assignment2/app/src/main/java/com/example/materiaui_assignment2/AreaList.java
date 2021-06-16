package com.example.materiaui_assignment2;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

public class AreaList extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] areaList = getResources().getStringArray(R.array.areaList);
        ListView lv = getListView();

        //this.setListAdapter(new ArrayAdapter<String>(this, R.layout.area_list, R.id.textView, areaList));
    }
}
