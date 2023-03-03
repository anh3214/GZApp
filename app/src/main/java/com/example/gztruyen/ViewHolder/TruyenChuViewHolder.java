package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.Home;
import com.example.gztruyen.R;
import com.example.gztruyen.ui.truyentranh.TruyenTranhFragment;

public class TruyenChuViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView titleView;
    private LinearLayout item_truyen_line;
    private Context context;

    public TruyenChuViewHolder(@NonNull View itemView,Context context) {
        super(itemView);
        this.context = context;
        imageView = itemView.findViewById(R.id.imageView);
        titleView = itemView.findViewById(R.id.txView);
        item_truyen_line = itemView.findViewById(R.id.item_truyen_line);
        item_truyen_line.setOnClickListener(this::btnItemDetail);
    }
    private void btnItemDetail(View view) {
        Intent intent = new Intent(context, Home.class);
        intent.putExtra("Mesage",titleView.getText().toString());
        Log.d("Name",titleView.getText().toString());
        context.startActivity(intent);
    }
}
