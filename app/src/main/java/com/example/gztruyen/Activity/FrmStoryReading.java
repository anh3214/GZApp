package com.example.gztruyen.Activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gztruyen.R;

public class FrmStoryReading extends Fragment {


    public FrmStoryReading() {
    }

    public static FrmStoryReading newInstance(String param1, String param2) {
        FrmStoryReading fragment = new FrmStoryReading();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frm_story_reading, container, false);
    }
}