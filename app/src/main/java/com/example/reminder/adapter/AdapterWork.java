package com.example.reminder.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.R;
import com.example.reminder.models.Create;
import com.example.reminder.ui.work.ui.CountAgeActivity;
import com.example.reminder.ui.work.ui.CountDayActivity;
import com.example.reminder.ui.work.ui.CountTImeActivity;
import com.example.reminder.ui.work.ui.NoteActivity;
import com.example.reminder.ui.work.ui.StopwatchActivity;
import com.example.reminder.ui.work.ui.TimerActivity;
import com.example.reminder.utils.Binh;

import java.util.List;

public class AdapterWork extends RecyclerView.Adapter<AdapterWork.ViewHolder> {
    private Context context;
    private List<Create> list;
    private Binh per;

    public AdapterWork(Context context, List<Create> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_create,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Create model = list.get(position);
        holder.text.setText(model.getText());
        holder.image.setImageResource(model.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:{
                        context.startActivity(new Intent(context, TimerActivity.class));
                        break;
                    }
                    case 1:{
                        context.startActivity(new Intent(context, StopwatchActivity.class));
                        break;
                    }
                    case 2:{
                        context.startActivity(new Intent(context, CountTImeActivity.class));
                       break;
                    }
                    case 3:{
                        context.startActivity(new Intent(context, CountDayActivity.class));
                        break;
                    }
                    case 4:{
                        context.startActivity(new Intent(context, CountAgeActivity.class));
                        break;
                    }
                    case 5:{
                        context.startActivity(new Intent(context, NoteActivity.class));
                        break;
                    }
                    default: break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_create);
            text = itemView.findViewById(R.id.text_create);
        }
    }
}
