package com.example.gztruyen.Activity.readingActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.R;
import com.example.gztruyen.fragment.truyenchu.FrmStoryReading;

import java.util.ArrayList;

public class StoryReading extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextView tvTitle;
    private Button btnTTS;
    private  Button btnTTSStop;
    TextToSpeech toSpeech;
    int MY_DATA_CHECK_CODE = 10000;
    int maxLength = 3500;

    private Button btnPrev;

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

        btnTTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = contentChap;
                ArrayList<String> chunks = new ArrayList<String>();
                for (int i = 0; i < text.length(); i += maxLength) {
                    chunks.add(text.substring(i, Math.min(i + maxLength, text.length())));
                }
                if(text.length() >0){
                    toSpeech.speak(text, TextToSpeech.QUEUE_ADD,null);
                }
                for(String chunk : chunks) {
                    if (chunk.length() > 0) {
                        chunk.replace("-", "");
                        toSpeech.speak(chunk, TextToSpeech.QUEUE_ADD, null);
                    }
                }
            }
        });
        Intent intent = new Intent();
        intent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(intent, MY_DATA_CHECK_CODE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                toSpeech = new TextToSpeech( this,  this);
            } else{
                Intent intent = new Intent();
                intent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivity(intent);
            }
        }
    }
    private void bindingAction() {
        btnTTSStop.setOnClickListener(this::btnTTSStopClick);
        btnNext.setOnClickListener(this::btnNext);
    }

    private void btnNext(View view) {
        Bundle b = getIntent().getExtras();
        String chap = b.getString(StaticCode.getInstance().getCHAPTER_KEY());
    }

    private void btnTTSStopClick(View view) {
        toSpeech.stop();
    }


    private void bindingView() {
        btnNext = findViewById(R.id.btnNext);
        tvTitle = findViewById(R.id.tvTitle);
        btnTTS = findViewById(R.id.btnTTS);
        btnTTSStop = findViewById(R.id.btnTTSStop);
        Intent i = getIntent();
        nameChap = i.getStringExtra("name");
        nameTitle = i.getStringExtra("nameTitle");
        contentChap = i.getStringExtra("contentChap");
        Log.d("name", nameChap);
        tvTitle.setText(nameTitle);
        Bundle b = new Bundle();
        b.putString("name", nameChap);
        b.putString("nameTitle", nameTitle);
        b.putString("contentChap", contentChap);
        FrmStoryReading frmStoryReading = FrmStoryReading.getInstances();
        frmStoryReading.setArguments(b);
    }

    @Override
    public void onInit(int i) {
        if(i == TextToSpeech.SUCCESS){
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } else if(i == TextToSpeech.ERROR){
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }
}