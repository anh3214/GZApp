package com.example.gztruyen.ui.truyentranh;

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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gztruyen.R;
import com.example.gztruyen.Activity.SearchActivity;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.databinding.FragmentTruyenTranhBinding;
import com.example.gztruyen.model.ComicModel;


import java.util.ArrayList;
import java.util.List;

public class TruyenTranhFragment extends Fragment {
    private TruyenTranhAdapter adapter;
    private ArrayList<SlideModel> imageList;
    private RecyclerView item_truyen;
    private FragmentTruyenTranhBinding binding;
    private ImageSlider imageSlider;
    private ImageButton btnSearch;
    private GridLayoutManager gridLayoutManager;
    private Context context;

    public TruyenTranhFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTruyenTranhBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
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
        gridLayoutManager = new GridLayoutManager(context,3);
        imageSlider = view.findViewById(R.id.imageSlider);
    }

    private void bindingAction(){
        btnSearch.setOnClickListener(this::btnSearchOnClick);
        imageSlider.setImageList(getImageList());
        imageSlider.setItemClickListener(this::itemClicker);
        item_truyen.setLayoutManager(gridLayoutManager);
        item_truyen.setAdapter(adapter = new TruyenTranhAdapter(getTruyen()));
    }
    private void itemClicker(int i) {
        Log.d( "Items","Clicked" + i);
    }

    private List<SlideModel> getImageList() {
        TruyenTranhViewModel viewModel = new ViewModelProvider(this).get(TruyenTranhViewModel.class);
        imageList = new ArrayList<>(); // Create image list
        ArrayList<String> imageUrl = viewModel.getText();

        for (String s:imageUrl) {
            imageList.add(new SlideModel(s, ScaleTypes.FIT));
        }
        return imageList;
    }
    private List<ComicModel> getTruyen() {
        List<ComicModel> models = new ArrayList<>();
        ComicModel modelTruyen = new ComicModel("ẤDSD","Tiên Tôn Hổ","ádadsasd","https://bit.ly/2YoJ77H");
        ComicModel modelTruyen1 = new ComicModel("ẤDSD","Voi Tu Tiên","ádadsasd","https://bit.ly/2BteuF2");
        ComicModel modelTruyen2 = new ComicModel("ẤDSD","Pháp Sư bí Ẩn","ádadsasd","https://bit.ly/3fLJf72");
        ComicModel modelTruyen3 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://bit.ly/3fLJf72");


        models.add(modelTruyen);
        models.add(modelTruyen1);
        models.add(modelTruyen2);
        models.add(modelTruyen3);
        return models;
    }
    private void btnSearchOnClick(View view) {
//        Toast.makeText(context, "As u wish", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, SearchActivity.class);
        startActivity(intent);
    }
}