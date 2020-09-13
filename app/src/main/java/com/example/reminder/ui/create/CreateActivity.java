package com.example.reminder.ui.create;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.reminder.R;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.models.Event;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CreateActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private EditText edtTitle;
    private TextView tvSave;
    private TextView tvCategory;
    private TextView tvDate;
    private TextView tvTime;
    private TextView tvRepeat;
    private TextView tvRemind;
    private TextView tvRing;
    private TextView tvWallpaper;
    private LinearLayout Title;
    private RelativeLayout Category;
    private RelativeLayout Date;
    private RelativeLayout Time;
    private RelativeLayout Repeat;
    private RelativeLayout Remind;
    private RelativeLayout Ring;
    private RelativeLayout Wallpaper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        dbHelper = new MyDatabaseHelper(this);

       init();

       initEvent();

    }

    private void initEvent() {
        setCategory();
    }

    private void init() {
        tvSave = findViewById(R.id.tvSave);
        edtTitle = findViewById(R.id.edtTitle);
        tvCategory = findViewById(R.id.tvCategory);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        tvRepeat = findViewById(R.id.tvRepeat);
        tvRemind = findViewById(R.id.tvRemind);
        tvRing = findViewById(R.id.tvRing);
        tvWallpaper = findViewById(R.id.tvWallpaper);
        Title = findViewById(R.id.titleId);
        Category = findViewById(R.id.categoryId);
        Date = findViewById(R.id.dateId);
        Time = findViewById(R.id.timeId);
        Repeat = findViewById(R.id.repeatId);
        Remind = findViewById(R.id.remindId);
        Ring = findViewById(R.id.ringId);
        Wallpaper = findViewById(R.id.wallpaperId);

    }


    private void setCategory(){

        Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog sheetDialog = new BottomSheetDialog(CreateActivity.this);
                View view1 = LayoutInflater.from(CreateActivity.this).inflate(R.layout.bottom_sheet_category,null);
                LinearLayout LoveId = view1.findViewById(R.id.LoveId);
                LinearLayout EventId = view1.findViewById(R.id.EventId);
                sheetDialog.setContentView(view1);

                sheetDialog.show();
                LoveId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sheetDialog.dismiss();
                    }
                });
                EventId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sheetDialog.dismiss();
                    }
                });
            }
        });
    }
}
