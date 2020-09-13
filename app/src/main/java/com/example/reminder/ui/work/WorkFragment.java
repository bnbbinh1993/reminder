package com.example.reminder.ui.work;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reminder.R;
import com.example.reminder.adapter.AdapterCreate;
import com.example.reminder.models.Create;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkFragment extends Fragment {

    private RecyclerView recylerviewId;
    private AdapterCreate adapter;
    private ArrayList<Create> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_work, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        list = new ArrayList<>();
        recylerviewId = view.findViewById(R.id.recylerviewId);
        adapter = new AdapterCreate(getContext(),list);
        recylerviewId.setHasFixedSize(true);
        recylerviewId.setLayoutManager(new GridLayoutManager(getContext(),1));
        recylerviewId.setAdapter(adapter);

        list.add(new Create("Hẹn giờ",R.drawable.ic_card_travel_pink_24dp));
        list.add(new Create("Sự kiện",R.drawable.ic_card_travel_pink_24dp));
        list.add(new Create("Bộ đếm ngày",R.drawable.ic_card_travel_pink_24dp));
        list.add(new Create("Bộ đếm tuổi",R.drawable.ic_card_travel_pink_24dp));
        list.add(new Create("Lịch cá nhân",R.drawable.ic_card_travel_pink_24dp));

        adapter.notifyDataSetChanged();
    }
}
