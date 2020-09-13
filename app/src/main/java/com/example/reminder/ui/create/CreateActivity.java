package com.example.reminder.ui.create;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.reminder.R;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.models.Event;

public class CreateActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private TextView tvSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        tvSave = findViewById(R.id.tvSave);

        dbHelper = new MyDatabaseHelper(this);

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = new Event();
                event.setTitle("Bùi Ngọc Bình");
                event.setDate("Bùi Ngọc Bình");
                event.setTime("Bùi Ngọc Bình");
                event.setRepeat("Bùi Ngọc Bình");
                event.setRemind("Bùi Ngọc Bình");
                event.setRing("Bùi Ngọc Bình");
                event.setTheme("Bùi Ngọc Bình");
                event.setGhim("Bùi Ngọc Bình");
                dbHelper.addEventt(event);
            }
        });
    }
}
