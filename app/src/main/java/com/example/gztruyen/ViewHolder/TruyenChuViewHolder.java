package com.example.gztruyen.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;

public class TruyenChuViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView titleView;

    public TruyenChuViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        titleView = itemView.findViewById(R.id.txView);
    }
}
