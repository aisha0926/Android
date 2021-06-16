package com.jitendra.shadabsirapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Spinner spin_area, spin_state;
    private String[] mArea = {"Area", "Area", "Area", "Area", "Area"};
    private String[] mState = {"State", "State", "State", "State", "State"};
    private EditText et_birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.MobileApp));

        spin_area = (Spinner) findViewById(R.id.spin_area);
        ArrayAdapter mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mArea);
        mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_area.setAdapter(mArrayAdapter);

        spin_state = (Spinner) findViewById(R.id.spin_state);
        ArrayAdapter mArrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mState);
        mArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_state.setAdapter(mArrayAdapter1);

        et_birthday = (EditText) findViewById(R.id.et_birthday);
        et_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDatePickerDialog(et_birthday);
            }
        });

    }

    private void setDatePickerDialog(final EditText et_dateFromTo) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        et_dateFromTo.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
