package com.example.reminder.adapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.R;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.models.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdapterEvent extends RecyclerView.Adapter<AdapterEvent.ViewHolder> {
    private Context context;
    private List<Event> list;


    public AdapterEvent(Context context, List<Event> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_event, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Event model = list.get(position);
        int repeat = Integer.parseInt(model.getRepeat());
        String status = model.getStatus();
        String time = model.getTime();
        String date = model.getDate();
        String category = model.getCategory();
        String dateTime = date + ", " + time;
        long milliseconds = 0;
        long startTime = 0;
        long result;

        MyDatabaseHelper helper = new MyDatabaseHelper(context);



        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
        simpleDateFormat.setLenient(false);
        Date endDate;
        try {
            endDate = simpleDateFormat.parse(dateTime);
            milliseconds = endDate.getTime();

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();


        result = (milliseconds - startTime)/1000;
       if (result>0){
           String daysLeft = String.format("%d", result / 86400);
           String hoursLeft = String.format("%d", (result % 86400) / 3600);
           String minutesLeft = String.format("%d", ((result % 86400) % 3600) / 60);
           String secondsLeft = String.format("%d", ((result % 86400) % 3600) % 60);

           holder.statusId.setText(daysLeft + " ngày " + hoursLeft + " giờ " + minutesLeft + " phút " + secondsLeft+" giây");
       }else {
           Calendar calendar =Calendar.getInstance();
           int day = calendar.get(Calendar.DAY_OF_MONTH);
           int month = calendar.get(Calendar.MONTH)+1;
           int year = calendar.get(Calendar.YEAR);
           String check = day+"."+month+"."+year;

           if (model.getDate().equals(check)){
               if (model.getStatus().equals("0")){
                   Event event = new Event();
                   event.setStatus("1");
                   event.setId(model.getId());
                   helper.Update(event);
               }
               holder.statusId.setText("Đang diễn ra");
           }else {
               if (model.getStatus().equals("1")){
                   Event event = new Event();
                   event.setStatus("2");
                   event.setId(model.getId());
                   helper.Update(event);
               }
               holder.statusId.setText("Đã hoàn thành");
           }

       }


        holder.nameEvent.setText(model.getTitle());

        switch (repeat) {
            case 0: {
                holder.timeEvent.setText(model.getTime() + " - " + model.getDate());
                break;
            }
            case 1: {
                holder.timeEvent.setText("Hằng ngày, " + model.getTime() + " - " + model.getDate());
                break;
            }
            case 2: {
                holder.timeEvent.setText("Hằng tuần, " + model.getTime() + " - " + model.getDate());
                break;
            }
            case 3: {
                holder.timeEvent.setText("Hằng tháng, " + model.getTime() + " - " + model.getDate());
                break;
            }
            case 4: {
                holder.timeEvent.setText("Hằng năm, " + model.getTime() + " - " + model.getDate());
                break;
            }
            default:
                break;
        }


        switch (category){
            case "Sinh nhật":{
                holder.icon_category.setImageResource(R.drawable.ic_cake_pop);
                break;
            }
            case "Sự kiện":{
                holder.icon_category.setImageResource(R.drawable.ic_calendar);
                break;
            }
            case "Tình yêu":{
                holder.icon_category.setImageResource(R.drawable.ic_heart);
                break;
            }
            case "Công việc":{
                holder.icon_category.setImageResource(R.drawable.ic_work_black_24dp);
                break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameEvent;
        private TextView timeEvent;
        private TextView statusId;
        private ImageView icon_category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameEvent = itemView.findViewById(R.id.nameEvent);
            statusId = itemView.findViewById(R.id.statusId);
            timeEvent = itemView.findViewById(R.id.timeEvent);
            icon_category = itemView.findViewById(R.id.icon_category);

        }
    }
}
