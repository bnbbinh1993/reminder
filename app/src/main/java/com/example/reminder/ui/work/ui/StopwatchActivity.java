package com.example.reminder.ui.work.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.reminder.R;

public class StopwatchActivity extends AppCompatActivity {
    private TextView exitStopwatchId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        init();
        initEvent();
    }

    private void initEvent() {
        exitStopwatchId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        exitStopwatchId = findViewById(R.id.exitStopwatchId);
    }
}
