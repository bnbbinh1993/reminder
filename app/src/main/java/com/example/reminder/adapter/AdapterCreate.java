package com.example.reminder.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminder.R;
import com.example.reminder.models.Create;
import com.example.reminder.ui.create.CreateActivity;
import com.example.reminder.utils.Pef;

import java.util.List;

public class AdapterCreate extends RecyclerView.Adapter<AdapterCreate.ViewHolder> {
    private Context context;
    private List<Create> list;
    private Pef per;

    public AdapterCreate(Context context, List<Create> list) {
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
                Toast.makeText(context, "Hello world!", Toast.LENGTH_SHORT).show();

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
