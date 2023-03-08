package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gztruyen.CommonUltil.FakeData;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.BangXepHangAdapter;
import com.example.gztruyen.adapters.ChaptersAdapter;
import com.example.gztruyen.adapters.TopTruyenAdapter;
import com.example.gztruyen.model.ChapterModel;
import com.example.gztruyen.model.ComicModel;

import java.util.ArrayList;
import java.util.List;

public class BangXHFragment extends Fragment {

    private RecyclerView rcvBXH;
    private Context context;

    private void bindingView(View view){
        rcvBXH = view.findViewById(R.id.rcvBXH);
    }

    private void bindingAction(View view){}

    public BangXHFragment() {
            // Required empty public constructor
        }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bang_xh, container, false);
        bindingView(rootView);
        bindingAction(rootView);
        FakeData fakeData = new FakeData();

        List<ComicModel> comicModels = fakeData.fakeDataComic();

        TopTruyenAdapter adapter = new TopTruyenAdapter(comicModels);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        rcvBXH.setAdapter(adapter);
        rcvBXH.setLayoutManager(layoutManager);

        // Inflate the layout for this fragment
        return rootView;
    }
}
