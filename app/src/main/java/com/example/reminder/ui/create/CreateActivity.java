package com.example.reminder.ui.create;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.reminder.R;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.models.Event;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Calendar;

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
    private DatePickerDialog picker;
    private TimePickerDialog timepickerdialog;

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
        setDate();
        setTime();
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
    }


    private void setCategory() {

        tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog sheetDialog = new BottomSheetDialog(CreateActivity.this);
                View view1 = LayoutInflater.from(CreateActivity.this).inflate(R.layout.bottom_sheet_category, null);
                LinearLayout birthdayId = view1.findViewById(R.id.birthdayId);
                LinearLayout eventId = view1.findViewById(R.id.EventId);
                LinearLayout loveId = view1.findViewById(R.id.LoveId);
                LinearLayout workId = view1.findViewById(R.id.WorkId);
                sheetDialog.setContentView(view1);

                sheetDialog.show();
                birthdayId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvCategory.setText("birthday");
                        sheetDialog.dismiss();
                    }
                });
                eventId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvCategory.setText("event");
                        sheetDialog.dismiss();
                    }
                });
                loveId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvCategory.setText("love");
                        sheetDialog.dismiss();
                    }
                });
                workId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvCategory.setText("work");
                        sheetDialog.dismiss();
                    }
                });
            }
        });
    }
    private void setDate(){
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(CreateActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tvDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);

                picker.show();
            }
        });

    }
    private void setTime(){

           tvTime.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   final Calendar myCalender = Calendar.getInstance();
                   final int hour = myCalender.get(Calendar.HOUR_OF_DAY);
                   final int minute1 = myCalender.get(Calendar.MINUTE);


                   TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                       @Override
                       public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                           if (view.isShown()) {
                               myCalender.set(Calendar.HOUR_OF_DAY, hourOfDay);
                               myCalender.set(Calendar.MINUTE, minute);
                               tvTime.setText(hourOfDay+":"+minute);
                           }
                       }
                   };
                   TimePickerDialog timePickerDialog = new TimePickerDialog(CreateActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, myTimeListener, hour, minute1, true);
                   timePickerDialog.setTitle("Choose hour:");
                   timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                   timePickerDialog.show();
               }
           });


    }

    private void setRepeat(){
        
    }

    private void pushData() {
        String title = edtTitle.getText().toString().trim();
        String category = tvCategory.getText().toString().trim();


    }

}
