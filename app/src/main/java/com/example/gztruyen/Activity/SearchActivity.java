package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gztruyen.R;
import com.example.gztruyen.adapters.RcvAdapterSearch;
import com.example.gztruyen.model.ComicModel;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView rcvSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bindingView();
        bindingACtion();

        List<ComicModel> list = fakeDataComic();

        RcvAdapterSearch adapter = new RcvAdapterSearch(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcvSearch.setAdapter(adapter);
        rcvSearch.setLayoutManager(layoutManager);
    }

    private List<ComicModel> fakeDataComic() {
        List<ComicModel> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ComicModel c = new ComicModel("12" + i, "name ne", "test des", "bac");
            list.add(c);
        }
        return list;
    }

    private void bindingACtion() {

    }

    private void bindingView() {
        rcvSearch = findViewById(R.id.rcvSearch);
    }
}