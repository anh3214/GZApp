package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gztruyen.CommonUltil.Common;
import com.example.gztruyen.CommonUltil.FakeData;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ComonAdapter.RcvAdapterSearch;
import com.example.gztruyen.model.ComicModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private TextView edtSearchComic;
    private ImageButton btnSearchComic;
    private RecyclerView rcvSearch;
    private Common common;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bindingView();
        bindingAction();

        loadRecyclerSearch(FakeData.getInstance().fakeDataComic());
    }

    private void bindingAction() {
        btnSearchComic.setOnClickListener(this::searchEveryComic);
        edtSearchComic.setOnKeyListener(this::pressOk);
    }

    private boolean pressOk(View view, int i, KeyEvent keyEvent) {
        if(keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
            searchComic(view);
            return true;
        }
        return false;
    }

    private void searchEveryComic(View view) {
        searchComic(view);
    }

    private void bindingView() {
        common = new Common();
        edtSearchComic = findViewById(R.id.edtSearchComic);
        btnSearchComic = findViewById(R.id.btnSearchComic);
        rcvSearch = findViewById(R.id.rcvSearch);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("/comic/wvEf5hR6QQFuCwxTvYBC/id_comic");
    }

    private void loadRecyclerSearch(List<ComicModel> list){
        RcvAdapterSearch adapter = new RcvAdapterSearch(list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        rcvSearch.setAdapter(adapter);
        rcvSearch.setLayoutManager(layoutManager);
    }

    private void searchComic(View view){
        String search = edtSearchComic.getText().toString();
        if(common.checkStringEmpty(search)){
            Toast.makeText(this, "give me something to see first", Toast.LENGTH_SHORT).show();
        }else {
            common.hideKeyboard(this, view);
//            finish();
        }
    }
}