package com.example.gztruyen.ViewHolder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gztruyen.R;
import com.example.gztruyen.model.ChapterModel;
import com.example.gztruyen.model.ComicModel;

public class BXHViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView nameTruyen;

    private TextView numberBxh;
    public ImageView imageViewBXH;
    private Context context;

    private void bindingView(View itemView){
        nameTruyen = itemView.findViewById(R.id.nameTruyen);
        numberBxh = itemView.findViewById(R.id.numberBxh);
        imageViewBXH = itemView.findViewById(R.id.imageView2);

    }

    private void bindingAction(View itemView){

    }

    public BXHViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView(itemView);
        bindingAction(itemView);
    }

    public void setNameTruyen(ComicModel comic){
        nameTruyen.setText(comic.getFields().getTitle().getStringValue());
    }
    public void setNumberBxh(int number){numberBxh.setText(number+1 + "");}

    @Override
    public void onClick(View v) {

    }
}