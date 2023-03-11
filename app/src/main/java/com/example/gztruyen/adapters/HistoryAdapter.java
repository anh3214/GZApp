package com.example.gztruyen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.ViewHolder.HistoryViewHolder;
import com.example.gztruyen.model.ChapterModel;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {
    List<ChapterModel> chapHistories;

    public HistoryAdapter(List<ChapterModel> chapHistories) {
        this.chapHistories = chapHistories;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_history_holder, parent, false);
        HistoryViewHolder historyViewHolder = new HistoryViewHolder(v,parent.getContext());
        return historyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.setMangaHistory(chapHistories.get(position));
    }

    @Override
    public int getItemCount() {
        return chapHistories.size();
    }
}
