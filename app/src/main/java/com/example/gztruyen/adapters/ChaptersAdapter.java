package com.example.gztruyen.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.ViewHolder.ChapterViewHolder;
import com.example.gztruyen.model.Chap;
import com.example.gztruyen.model.DocumentChap;

import java.util.List;

public class ChaptersAdapter extends RecyclerView.Adapter<ChapterViewHolder>{
    private List<DocumentChap> chapterList;

    public ChaptersAdapter() {
    }

    public ChaptersAdapter(List<DocumentChap> chapterList) {
        this.chapterList = chapterList;
    }

    public void setChapterList(List<DocumentChap> chapterList) {
        Log.d("DataAffter",""+chapterList.size());this.chapterList = chapterList;
        if(chapterList.size() > 0){
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_holder,parent,false);
        ChapterViewHolder recycleViewHolder = new ChapterViewHolder(v, parent.getContext());
        return recycleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        if(chapterList.size() == 0){
            Log.d("Error","Nullll");
            return;
        }else {
            holder.setChapter(chapterList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }
}
