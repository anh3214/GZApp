package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.util.Log;

import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ViewMangaDetailAdapter;
import com.google.android.material.tabs.TabLayout;

public class MangaDetailActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imageView;
    private String type;
    private String name;


    private void bindingView(){
        Intent i = getIntent();
        type = i.getStringExtra(StaticCode.getInstance().TYPE_KEY);
        name = i.getStringExtra("name");
        Log.d("name", name);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPaper);
        imageView = findViewById(R.id.imageView4);

        Bundle b = new Bundle();
        b.putString("type", type);
        b.putString("name", name);
        ChaptersFragment detailFragment = ChaptersFragment.getInstance();
        detailFragment.setArguments(b);
    }

    private void bindingAction(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_detail);
        bindingView();
        bindingAction();

        ViewMangaDetailAdapter mangaDetailAdapter = new ViewMangaDetailAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(mangaDetailAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //imageView
    }

}