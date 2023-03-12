package com.example.gztruyen.adapters.ComonAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.ViewHolder.ReadingComicViewHolder;

import java.util.List;

public class ReadingComicAdapter extends RecyclerView.Adapter<ReadingComicViewHolder>{

    private List<String> listItem;

    public ReadingComicAdapter(List<String> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ReadingComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reading_page_comic, parent, false);
        ReadingComicViewHolder viewHolder = new ReadingComicViewHolder(v, parent.getContext());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReadingComicViewHolder holder, int position) {
        String pageComic = listItem.get(position);
        holder.setDataPage(pageComic);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void updateAdapter(List<String> list){
        this.listItem = list;
        notifyDataSetChanged();
    }
}
