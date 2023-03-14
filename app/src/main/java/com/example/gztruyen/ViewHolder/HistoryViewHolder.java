package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.adapters.HistoryAdapter;
import com.example.gztruyen.model.ChapterModel;

public class HistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvNameHistory;
    private TextView tvCreateTimeHistory;
    private HistoryAdapter.ItemClickListener itemClickListener;


    private Context context;

    private void bindingView(View itemView){
        tvNameHistory = itemView.findViewById(R.id.tvNameHistory);
        tvCreateTimeHistory = itemView.findViewById(R.id.tvCreateTimeHistory);
    }

    private void bindingAction(View itemView){
        itemView.setOnClickListener(this);
    }

    public HistoryViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView(itemView);
        bindingAction(itemView);
    }

    public void setMangaHistory(ChapterModel chapterModel){
        tvNameHistory.setText(formatString(chapterModel.getName()));
        tvCreateTimeHistory.setText(chapterModel.getCreateTime());
    }

    private String formatString(String string){
        if(string.length() > 7){
            string = string.substring(0,6) + "...";
        }
        else{
            while(string.length() <= 8){
                string = string + " ";
            }
        }
        return string;
    }

    public void setItemClickListener(HistoryAdapter.ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}
