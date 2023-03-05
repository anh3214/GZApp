package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.R;
import com.example.gztruyen.model.PageComic;
import com.squareup.picasso.Picasso;

public class ReadingComicViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgPageComic;
    private Context context;
    public ReadingComicViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        bindingView(itemView);
        bindingAction(itemView);
        this.context = context;
    }

    private void bindingAction(View itemView) {

    }

    private void bindingView(View itemView) {
        imgPageComic = itemView.findViewById(R.id.imgPageComic);
    }

    public void setDataPage(PageComic pageComic) {
        Picasso.get()
                .load(pageComic.getUrlImg())
                .placeholder(R.drawable.img_loading_img)
                .error(R.drawable.img_err_img)
                .into(imgPageComic);
    }
}
