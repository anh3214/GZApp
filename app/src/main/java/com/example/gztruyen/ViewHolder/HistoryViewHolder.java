package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.model.ChapterModel;

public class HistoryViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgMangaHistory;
    private TextView tvNameHistory;
    private TextView tvCreateTimeHistory;

    private Context context;

    private void bindingView(View itemView){
        imgMangaHistory = itemView.findViewById(R.id.imgMangaHistory);
        tvNameHistory = itemView.findViewById(R.id.tvNameHistory);
        tvCreateTimeHistory = itemView.findViewById(R.id.tvCreateTimeHistory);
    }

    private void bindingAction(View itemView){

    }

    public HistoryViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView(itemView);
        bindingAction(itemView);
    }

    public void setMangaHistory(ChapterModel chapterModel){
        imgMangaHistory.setImageResource(Integer.parseInt(chapterModel.getImage()));
        tvNameHistory.setText(chapterModel.getName());
        tvCreateTimeHistory.setText(chapterModel.getCreateTime());
    }
}
