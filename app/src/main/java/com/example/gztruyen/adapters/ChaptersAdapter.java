package com.example.gztruyen.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.ViewHolder.ChapterViewHolder;
import com.example.gztruyen.model.DocumentChap;

import java.util.List;

public class ChaptersAdapter extends RecyclerView.Adapter<ChapterViewHolder>{
    private List<DocumentChap> chapterList;
    private Integer totalChapAdepter;
    private ChapSize chapSize;

    public ChaptersAdapter() {
    }

    public ChaptersAdapter(Integer totalChapAdepter, ChapSize chapSize) {
        this.totalChapAdepter = totalChapAdepter;
        this.chapSize = chapSize;
    }

    public void setChapSize(ChapSize chapSize) {
        this.chapSize = chapSize;
    }

    public ChaptersAdapter(List<DocumentChap> chapterList) {
        this.chapterList = chapterList;
    }

    public void setChapterList(List<DocumentChap> chapterList) {
        Log.d("DataAffterAdapter",""+chapterList.size());
        this.chapterList = chapterList;
        if(chapterList.size() > 0){
            notifyDataSetChanged();
        }
    }

    public void setTotalChap(Integer totalChap) {
        Log.d("DataAffter1",""+totalChap);
        this.totalChapAdepter = totalChap;
        if(totalChap > 0){
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
            holder.setChapter(chapterList.get(position),
                    chapterList.get(position).getFields().getImage().getReferenceValue());
            holder.bindData(chapterList.size());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (chapSize != null) {
                        chapSize.onChapSizeReceived(chapterList.size());
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public interface ChapSize {
        Integer onChapSizeReceived(Integer size);
    }
}


