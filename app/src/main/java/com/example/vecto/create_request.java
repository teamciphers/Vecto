package com.example.vecto;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class create_request extends AppCompatActivity {

    TextView tv;
    int t1hour, t1Minute;

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
    }
}