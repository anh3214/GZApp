package com.example.gztruyen.fragment;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ComonAdapter.TopTruyenAdapter;
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.model.ComicModel;

import java.util.List;

public class BangXHFragment extends Fragment {

    private RecyclerView rcvBXH;
    private Context context;
    private List<ComicModel> mList;
    private TopTruyenAdapter adapterTopTruyenTranh;
    private TopTruyenAdapter adapterTopTruyenChu;
    private  int typeTruyen;

    private void bindingView(View view){
        rcvBXH = view.findViewById(R.id.rcvBXH);
    }

    private void bindingAction(View view){}

    public BangXHFragment(int type) {
        // Required empty public constructor
        typeTruyen = type;
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


        adapterTopTruyenTranh = new TopTruyenAdapter();
        adapterTopTruyenTranh.updateData(getTruyenTranh(adapterTopTruyenTranh));
        adapterTopTruyenChu = new TopTruyenAdapter();
        adapterTopTruyenChu.updateData(getTruyenChu(adapterTopTruyenChu));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());

        if(typeTruyen ==0){
            rcvBXH.setAdapter(adapterTopTruyenTranh);
        }
        else{
            rcvBXH.setAdapter(adapterTopTruyenChu);
        }

        rcvBXH.setLayoutManager(layoutManager);

        // Inflate the layout for this fragment
        return rootView;
    }

    private List<ComicModel> getTruyenTranh(TopTruyenAdapter adapter) {
        List<ComicModel> list = FireStoreApi.getAllCommicBXH(adapter);
        return list;
    }
    private List<ComicModel> getTruyenChu(TopTruyenAdapter adapter) {
        List<ComicModel> list = FireStoreApi.getAllStoryBXH(adapter);
        return list;
    }

}
