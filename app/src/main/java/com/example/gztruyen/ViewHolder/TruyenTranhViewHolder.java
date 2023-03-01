package com.example.gztruyen.ViewHolder;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.Activity.MangaDetailActivity;
import com.example.gztruyen.R;

public class TruyenTranhViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView titleView;
    private Context context;
    
    private void bindindView(){
        imageView = itemView.findViewById(R.id.imageView);
        titleView = itemView.findViewById(R.id.txView);
    }
    private void bindingAction(){
        imageView.setOnClickListener(this::onImgClick);
    }

    private void onImgClick(View view) {
        Intent i = new Intent(context, MangaDetailActivity.class);
        context.startActivity(i);
        Toast.makeText(context, "done", Toast.LENGTH_SHORT).show();
    }


    public TruyenTranhViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindindView();
        bindingAction();
    }
}
