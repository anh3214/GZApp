package com.example.gztruyen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.ViewHolder.BXHViewHolder;
import com.example.gztruyen.model.ChapterModel;
import com.example.gztruyen.model.ComicModel;

import java.util.List;

public class TopTruyenAdapter extends RecyclerView.Adapter<BXHViewHolder>{

    private List<ComicModel> comicList;
    public TopTruyenAdapter(List<ComicModel> comicList) {
        this.comicList = comicList;
    }


    @NonNull
    @Override
    public BXHViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bxh_holder,parent,false);
        BXHViewHolder recycleViewHolder = new BXHViewHolder(v, parent.getContext());
        return recycleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BXHViewHolder holder, int position) {
        holder.setNameTruyen(comicList.get(position));
        holder.setNumberBxh(position);

    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }
}
