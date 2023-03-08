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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.Activity.MangaDetailActivity;
import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.Home;
import com.example.gztruyen.R;
import com.example.gztruyen.ui.truyentranh.TruyenTranhFragment;

public class TruyenChuViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView titleView;
    private LinearLayout item_truyen_line;
    private Context context;

    private void bindindView() {
        imageView = itemView.findViewById(R.id.imageView);
        titleView = itemView.findViewById(R.id.txView);
        item_truyen_line = itemView.findViewById(R.id.item_truyen_line);
    }
    private void btnItemDetail(View view) {
        Log.d("Error","Truyen Chu ne");
    }
    private void bindingAction(){
        imageView.setOnClickListener(this::onImgClick);
        item_truyen_line.setOnClickListener(this::btnItemDetail);
    }
    private void onImgClick(View view) {
        Intent i = new Intent(context, MangaDetailActivity.class);
        i.putExtra(StaticCode.getInstance().TYPE_KEY, StaticCode.getInstance().STORY);
        context.startActivity(i);
    }

    public TruyenChuViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindindView();
        bindingAction();
    }
}
