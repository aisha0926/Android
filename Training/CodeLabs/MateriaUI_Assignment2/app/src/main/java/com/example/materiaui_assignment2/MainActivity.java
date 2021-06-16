package com.example.materiaui_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity  {
//    TextInputLayout mDatePicker;
    private String[] mArea = { "Display all","+91"};
    private String[] mState = {"London", "Oxford", "Surrey", "Morden", "Hatford"};
     private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin_area = findViewById(R.id.dropdown_Area);

        spin_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.this.onItemSelected(parent, view,position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mArea);
        mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_area.setAdapter(mArrayAdapter);
        AutoCompleteTextView spin_state = findViewById(R.id.dropdown_state);
        ArrayAdapter mArrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mState);
        mArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_state.setAdapter(mArrayAdapter1);

    }

    public void datePicker(View view){

        TextInputEditText bday = findViewById(R.id.txtBirthday);
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        bday.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String area = parent.getItemAtPosition(position).toString();

      if (area.equals("Display all")) {
          if(dialog == null) {
              dialog = new Dialog(MainActivity.this);
          }
            dialog.setContentView(R.layout.area_list);
            dialog.setTitle("Title...");

            ListView simpleList= (ListView) dialog.findViewById(R.id.List);
           Adapter adapter = new Adapter(MainActivity.this, R.layout.activity_text, Arrays.asList(mState));
          simpleList.setAdapter(adapter);

          dialog.show();

          simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  String clickedItem=(String) simpleList.getItemAtPosition(position);
                  Toast.makeText(MainActivity.this,clickedItem,Toast.LENGTH_LONG).show();
                  dialog.hide();

              }
          });


        }
    }
    }


