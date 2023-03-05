package com.example.gztruyen.ViewHolder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.Activity.ComicReading;
import com.example.gztruyen.Activity.FrmComicReading;
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
        Intent i = new Intent(context, ComicReading.class);

        Bundle bundle = new Bundle();
        bundle.putString("chapter", "1");
        i.putExtras(bundle);
        Toast.makeText(context, "u press me: " + name, Toast.LENGTH_SHORT).show();
        context.startActivity(i);
        //finish act
        Context pContext = itemView.getContext();
        if (pContext instanceof Activity) {
            ((Activity) pContext).finish();
        }
    }

    private void bindingView(View itemView) {
        tvSearchRCV = itemView.findViewById(R.id.tvSearch_rcv);
        imgComicSearch = itemView.findViewById(R.id.imgComicSearch);
    }

    public void setNameComic(ComicModel comic) {
        tvSearchRCV.setText(comic.getName());
    }
}
