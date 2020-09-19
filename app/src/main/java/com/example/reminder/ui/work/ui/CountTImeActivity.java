package com.example.reminder.ui.work.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reminder.R;

public class CountTImeActivity extends AppCompatActivity {
    private NumberPicker numberHaurs;
    private NumberPicker numberMinute;
    private NumberPicker numberSecond;
    private Button btnStartCountTime;
    private Integer hours = 0;
    private Integer minute = 0;
    private Integer second = 0;

    private TextView tvHuy;
    private LinearLayout layoutText;
    private LinearLayout layoutNumber;
    private LinearLayout layoutCountTimer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_time);
        init();
        initEvent();
    }

    private void initEvent() {
        numberHaurs.setMaxValue(99);
        numberHaurs.setMinValue(00);
        numberMinute.setMaxValue(59);
        numberMinute.setMinValue(00);
        numberSecond.setMaxValue(59);
        numberSecond.setMinValue(00);

        numberHaurs.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d",i);
            }
        });
        numberMinute.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d",i);
            }
        });
        numberSecond.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d",i);
            }
        });

        numberHaurs.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                hours = i1;
            }
        });
        numberMinute.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                minute = i1;
            }
        });
        numberSecond.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                second = i1;
            }
        });


        btnStartCountTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutNumber.setVisibility(View.GONE);
                layoutText.setVisibility(View.GONE);
                layoutCountTimer.setVisibility(View.VISIBLE);
            }
        });

        tvHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void init() {
        numberHaurs = findViewById(R.id.numberHaurs);
        numberMinute = findViewById(R.id.numberMinute);
        numberSecond = findViewById(R.id.numberSecond);
        btnStartCountTime = findViewById(R.id.btnStartCountTime);
        tvHuy = findViewById(R.id.tvHuy);
        layoutText = findViewById(R.id.layoutText);
        layoutNumber = findViewById(R.id.layoutNumber);
        layoutCountTimer = findViewById(R.id.layoutCountTimer);
    }
}
