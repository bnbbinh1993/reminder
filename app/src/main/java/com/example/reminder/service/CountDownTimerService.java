package com.example.reminder.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.reminder.MainActivity;
import com.example.reminder.R;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.models.Event;
import com.example.reminder.ui.follow.FollowFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.reminder.App.ID_AVC;

public class CountDownTimerService extends Service {
    private static final String ID = "ABC";
    private List<Event> list = new ArrayList<>();
    private MyDatabaseHelper helper;
    private ArrayList<Integer> listTime;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
    private Date endDate;
    private String dateTime = "";
    private long milliseconds = 0;
    private long startTime;
    private int result;
    private int test = 0;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        helper = new MyDatabaseHelper(getApplication());
        list = helper.getAllEvent();
        listTime = new ArrayList<>();
        simpleDateFormat.setLenient(false);
        startTime = System.currentTimeMillis();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    String date = list.get(i).getDate();
                    String time = list.get(i).getTime();
                    dateTime = date + ", " + time;
                    try {
                        endDate = simpleDateFormat.parse(dateTime);
                        milliseconds = endDate.getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    result = (int) ((milliseconds - startTime) / 1000);
                    listTime.add(result);
                    //Notification(i);

                }

                test++;


                Intent notification2  = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,notification2,0);

                Notification notification = new NotificationCompat.Builder(getApplication(),ID_AVC)
                        .setContentTitle("Bé bình thông báo")
                        .setContentText("Đây nhé bạn ơi "+test)
                        .setSmallIcon(R.drawable.ic_cake_pop)
                        .setContentIntent(pendingIntent)
                        .build();
                startForeground(1,notification);
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel = new NotificationChannel(ID,"HIHI", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(notificationChannel);
                    notificationManager.notify(1,notification);
                }


                Intent intent1 = new Intent();
                intent1.setAction("BNB");
                intent1.putIntegerArrayListExtra("BEBINH", listTime);
                sendBroadcast(intent1);
            }
        }, 0, 1000);





        return START_NOT_STICKY;
    }


    public void Notification(int i) {
        try {
            Intent notification  = new Intent(this, FollowFragment.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notification,0);
            Notification notification1 = new NotificationCompat.Builder(this,ID)
                    .setContentTitle("THông báo")
                    .setContentText("Đang ở đây nè"+i)
                    .setSmallIcon(R.drawable.ic_cake_pop)
                    .setContentIntent(pendingIntent)
                    .build();


            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                NotificationChannel notificationChannel = new NotificationChannel(ID,"HIHI", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            startForeground(1,notification1);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
