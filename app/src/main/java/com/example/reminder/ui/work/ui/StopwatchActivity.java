package com.example.reminder.ui.work.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.reminder.R;
import com.example.reminder.adapter.AdapterTImeStopWatch;
import com.example.reminder.models.TimeStopWatch;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

public class StopwatchActivity extends AppCompatActivity {
    private TextView exitStopwatchId;
    private TextView timeCoutTotal;
    private RecyclerView recyclerView;
    private AdapterTImeStopWatch adapter;
    private ArrayList<TimeStopWatch> list;
    private int timeTotals;
    private int timeStopWatch;
    private int stt;
    private Button btnStartStopWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        init();
        timeCount();
        initEvent();

    }

    private void initEvent() {
        exitStopwatchId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        list = new ArrayList<>();
        adapter = new AdapterTImeStopWatch(this, list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        addList();
        adapter.notifyDataSetChanged();

    }

    private void init() {
        exitStopwatchId = findViewById(R.id.exitStopwatchId);
        recyclerView = findViewById(R.id.recylerviewTimeStopWatch);
        btnStartStopWatch = findViewById(R.id.btnStartStopWatch);
        timeCoutTotal = findViewById(R.id.timeCoutTotal);
    }

    private void addList() {
        btnStartStopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeStop = String.format("%02d", timeStopWatch / 1000 / 60) + ":" + String.format("%02d", timeStopWatch / 1000) + "." + String.format("%02d", timeStopWatch % 1000 / 10);
                String timeTotal = String.format("%02d", timeTotals / 1000 / 60) + ":" + String.format("%02d", timeTotals / 1000) + "." + String.format("%02d", timeTotals % 1000 / 10);
                stt++;
                list.add(new TimeStopWatch(stt, timeStop, timeTotal));
                adapter.notifyDataSetChanged();
                timeStopWatch = 0;

            }
        });
    }

    private void timeCount() {
        CountDownTimer downTimer = new CountDownTimer(1000000000, 1) {
            @Override
            public void onTick(long l) {
                timeTotals = timeTotals +10;
                timeStopWatch = timeStopWatch +10;
                String a = String.format("%02d", timeTotals / 1000 / 60) + ":" + String.format("%02d", timeTotals / 1000) + "." + String.format("%02d", timeTotals % 1000 / 10);
                timeCoutTotal.setText(a);
            }

            @Override
            public void onFinish() {
                timeCount();
            }
        }.start();

    }
}
