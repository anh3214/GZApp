package com.example.gztruyen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.ViewHolder.ChapterViewHolder;
import com.example.gztruyen.ViewHolder.RcvViewHolderSearch;
import com.example.gztruyen.model.ChapterModel;

import java.util.List;

public class ChaptersAdapter extends RecyclerView.Adapter<ChapterViewHolder>{
    private List<ChapterModel> chapterList;

    public ChaptersAdapter(List<ChapterModel> chapterList) {
        this.chapterList = chapterList;
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
        holder.setChapter(chapterList.get(position));
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }
}
