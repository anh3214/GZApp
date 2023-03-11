package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ComicReading extends AppCompatActivity {

    private Button btnPrev;
    private Button btnSave;
    private Button btnNext;
    String name;
    String size;
    String comicNameApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_reading);

        bindingView();
        bindingAction();
    }

    private void bindingView() {
        btnPrev = findViewById(R.id.btnPrev);
        btnSave = findViewById(R.id.btnSave);
        btnNext = findViewById(R.id.btnNext);

        Bundle b = getIntent().getExtras();
        name = b.getString(StaticCode.getInstance().getCHAPTER_KEY());
        size = b.getString(StaticCode.NUM_OF_CHAPS);
        comicNameApi = b.getString(StaticCode.COMIC_NAME_API);

        FrmComicReading fragobj = new FrmComicReading();
        fragobj.setArguments(b);

        Fragment myFragment = new FrmComicReading();
        myFragment.setArguments(b);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frmComicReading, myFragment)
                .disallowAddToBackStack()
                .commitNow();
    }

    private void bindingAction() {
        btnPrev.setOnClickListener(this::comeBackPreviousChapter);
        btnSave.setOnClickListener(this::saveLater);
        btnNext.setOnClickListener(this::comeNextChapter);
    }

    private void comeNextChapter(View view) {
        Bundle b = getIntent().getExtras();
        String chap = b.getString(StaticCode.getInstance().getCHAPTER_KEY());
        int c = Integer.parseInt(chap);
        int max = Integer.parseInt(b.getString(StaticCode.NUM_OF_CHAPS));
        if (c < max) {
            String a = b.getString(StaticCode.COMIC_NAME_API);
            String path = a.substring(0, a.length() - 1);
            path += (c + 1);
            b.putString(StaticCode.getInstance().getCHAPTER_KEY(), (c + 1) + "");
            b.putString(StaticCode.COMIC_NAME_API, path);
            Intent intent = new Intent(this, ComicReading.class);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "No more to read", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveLater(View view) {

    }

    private void comeBackPreviousChapter(View view) {
        Bundle b = getIntent().getExtras();
        String chap = b.getString(StaticCode.getInstance().getCHAPTER_KEY());
        int c = Integer.parseInt(chap);
        if (c == 1) {
            Toast.makeText(this, "No previous chapter to load", Toast.LENGTH_SHORT).show();
            return;
        }
        String a = b.getString(StaticCode.COMIC_NAME_API);
        String path = a.substring(0, a.length() - 1);
        path += (c - 1);
        b.putString(StaticCode.getInstance().getCHAPTER_KEY(), (c - 1) + "");
        b.putString(StaticCode.COMIC_NAME_API, path);
        Intent intent = new Intent(this, ComicReading.class);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
}