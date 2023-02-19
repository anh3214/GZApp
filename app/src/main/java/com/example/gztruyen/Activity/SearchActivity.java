package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gztruyen.CommonUltil.Common;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.RcvAdapterSearch;
import com.example.gztruyen.model.ComicModel;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private TextView edtSearchComic;
    private ImageButton btnSearchComic;
    private RecyclerView rcvSearch;

    private Common common;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bindingView();
        bindingAction();

        loadRecyclerSearch(fakeDataComic());
    }

    private List<ComicModel> fakeDataComic() {
        List<ComicModel> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ComicModel c = new ComicModel("12" + i, "name ne", "test des", "bac");
            list.add(c);
        }
        return list;
    }

    private void bindingAction() {
        btnSearchComic.setOnClickListener(this::searchEveryComic);
    }

    private void searchEveryComic(View view) {
        String search = edtSearchComic.getText().toString();
        if(search.isEmpty()){
            Toast.makeText(this, "give me something to see first", Toast.LENGTH_SHORT).show();
        }else {
            common.hideKeyboard(this, view);
        }
    }

    private void bindingView() {
        common = new Common();
        edtSearchComic = findViewById(R.id.edtSearchComic);
        btnSearchComic = findViewById(R.id.btnSearchComic);
        rcvSearch = findViewById(R.id.rcvSearch);
    }

    private void loadRecyclerSearch(List<ComicModel> list){
        RcvAdapterSearch adapter = new RcvAdapterSearch(list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        rcvSearch.setAdapter(adapter);
        rcvSearch.setLayoutManager(layoutManager);
    }


}