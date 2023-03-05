package com.example.gztruyen.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gztruyen.CommonUltil.Common;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.RcvAdapterSearch;
import com.example.gztruyen.model.ComicModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private TextView edtSearchComic;
    private ImageButton btnSearchComic;
    private RecyclerView rcvSearch;
    private Common common;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Object> listTest;

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
        return list;
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

        listTest = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 String a = snapshot.getValue(String.class);
                 Log.d("thanhdt", a);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        for (Object o :
                listTest) {
            Log.d("thanhdt", o.toString());
        }
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