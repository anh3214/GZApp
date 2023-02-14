package com.example.gztruyen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.ViewHolder.RcvViewHolderSearch;
import com.example.gztruyen.model.ComicModel;

import java.util.List;

public class RcvAdapterSearch extends RecyclerView.Adapter<RcvViewHolderSearch> {

    private List<ComicModel> list;

    public RcvAdapterSearch(List<ComicModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RcvViewHolderSearch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_search, parent, false);
        RcvViewHolderSearch viewHolder = new RcvViewHolderSearch(v, parent.getContext());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RcvViewHolderSearch holder, int position) {
        holder.setNameComic("name here");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
