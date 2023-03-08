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
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.model.DocumentChap;

import java.util.ArrayList;
import java.util.List;


public class ChaptersFragment extends Fragment {

    private RecyclerView rcvChapters;

    private Context context;


    private void bindingView(View view){
        rcvChapters = view.findViewById(R.id.rcvChapters);
    }

    private void bindingAction(View view){

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
        View rootView = inflater.inflate(R.layout.fragment_chapters, container, false);
        bindingView(rootView);
        bindingAction(rootView);

        ChaptersAdapter adapter = new ChaptersAdapter(new ArrayList<>());
        adapter.setChapterList(getAllChapter(adapter));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        rcvChapters.setAdapter(adapter);
        rcvChapters.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
        return rootView;
    }

    private List<DocumentChap> getAllChapter(ChaptersAdapter adapter){
        List<DocumentChap> allChap = FireStoreApi.getAllChap(adapter);
        return allChap;
    }
}