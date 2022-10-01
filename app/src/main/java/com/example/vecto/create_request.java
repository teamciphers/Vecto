package com.example.vecto;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class create_request extends AppCompatActivity {

    TextView tv;
    int t1hour, t1Minute;
    TextInputLayout textInputLayout, textInputLayout2;
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_request);

        tv = findViewById(R.id.time_input);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(create_request.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                t1hour=i;
                                t1Minute=i1;

                                Calendar calendar=Calendar.getInstance();
                                calendar.set(0,0,0,t1hour,t1Minute);

                                tv.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12,0,false
                        );
                timePickerDialog.updateTime(t1hour,t1Minute);
                timePickerDialog.show();

            }
        });
        textInputLayout = findViewById(R.id.menu1);
        autoCompleteTextView = findViewById(R.id.drop_items1);
        String[] items1 = {"Male","Female","Any"};
        ArrayAdapter<String> itemAdapter=new ArrayAdapter<>(create_request.this, R.layout.items_list,items1);
        autoCompleteTextView.setAdapter(itemAdapter);

        textInputLayout2 = findViewById(R.id.menu2);
        autoCompleteTextView2 = findViewById(R.id.drop_items2);
        String[] items2 = {"0","1","2","3","4","5"};
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(create_request.this, R.layout.items_list, items2);
        autoCompleteTextView2.setAdapter(itemAdapter2);

    }
}