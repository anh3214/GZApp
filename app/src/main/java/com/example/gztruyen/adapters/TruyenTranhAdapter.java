package com.example.gztruyen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.ViewHolder.TruyenTranhViewHolder;
import com.example.gztruyen.model.ComicModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TruyenTranhAdapter extends RecyclerView.Adapter<TruyenTranhViewHolder> {
    private List<ComicModel> mList;

    public TruyenTranhAdapter(List<ComicModel> mList) {
        this.mList = mList;
    }

    public TruyenTranhAdapter() {
    }

    public void updateData(List<ComicModel> data) {
        this.mList = data;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TruyenTranhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder,parent,false);
        return new TruyenTranhViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull TruyenTranhViewHolder holder, int position) {
        ComicModel comicModel = mList.get(position);
        if(comicModel == null){
            return;
        }

        //Picasso.get().load(comicModel.getImage()).into( holder.imageView);
        holder.titleView.setText(comicModel.getFields().getTitle().getStringValue());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
