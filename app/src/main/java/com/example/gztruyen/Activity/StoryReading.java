package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.gztruyen.R;

public class StoryReading extends AppCompatActivity {

    private Button btnPrev;
    private Button btnSave;
    private Button btnNext;
    private String nameChap;

    private String nameTitle;
    private String contentChap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_reading);
        bindingView();
        bindingAction();
    }

    private void bindingAction() {
    }

    private void bindingView() {
        Intent i = getIntent();
        nameChap = i.getStringExtra("name");
        nameTitle = i.getStringExtra("nameTitle");
        contentChap = i.getStringExtra("contentChap");
        Log.d("name", nameChap);

        Bundle b = new Bundle();
        b.putString("name", nameChap);
        b.putString("nameTitle", nameTitle);
        b.putString("contentChap", contentChap);
        FrmStoryReading frmStoryReading = FrmStoryReading.getInstances();
        frmStoryReading.setArguments(b);
    }
}