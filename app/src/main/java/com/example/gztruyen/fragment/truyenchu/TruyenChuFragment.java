package com.example.gztruyen.fragment.truyenchu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gztruyen.Activity.SearchActivity;
import com.example.gztruyen.Activity.activity_bangxephang;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.TruyenChuAdapter.TruyenChuAdapter;
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.databinding.FragmentTruyenChuBinding;
import com.example.gztruyen.model.ComicModel;

import java.util.ArrayList;
import java.util.List;

public class TruyenChuFragment extends Fragment {
    private TruyenChuAdapter adapter;
    private ArrayList<SlideModel> imageList = new ArrayList<>();
    private ArrayList<String> imageListCheck = new ArrayList<>();
    private RecyclerView item_truyen;
    private FragmentTruyenChuBinding binding;
    private ImageSlider imageSlider;
    private ImageButton btnSearch;
    private GridLayoutManager gridLayoutManager;
    private Context context;
    private TextView bxhTextView;
    private TextView phanLoaiTextView;

    public TruyenChuFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTruyenChuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
        adapter = new TruyenChuAdapter();
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
        phanLoaiTextView = view.findViewById(R.id.textPhanLoai);
    }

    private void bindingAction(){
        btnSearch.setOnClickListener(this::btnSearchOnClick);
        imageSlider.setImageList(getImageList());
        imageSlider.setItemClickListener(this::itemClicker);
        item_truyen.setLayoutManager(gridLayoutManager);
        item_truyen.setAdapter(adapter);
        phanLoaiTextView.setOnClickListener(this::onOpenPhanLoai);
        bxhTextView.setOnClickListener(this::onOpenBangXepHang);
    }
    private void itemClicker(int i) {
        Log.d( "Items","Clicked" + i);
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
    private List<SlideModel> getImageList() {
        TruyenChuFragment fragment = this;
        imageList = new ArrayList<>(); // Create image list
        imageListCheck = new ArrayList<>();
        List<String> list = FireStoreApi.getAllHot("TruyenChuHot",fragment);
        return imageList;
    }
    private List<ComicModel> getTruyen(TruyenChuAdapter adapter) {
        List<ComicModel> list = FireStoreApi.getAllStory(adapter);
        return list;
    }
    private void btnSearchOnClick(View view) {
        //Intent intent = new Intent(context, SearchActivity.class);
        //startActivity(intent);
        Toast.makeText(context, "This feature is not support in version V1!", Toast.LENGTH_SHORT).show();
    }
    private void onOpenPhanLoai(View view) {
        Toast.makeText(context, "This feature is not support in version V1!", Toast.LENGTH_SHORT).show();
    }
    private  void onOpenBangXepHang(View view){
        Intent i = new Intent(context, activity_bangxephang.class);
        context.startActivity(i);
    }
}