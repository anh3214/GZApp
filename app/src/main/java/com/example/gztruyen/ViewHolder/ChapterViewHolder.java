package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.model.ChapterModel;

public class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvChapter;

    private Context context;

    private void bindingView(View itemView){
        tvChapter = itemView.findViewById(R.id.tvChapter);
    }

    private void bindingAction(View itemView){

    }

    public ChapterViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView(itemView);
        bindingAction(itemView);
    }

    public void setChapter(ChapterModel chapter){
        tvChapter.setText(chapter.getTitle());
    }

    @Override
    public void onClick(View v) {

    }
}
