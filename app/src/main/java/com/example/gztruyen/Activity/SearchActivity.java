package com.example.gztruyen.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.CommonUltil.Common;
import com.example.gztruyen.CommonUltil.FakeData;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.RcvAdapterSearch;
import com.example.gztruyen.model.ComicModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    private TextView edtSearchComic;
    private ImageButton btnSearchComic;
    private RecyclerView rcvSearch;
    private Common common;
    private FakeData fake;
    FirebaseFirestore db;
    DatabaseReference myRef;
    private final static String TAG= "ThanhDt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bindingView();
        bindingAction();

        loadRecyclerSearch(fake.fakeDataComic());
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
        fake = new FakeData();
        edtSearchComic = findViewById(R.id.edtSearchComic);
        btnSearchComic = findViewById(R.id.btnSearchComic);
        rcvSearch = findViewById(R.id.rcvSearch);

        db = FirebaseFirestore.getInstance();

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
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