package com.example.reminder.ui.follow;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.R;
import com.example.reminder.adapter.AdapterEvent;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.models.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowFragment extends Fragment {
    private MyDatabaseHelper helper;
    private RecyclerView recyclerView;
    private List<Event> list;
    private List<Event> list2;
    private AdapterEvent adapter;
    private TextView textDay;
    private TextView textHour;
    private TextView textMunite;
    private TextView textSecond;
    private Timer timer;
    private TimerTask timerTask;
    private List<Event> listEvent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        helper = new MyDatabaseHelper(getActivity());
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

    }

    private void initEvent() {

        setTimer();
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list = helper.getAllEvent();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        getAllData();

    }

    private void setTimer() {
        CountDownTimer count = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                Calendar c = Calendar.getInstance();
                textDay.setText(String.valueOf(c.get(Calendar.DATE)));
                textHour.setText(String.valueOf(c.get(Calendar.HOUR)));
                textMunite.setText(String.valueOf(c.get(Calendar.MINUTE)));
                textSecond.setText(String.valueOf(c.get(Calendar.SECOND)));
                getAllData();
            }

            @Override
            public void onFinish() {
                setTimer();
            }
        }.start();

    }

    private void getAllData() {
        list = helper.getAllEvent();
        Collections.reverse(list);
        list2.clear();
        for (int i = 0;i<list.size();i++){
            if (Integer.valueOf(list.get(i).getStatus())<2){
                int id = list.get(i).getId();
                String title = list.get(i).getTitle();
                String description = list.get(i).getDescription();
                String category =  list.get(i).getCategory();
                String date =  list.get(i).getDate();
                String time =  list.get(i).getTime();
                String repeat =  list.get(i).getRepeat();
                String remind =  list.get(i).getRemind();
                String ring =  list.get(i).getRing();
                String theme =  list.get(i).getTheme();
                String ghim =  list.get(i).getGhim();
                String status =  list.get(i).getStatus();
                Event model = new Event(id,title,description,category,date,time,repeat,remind,ring,theme,ghim,status);
                list2.add(model);
            }
        }


        adapter = new AdapterEvent(getContext(), list2);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onResume() {
        super.onResume();
        getAllData();
    }

    @Override
    public void onStart() {
        super.onStart();
        getAllData();
    }

    @Override
    public void onPause() {
        super.onPause();
        getAllData();
    }
}
