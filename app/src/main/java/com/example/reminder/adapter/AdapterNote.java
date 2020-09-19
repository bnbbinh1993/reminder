package com.example.reminder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.R;
import com.example.reminder.models.Event;
import com.example.reminder.models.Note;

import java.util.List;

public class AdapterNote extends RecyclerView.Adapter<AdapterNote.ViewHolder> {
    private Context context;
    private List<Note> list;


    public AdapterNote(Context context, List<Note> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Note model = list.get(position);
        holder.note.setText(model.getNote());
        holder.date.setText(model.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView note;
        private TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            note = itemView.findViewById(R.id.textNoteId);
            date = itemView.findViewById(R.id.textDateNote);

        }
    }
}
