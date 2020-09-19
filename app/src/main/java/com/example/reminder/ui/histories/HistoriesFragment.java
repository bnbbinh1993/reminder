package com.example.reminder.ui.histories;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.R;
import com.example.reminder.adapter.AdapterHistory;
import com.example.reminder.models.History;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoriesFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterHistory adapterHistory;
    private ArrayList<History> list;

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
        adapterHistory = new AdapterHistory(getActivity(),list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapterHistory);
        addList();
    }

    private void init(View v) {
        recyclerView = v.findViewById(R.id.recyclerviewHistoryId);
    }
    private void addList(){
        String a = "1";
        list.add(new History(1,"Đi chơi với crush",a,a,a,a,a,a,a,a,a,"Đã hoàn thành"));
        list.add(new History(2,"Đi chơi với crush",a,a,a,a,a,a,a,a,a,"Đã hoàn thành"));
        list.add(new History(3,"Đi chơi với crush",a,a,a,a,a,a,a,a,a,"Đã hoàn thành"));
        adapterHistory.notifyDataSetChanged();
    }

}
