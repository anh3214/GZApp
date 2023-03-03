package com.example.gztruyen.ViewHolder;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
