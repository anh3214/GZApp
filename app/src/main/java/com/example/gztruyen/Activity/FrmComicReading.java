package com.example.gztruyen.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.CommonUltil.FakeData;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ReadingComicAdapter;
import com.example.gztruyen.model.PageComic;

import java.util.List;

public class FrmComicReading extends Fragment {

    private RecyclerView rcvComicPage;
    private FakeData fake;

    private List<PageComic> pages;
    private Bundle bundle;
    private String chap;
    private Integer mChap;

    public FrmComicReading() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frm_comic_reading, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindingView(view);
        bindingAction(view);

        List<PageComic> list = mChap % 2 == 0 ?
                fake.fakeListPageComic() :
                fake.fakeListNextPageComic();

        ReadingComicAdapter adapter = new ReadingComicAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        rcvComicPage.setAdapter(adapter);
        rcvComicPage.setLayoutManager(layoutManager);
    }

    private void bindingAction(View view) {

    }

    private void bindingView(View view) {
        fake = new FakeData();
        bundle = getArguments();
        if (bundle != null) {
            chap = bundle.getString("chapter");
            mChap = Integer.parseInt(chap);
        }
        rcvComicPage = view.findViewById(R.id.rcv_read_comic);
    }
}