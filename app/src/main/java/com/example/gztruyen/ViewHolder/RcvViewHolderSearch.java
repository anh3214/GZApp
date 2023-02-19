package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;

public class RcvViewHolderSearch extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    private TextView tvSearch;
    private ImageView imgComicSearch;

    public RcvViewHolderSearch(@NonNull View itemView, Context context) {
        super(itemView);
        bindingView(itemView);
        bindingAction(itemView);
        this.context = context;
    }

    private void bindingAction(View itemView) {
        imgComicSearch.setOnClickListener(this::clickOnSearchImg);
    }

    private void clickOnSearchImg(View view) {
        Toast.makeText(context, "u press me", Toast.LENGTH_SHORT).show();
    }

    private void bindingView(View itemView) {
        tvSearch = itemView.findViewById(R.id.tvSearch);
        imgComicSearch = itemView.findViewById(R.id.imgComicSearch);
    }

    public void setNameComic(String name_here) {
        tvSearch.setText(name_here);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "amen", Toast.LENGTH_SHORT).show();
    }
}
