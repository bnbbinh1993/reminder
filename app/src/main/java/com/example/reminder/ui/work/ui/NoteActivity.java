package com.example.reminder.ui.work.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.reminder.R;
import com.example.reminder.adapter.AdapterHistory;
import com.example.reminder.adapter.AdapterNote;
import com.example.reminder.models.History;
import com.example.reminder.models.Note;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterNote adapterNote;
    private ArrayList<Note> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        init();
        initEvent();
    }

    private void initEvent() {
        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();
        adapterNote = new AdapterNote(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapterNote);
        addList();
    }

    private void addList() {
        //data demo
        list.add(new Note("có cái qq gì đâu mà ghi ^^","11/11/2020"));
        list.add(new Note("có cái qq gì đâu mà ghi ^^","11/11/2020"));
        list.add(new Note("có cái qq gì đâu mà ghi ^^","11/11/2020"));
        list.add(new Note("có cái qq gì đâu mà ghi ^^","11/11/2020"));
        list.add(new Note("có cái qq gì đâu mà ghi ^^","11/11/2020"));
        list.add(new Note("có cái qq gì đâu mà ghi ^^","11/11/2020"));
        adapterNote.notifyDataSetChanged();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerViewNote);

    }
}
