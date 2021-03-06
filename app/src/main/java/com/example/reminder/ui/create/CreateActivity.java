package com.example.reminder.ui.create;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reminder.R;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.models.Event;
import com.example.reminder.utils.Binh;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private ImageView image_category;
    private ImageView image_date;
    private ImageView image_time;
    private ImageView image_repeat;
    private ImageView image_remind;
    private ImageView image_ring;
    private ImageView image_wallpaper;
    private EditText edtTitle;
    private EditText edtDescription;
    private TextView tvSave;
    private TextView exitId;
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
    private Binh binh = new Binh(this);

    private String repeatString = "0";
    private String timeLong = "00:00:00";
    private String dateLong = "20.03.1999";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        dbHelper = new MyDatabaseHelper(this);
        init();
        initEvent();

    }

    private void initEvent() {
        exitId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(String.valueOf(getText(R.string.MessengerDialog)));
            }
        });
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long milliseconds = 0;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
                simpleDateFormat.setLenient(false);
                Date endDate;
                String dateTime = dateLong + ", " + timeLong;
                try {
                    endDate = simpleDateFormat.parse(dateTime);
                    milliseconds = endDate.getTime();

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                long startTime = System.currentTimeMillis();

                if (edtTitle.getText().toString().trim().equals("")) {
                    binh.showMessenger("Hãy điền gì đó nha bạn");
                } else if (startTime > milliseconds) {
                    binh.showMessenger("Hãy chọn thời gian trong tương lai");
                } else {
                    pushData();
                }

            }
        });
        tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory();
            }
        });
        image_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory();
            }
        });
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate();
            }
        });
        image_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate();
            }
        });
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime();
            }
        });
        image_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime();
            }
        });
        tvRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRepeat();
            }
        });
        image_repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRepeat();
            }
        });
        tvRemind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRemind();
            }
        });
        image_remind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRemind();
            }
        });

        setView();
    }

    private void setView() {
        //có gì đó sai sai :))))
        tvRemind.setText(binh.getDataString("REMIND", "Trước 1 tuần"));
        tvCategory.setText(binh.getDataString("EVENT", "Sinh nhật"));
        tvDate.setText(binh.getDataString("DATE", "20/03/1999"));
        tvTime.setText(binh.getDataString("TIME", "20:20"));
        tvRepeat.setText(binh.getDataString("REPEAT", "Hằng năm"));
        tvRing.setText(binh.getDataString("RING", "Mặc định"));
        tvWallpaper.setText(binh.getDataString("WALLPAPER", "Mặc định"));

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
        exitId = findViewById(R.id.exitId);
        image_category = findViewById(R.id.image_category);
        image_date = findViewById(R.id.image_date);
        image_time = findViewById(R.id.image_time);
        image_repeat = findViewById(R.id.image_repeat);
        image_remind = findViewById(R.id.image_remind);
        image_ring = findViewById(R.id.image_ring);
        image_wallpaper = findViewById(R.id.image_wallpaper);
        edtDescription = findViewById(R.id.edtDescription);
    }

    private void setCategory() {

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
                tvCategory.setText("Sinh nhật");
                binh.SaveString("EVENT", "Sinh nhật");
                sheetDialog.dismiss();
            }
        });
        eventId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCategory.setText("Sự kiện");
                binh.SaveString("EVENT", "sự kiện");
                sheetDialog.dismiss();
            }
        });
        loveId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binh.SaveString("EVENT", "Tình yêu");
                tvCategory.setText("Tình yêu");
                sheetDialog.dismiss();
            }
        });
        workId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binh.SaveString("EVENT", "Công việc");
                tvCategory.setText("Công việc");
                sheetDialog.dismiss();
            }
        });
    }

    private void setDate() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);

        picker = new DatePickerDialog(CreateActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        cldr.set(year, monthOfYear, dayOfMonth);
                        dateLong = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        tvDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        binh.SaveString("DATE", tvDate.getText().toString());
                    }
                }, year, month, day);

        picker.show();
    }

    private void setTime() {

        final Calendar myCalender = Calendar.getInstance();
        final int hour = myCalender.get(Calendar.HOUR_OF_DAY);
        final int minute1 = myCalender.get(Calendar.MINUTE);


        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (view.isShown()) {

                    myCalender.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    myCalender.set(Calendar.MINUTE, minute);
                    timeLong = hourOfDay + ":" + minute;
                    tvTime.setText(hourOfDay + ":" + minute);
                    binh.SaveString("TIME", tvTime.getText().toString());
                }
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(CreateActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, myTimeListener, hour, minute1, true);
        timePickerDialog.setTitle("Choose hour:");
        timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        timePickerDialog.show();

    }

    private void setRepeat() {
        final BottomSheetDialog sheetDialog = new BottomSheetDialog(CreateActivity.this);
        View v = LayoutInflater.from(CreateActivity.this).inflate(R.layout.bottom_sheet_repeat, null);
        TextView never = v.findViewById(R.id.never);
        TextView everyday = v.findViewById(R.id.everyday);
        TextView everyweek = v.findViewById(R.id.everyweek);
        TextView everymonth = v.findViewById(R.id.everymonth);
        TextView everyyear = v.findViewById(R.id.everyyear);
        sheetDialog.setContentView(v);
        sheetDialog.show();

        never.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatString = "0";
                tvRepeat.setText("Không bao giờ");
                binh.SaveString("REPEAT", "Không bao giờ");
                sheetDialog.dismiss();
            }
        });
        everyday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatString = "1";
                tvRepeat.setText("Hằng ngày");
                binh.SaveString("REPEAT", "Hằng ngày");
                sheetDialog.dismiss();
            }
        });
        everyweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatString = "2";
                binh.SaveString("REPEAT", "Hằng tuần");
                tvRepeat.setText("Hằng tuần");
                sheetDialog.dismiss();
            }
        });
        everymonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatString = "3";
                tvRepeat.setText("Hằng tháng");
                binh.SaveString("REPEAT", "Hằng tháng");
                sheetDialog.dismiss();
            }
        });
        everyyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatString = "4";
                tvRepeat.setText("Hằng năm");
                binh.SaveString("REPEAT", "Hằng năm");
                sheetDialog.dismiss();
            }
        });

    }

    private void setRemind() {
        final BottomSheetDialog sheetDialog = new BottomSheetDialog(CreateActivity.this);
        View v = LayoutInflater.from(CreateActivity.this).inflate(R.layout.bottom_sheet_remind, null);

        TextView option1 = v.findViewById(R.id.option1);
        TextView option2 = v.findViewById(R.id.option2);
        TextView option3 = v.findViewById(R.id.option3);
        TextView option4 = v.findViewById(R.id.option4);

        sheetDialog.setContentView(v);
        sheetDialog.show();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvRemind.setText("Trước 1 giờ và đúng giờ");
                binh.SaveString("REPEAT", "Trước 1 giờ và đúng giờ");
                sheetDialog.dismiss();
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvRemind.setText("Trước 1 ngày");
                binh.SaveString("REPEAT", "Trước 1 ngày");
                sheetDialog.dismiss();
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binh.SaveString("REPEAT", "Trước 1 tuần");
                tvRemind.setText("Trước 1 tuần");
                sheetDialog.dismiss();
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binh.SaveString("REPEAT", "Trước 1 tháng");
                tvRemind.setText("Trước 1 tháng");
                sheetDialog.dismiss();
            }
        });

    }


    private void pushData() {

        String title = edtTitle.getText().toString().trim();
        String description = edtDescription.getText().toString().trim();
        String category = tvCategory.getText().toString().trim();
        String date = String.valueOf(dateLong);
        String time = String.valueOf(timeLong);
        String repeat = repeatString;
        String remind = tvRemind.getText().toString().trim();
        String ring = tvRing.getText().toString().trim();
        String theme = tvWallpaper.getText().toString().trim();
        String ghim = "0";
        String status = "0";
        Event event = new Event(1, title, description, category, date, time, repeat, remind, ring, theme, ghim, status);
        dbHelper.addEventt(event);
        finish();


    }


    @Override
    public void onBackPressed() {

        showDialog(String.valueOf(getText(R.string.MessengerDialog)));
    }

    public void showDialog(String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(content)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("EXIT");
        alertDialog.show();

    }
}
