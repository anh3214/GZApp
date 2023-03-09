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
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopTruyenAdapter extends RecyclerView.Adapter<BXHViewHolder>{

    private List<ComicModel> comicList;
    public  TopTruyenAdapter(){

    }
    public TopTruyenAdapter(List<ComicModel> comicList) {
        this.comicList = comicList;
    }

    public void updateData(List<ComicModel> data) {
        this.comicList = data;
        if(data != null){
            notifyDataSetChanged();
        }
    }

    public void updateUrl(List<String> url,String name){
        for (ComicModel comic: this.comicList) {
            if(comic.getName().equals(name)){
                comic.setAvatar(url);
            }
        }
        notifyDataSetChanged();
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
        ComicModel comicModel = comicList.get(position);

        if(comicModel == null){
            return;
        }
        if(comicModel.getAvatar() != null){
            for (String url : comicModel.getAvatar()) {
                Picasso.get()
                        .load(url)
                        .fit()
                        .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                        .centerCrop()
                        .into(holder.imageViewBXH);
            }
        }
        holder.setNameTruyen(comicModel);
        holder.setNumberBxh(position);

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }
}
