package com.example.gztruyen.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ChaptersAdapter;
import com.example.gztruyen.model.ChapterModel;

import java.util.ArrayList;
import java.util.List;


public class ChaptersFragment extends Fragment {

    private RecyclerView rcvChapters;

    private Context context;

    private void bindingView(ViewGroup container){
        rcvChapters = container.findViewById(R.id.rcvChapters);
    }

    private void bindingAction(ViewGroup container){

    }

    public ChaptersFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<ChapterModel> chapterlist = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            chapterlist.add(new ChapterModel(0L, "Chapter " + i, "", true));
        }
        ChaptersAdapter adapter = new ChaptersAdapter(chapterlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context);
        rcvChapters.setAdapter(adapter);
        rcvChapters.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chapters, container, false);
    }
}