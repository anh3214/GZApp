package com.example.gztruyen.ViewHolder;


import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;

public class TruyenTranhViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView titleView;

    private LinearLayout item_truyen_line;

    public TruyenTranhViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        titleView = itemView.findViewById(R.id.txView);
        item_truyen_line = itemView.findViewById(R.id.item_truyen_line);
        item_truyen_line.setOnClickListener(this::btnItemDetail);
    }
    private void btnItemDetail(View view) {
        Log.d("Error","Truyen Tranh ne");
    }
}
