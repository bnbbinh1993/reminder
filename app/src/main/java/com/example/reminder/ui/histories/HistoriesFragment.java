package com.example.reminder.ui.histories;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.R;
import com.example.reminder.adapter.AdapterEvent;
import com.example.reminder.adapter.AdapterHistory;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.models.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoriesFragment extends Fragment {
    private MyDatabaseHelper helper;
    private RecyclerView recyclerView;
    private AdapterHistory adapter;
    private List<Event> list;
    private List<Event> list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_histories, container, false);
        init(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        adapter = new AdapterHistory(getActivity(), list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        getAllData();
    }

    private void init(View v) {
        recyclerView = v.findViewById(R.id.recyclerviewHistoryId);
    }

    private void getAllData() {
        helper = new MyDatabaseHelper(getActivity());
        list = helper.getAllEvent();
        Collections.reverse(list);
        list2.clear();
        for (int i = 0; i < list.size(); i++) {
            if (Integer.valueOf(list.get(i).getStatus()) >= 1) {
                int id = list.get(i).getId();
                String title = list.get(i).getTitle();
                String description = list.get(i).getDescription();
                String category = list.get(i).getCategory();
                String date = list.get(i).getDate();
                String time = list.get(i).getTime();
                String repeat = list.get(i).getRepeat();
                String remind = list.get(i).getRemind();
                String ring = list.get(i).getRing();
                String theme = list.get(i).getTheme();
                String ghim = list.get(i).getGhim();
                String status = list.get(i).getStatus();
                Event model = new Event(id, title, description, category, date, time, repeat, remind, ring, theme, ghim, status);
                list2.add(model);
            }
        }
        adapter = new AdapterHistory(getActivity(), list2);
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
