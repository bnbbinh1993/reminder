package com.example.reminder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.R;
import com.example.reminder.models.TimeStopWatch;
import com.example.reminder.utils.Binh;

import java.util.List;

public class AdapterTImeStopWatch extends RecyclerView.Adapter<AdapterTImeStopWatch.ViewHolder> {
    private Context context;
    private List<TimeStopWatch> list;
    private Binh per;

    public AdapterTImeStopWatch(Context context, List<TimeStopWatch> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_time_stop_watch,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TimeStopWatch model = list.get(position);
        holder.tvSTT.setText(String.valueOf(model.getStt()));
        holder.tvTIME.setText(model.getTime());
        holder.tvTOTALS.setText(model.getTimeTotals());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvSTT;
        private TextView tvTIME;
        private TextView tvTOTALS;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSTT = itemView.findViewById(R.id.tvSTT);
            tvTIME = itemView.findViewById(R.id.tvTIME);
            tvTOTALS = itemView.findViewById(R.id.tvTOTALS);

        }
    }
}
