package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.Activity.ComicReading;
import com.example.gztruyen.Activity.StoryReading;
import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.R;
import com.example.gztruyen.model.DocumentChap;

public class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvChapter;
    private Context context;
    private DocumentChap a1;
    private String type;
    private Integer totalChaps;
    private String nameComicApi;

    private void bindingView(View itemView) {
        tvChapter = itemView.findViewById(R.id.tvChapter);
    }

    private void bindingAction(View itemView) {
        tvChapter.setOnClickListener(this::readMangaChapter);
    }

    private String contentChap = "";

    public void setChapterViewHolder(DocumentChap chapter) {
        a1 = chapter;
        tvChapter.setText(chapter.getFields().getTitle().getStringValue());
        if (chapter.getFields().getChapContent() != null) {
            contentChap = chapter.getFields().getChapContent().getStringValue();
        }
    }

    public ChapterViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView(itemView);
        bindingAction(itemView);
    }

    public void setChapterViewHolder(DocumentChap chapter, String nameComicApi) {
        tvChapter.setText(chapter.getFields().getTitle().getStringValue());
        this.nameComicApi = nameComicApi;
    }

    @Override
    public void onClick(View v) {

    }

    public void bindData(int value) {
        totalChaps = value;
    }

    private void readMangaChapter(View view) {
        Integer allChaps = totalChaps;
        String chapter = tvChapter.getText().toString();
        Intent i = new Intent(context, ComicReading.class);
        Bundle bundle = new Bundle();
        String a = chapter.substring(chapter.length() - 1, chapter.length());
        bundle.putString(StaticCode.getInstance().getCHAPTER_KEY(), a);
        bundle.putString(StaticCode.NUM_OF_CHAPS, allChaps.toString());
        bundle.putString(StaticCode.COMIC_NAME_API, nameComicApi);
        i.putExtras(bundle);
        context.startActivity(i);
    }
}
