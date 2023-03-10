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
import com.example.gztruyen.Activity.MangaDetailActivity;
import com.example.gztruyen.Activity.StoryReading;
import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.R;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.DocumentChap;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvChapter;

    private Context context;
    private DocumentChap a1;
    private String type;


    private void bindingView(View itemView){
        tvChapter = itemView.findViewById(R.id.tvChapter);
    }

    private void bindingAction(View itemView) {

        tvChapter.setOnClickListener(this::readMangaChapter);
    }
    private String contentChap = "";
    public void setChapter(DocumentChap chapter){
        a1 = chapter;
        tvChapter.setText(chapter.getFields().getTitle().getStringValue());

        contentChap = chapter.getFields().getChapContent().getStringValue().toString();
    }
    public ChapterViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindingView(itemView);
        bindingAction(itemView);
    }



    @Override
    public void onClick(View v) {

    }

    private void readMangaChapter(View view) {

        String name = a1.getName();
        String[] strArr = name.split("/");
        String reversedStr = "";
        for (int i = strArr.length - 1; i >= 0; i--) {
            reversedStr += strArr[i];
            if (i != 0) {
                reversedStr += "/";
            }
        }
        String str = reversedStr;
        String[] reverseList = str.split("/");
        type = reverseList[3];

        if(type.equalsIgnoreCase(StaticCode.STORY)){
            Log.d("thanhdt", contentChap);
            Intent i = new Intent(context, StoryReading.class);
            i.putExtra("name", name);
            i.putExtra("nameTitle", tvChapter.getText());
            i.putExtra("contentChap", contentChap);
            context.startActivity(i);
            Log.d("thanhdt", a1.toString());
            Toast.makeText(context, "u press me " + tvChapter.getText(), Toast.LENGTH_SHORT).show();
        } else {
            String chapter = tvChapter.getText().toString();
            Intent i = new Intent(context, ComicReading.class);
            Bundle bundle = new Bundle();
            String a = chapter.substring(chapter.length() - 1, chapter.length());
            bundle.putString(StaticCode.getInstance().getCHAPTER_KEY(), a);
            i.putExtras(bundle);
            context.startActivity(i);
        }

    }

}
