package com.example.gztruyen.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ChaptersAdapter;
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.model.DocumentChap;

import java.util.ArrayList;
import java.util.List;

public class FrmStoryReading extends Fragment {

    private static FrmStoryReading frm;

    public static FrmStoryReading getInstance() {
        if (frm == null)
            frm = new FrmStoryReading();
        return frm;
    }

    private TextView tvTitle;
    private TextView tvContent;


    private Context context;


    public FrmStoryReading() {
    }
    private static FrmStoryReading instance;
    public static FrmStoryReading getInstances(){
        if(instance == null)
            instance = new FrmStoryReading();
        return instance;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frm_story_reading, container, false);
    }
    public void setChapter(DocumentChap chapter){
        tvTitle.setText(chapter.getFields().getTitle().getStringValue());
        tvContent.setText(chapter.getFields().getChapContent().getStringValue());
    }
   private String nameChap;
    private String nameTitle;
    String type;
    String name;
    String nameChapter;
    String contentChap;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView(view);
        bindingAction(view);
        Bundle b = instance.getArguments();
        nameChap = b.getString("name");
        nameTitle = b.getString("nameTitle");
        contentChap = b.getString("contentChap");

        tvTitle.setText(nameTitle);
        tvContent.setMovementMethod(new ScrollingMovementMethod());
        tvContent.setText(contentChap);

    }


    private void bindingAction(View view) {

    }
    private void bindingView(View view) {

        tvTitle = view.findViewById(R.id.tvTitle);
        tvContent = view.findViewById(R.id.tvContent);
        context = view.getContext();

    }

}