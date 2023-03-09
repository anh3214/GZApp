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
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.model.ChapterModel;
import com.example.gztruyen.model.ComicModel;

import java.util.ArrayList;
import java.util.List;

public class BangXHFragment extends Fragment {

    private RecyclerView rcvBXH;
    private Context context;
    private List<ComicModel> mList;
    private TopTruyenAdapter adapterTopTruyen;

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

        //adapterComic  = new TruyenTranhAdapter();
        //adapterComic.updateData(getTruyen(adapterComic));
        adapterTopTruyen = new TopTruyenAdapter();
         adapterTopTruyen.updateData(getTruyen(adapterTopTruyen));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        rcvBXH.setAdapter(adapterTopTruyen);
        rcvBXH.setLayoutManager(layoutManager);

        // Inflate the layout for this fragment
        return rootView;
    }

    private List<ComicModel> getTruyen(TopTruyenAdapter adapter) {
        List<ComicModel> list = FireStoreApi.getAllCommicBXH(adapter);
        return list;
    }

}
