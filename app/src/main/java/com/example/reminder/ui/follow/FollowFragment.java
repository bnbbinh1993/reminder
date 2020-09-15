package com.example.reminder.ui.follow;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reminder.R;
import com.example.reminder.adapter.AdapterEvent;
import com.example.reminder.models.Event;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Event> list;
    private AdapterEvent adapter;
    private TextView textDay;
    private TextView textHour;
    private TextView textMunite;
    private TextView textSecond;
    private  Timer timer;
    private  TimerTask timerTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        init(view);
        initEvent();
        return view;
    }

    private void init(View view) {
        textDay = view.findViewById(R.id.textDay);
        textHour = view.findViewById(R.id.textHour);
        textMunite = view.findViewById(R.id.textMunite);
        textSecond = view.findViewById(R.id.textSecond);
        recyclerView = view.findViewById(R.id.recyclerviewHomeId);
        list = new ArrayList<>();
        adapter = new AdapterEvent(getContext(),list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setAdapter(adapter);
        String a = "a";
        list.add(new Event(1,"Đi xem phim cùng crush",a,a,a,a,a,a,a,a));



        adapter.notifyDataSetChanged();
    }
    private void initEvent(){

        setTimer();

    }
    private void setTimer() {
        CountDownTimer count = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {
                Calendar c = Calendar.getInstance();
                textDay.setText(String.valueOf(c.get(Calendar.DATE)));
                textHour.setText(String.valueOf(c.get(Calendar.HOUR)));
                textMunite.setText(String.valueOf(c.get(Calendar.MINUTE)));
                textSecond.setText(String.valueOf(c.get(Calendar.SECOND)));
            }

            @Override
            public void onFinish() {
                setTimer();
            }
        }.start();

    }


}
