package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.model.ComicModel;

public class RcvViewHolderSearch extends RecyclerView.ViewHolder {

    private Context context;
    private TextView tvSearchRCV;
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
        String name = tvSearchRCV.getText().toString();
        Toast.makeText(context, "u press me: " + name, Toast.LENGTH_SHORT).show();
    }

    private void bindingView(View itemView) {
        tvSearchRCV = itemView.findViewById(R.id.tvSearch_rcv);
        imgComicSearch = itemView.findViewById(R.id.imgComicSearch);
    }

    public void setNameComic(ComicModel comic) {
        tvSearchRCV.setText(comic.getName());
    }
}
