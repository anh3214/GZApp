package com.example.gztruyen.fragment.truyentranh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gztruyen.Activity.activity_bangxephang;
import com.example.gztruyen.R;
import com.example.gztruyen.Activity.SearchActivity;
import com.example.gztruyen.adapters.TruyenTranhAdapter.TruyenTranhAdapter;
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.databinding.FragmentTruyenTranhBinding;
import com.example.gztruyen.model.ComicModel;


import java.util.ArrayList;
import java.util.List;

public class TruyenTranhFragment extends Fragment {
    private TruyenTranhAdapter adapter;
    private ArrayList<SlideModel> imageList = new ArrayList<>();
    private ArrayList<String> imageListCheck = new ArrayList<>();
    private RecyclerView item_truyen;
    private FragmentTruyenTranhBinding binding;
    private ImageSlider imageSlider;
    private ImageButton btnSearch;
    private GridLayoutManager gridLayoutManager;
    private Context context;
    private TextView bxhTextView;

    public TruyenTranhFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTruyenTranhBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
        adapter = new TruyenTranhAdapter();
        adapter.updateData(getTruyen(adapter));
        gridLayoutManager = new GridLayoutManager(context,3);
        bindingView(root);
        bindingAction();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void bindingView(View view){
        btnSearch = view.findViewById(R.id.btnSearch);
        imageSlider = view.findViewById(R.id.imageSlider);
        item_truyen = view.findViewById(R.id.item_truyen);
        bxhTextView = view.findViewById(R.id.bangxephang);
    }

    private void bindingAction(){
        item_truyen.setAdapter(adapter);
        btnSearch.setOnClickListener(this::btnSearchOnClick);
        imageSlider.setImageList(getImageList());
        item_truyen.setLayoutManager(gridLayoutManager);
        bxhTextView.setOnClickListener(this::onOpenBangXepHang);
        imageSlider.setItemClickListener(this::itemClicker);
    }
    private void itemClicker(int i) {
        Log.d( "Items","Clicked" + i);
    }

    private List<SlideModel> getImageList() {
        TruyenTranhFragment fragment = this;
        imageList = new ArrayList<>(); // Create image list
        imageListCheck = new ArrayList<>();
        List<String> list = FireStoreApi.getAllHot("TruyenTranhHot",fragment);
        return imageList;
    }
    public void reloadImageSlide(List<String> slider){
        for (String image:
             slider) {
            if(!imageListCheck.contains(image)){
                imageList.add(new SlideModel(image,ScaleTypes.FIT));
                imageListCheck.add(image);
            }
        }
        imageSlider.setImageList(imageList);
    }
    private List<ComicModel> getTruyen(TruyenTranhAdapter adapter) {
        List<ComicModel> list = FireStoreApi.getAllCommic(adapter);
        return list;
    }
    private void btnSearchOnClick(View view) {
        Intent intent = new Intent(context, SearchActivity.class);
        startActivity(intent);
    }

    private  void onOpenBangXepHang(View view){
        Intent i = new Intent(context, activity_bangxephang.class);
        context.startActivity(i);
    }
}