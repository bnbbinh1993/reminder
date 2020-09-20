package com.example.reminder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.reminder.utils.Binh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Bebinh extends Activity {

    TextView tv;
    long diff;
    long oldLong;
    long NewLong;

    public Bebinh(Context context){
        //contructect
    }
    public Bebinh(Context context,long t1,long t2){
        this.NewLong = t1;
        this.oldLong = t2;
    }
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        this.setContentView(tv);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
        String oldTime = "19.02.2018, 12:00";//Timer date 1
        String NewTime = "20.02.2018, 14:00";//Timer date 2
        Date oldDate, newDate;
        try {
            oldDate = formatter.parse(oldTime);
            newDate = formatter.parse(NewTime);
            oldLong = oldDate.getTime();
            NewLong = newDate.getTime();
            diff = NewLong - oldLong;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MyCount counter = new MyCount(diff, 1000);
        counter.start();
    }


    // countdowntimer is an abstract class, so extend it and fill in methods
    public class MyCount extends CountDownTimer {
        MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            tv.setText("done!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = (TimeUnit.MILLISECONDS.toDays(millis)) + "Day "
                    + (TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)) + ":")
                    + (TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)) + ":"
                    + (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
            tv.setText(/*context.getString(R.string.ends_in) + " " +*/ hms);


        }
    }

    /*
    *  CountDownTimer countDownTimer = new CountDownTimer(milliseconds, 1000) {
            @Override
            public void onTick(long l) {
                Long serverUptimeSeconds = (l - finalStartTime) / 1000;
                String daysLeft = String.format("%d", serverUptimeSeconds / 86400);
                //txtViewDays.setText(daysLeft);

                String hoursLeft = String.format("%d", (serverUptimeSeconds % 86400) / 3600);
                //txtViewHours.setText(hoursLeft);

                String minutesLeft = String.format("%d", ((serverUptimeSeconds % 86400) % 3600) / 60);
                //txtViewMinutes.setText(minutesLeft);

                String secondsLeft = String.format("%d", ((serverUptimeSeconds % 86400) % 3600) % 60);
                // txtViewSecond.setText(secondsLeft);
                holder.statusId.setText(daysLeft + " ngày " + hoursLeft + " giờ " + minutesLeft + " phút " + secondsLeft);
            }

            @Override
            public void onFinish() {
            }
        }.start();
    *
    * */

}