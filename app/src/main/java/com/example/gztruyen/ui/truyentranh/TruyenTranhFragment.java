package com.example.gztruyen.ui.truyentranh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gztruyen.R;
import com.example.gztruyen.Activity.SearchActivity;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.databinding.FragmentTruyenTranhBinding;
import com.example.gztruyen.model.ComicModel;


import java.util.ArrayList;

public class TruyenTranhFragment extends Fragment {

    private ArrayList<ComicModel> model;
    private FragmentTruyenTranhBinding binding;
    private ImageSlider imageSlider;
    private GridView gridView;
    private TruyenTranhAdapter adapter;

    private ImageButton btnSearch;
    private Context context;

    public TruyenTranhFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TruyenTranhViewModel viewModel =
                new ViewModelProvider(this).get(TruyenTranhViewModel.class);
        model = new ArrayList<ComicModel>();
        ComicModel modelTruyen = new ComicModel("ẤDSD","Tiên Tôn Hổ","ádadsasd","https://bit.ly/2YoJ77H");


        ComicModel modelTruyen1 = new ComicModel("ẤDSD","Voi Tu Tiên","ádadsasd","https://bit.ly/2BteuF2");


        ComicModel modelTruyen2 = new ComicModel("ẤDSD","Pháp Sư bí Ẩn","ádadsasd","https://bit.ly/3fLJf72");


        ComicModel modelTruyen3 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://bit.ly/3fLJf72");


        model.add(modelTruyen);
        model.add(modelTruyen1);
        model.add(modelTruyen2);
        model.add(modelTruyen3);


        binding = FragmentTruyenTranhBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        gridView = root.findViewById(R.id.grid_view);
        imageSlider = root.findViewById(R.id.imageSlider);
        adapter = new TruyenTranhAdapter(requireContext(),model);

        ArrayList<SlideModel> imageList = new ArrayList<SlideModel>(); // Create image list
        ArrayList<String> imageUrl = viewModel.getText();

        for (String s:imageUrl) {
            // imageList.add(SlideModel("String Url" or R.drawable)
            // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title
            imageList.add(new SlideModel(s, ScaleTypes.FIT));
        }
        gridView.setAdapter(adapter);
        Log.d("Error",""+gridView);
        imageSlider.setImageList(imageList);

        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Log.d( "Items","Clicked" + i);
            }
        });
        context = binding.getRoot().getContext();
        bindingView(root);
        bindingAction(root);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void bindingView(View view){
        btnSearch = view.findViewById(R.id.btnSearch);
    }

    private void bindingAction(View view){
        btnSearch.setOnClickListener(this::btnSearchOnClick);
    }

    private void btnSearchOnClick(View view) {
//        Toast.makeText(context, "As u wish", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, SearchActivity.class);
        startActivity(intent);
    }
}