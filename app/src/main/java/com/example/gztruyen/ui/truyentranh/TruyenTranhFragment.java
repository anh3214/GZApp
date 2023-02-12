package com.example.gztruyen.ui.truyentranh;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gztruyen.Home;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.databinding.FragmentTruyenTranhBinding;
import com.example.gztruyen.model.TruyenTranhModel;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;

public class TruyenTranhFragment extends Fragment {

    private ArrayList<TruyenTranhModel> model;
    private FragmentTruyenTranhBinding binding;
    private ImageSlider imageSlider;
    private GridView gridView;
    private TruyenTranhAdapter adapter;

    public TruyenTranhFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TruyenTranhViewModel viewModel =
                new ViewModelProvider(this).get(TruyenTranhViewModel.class);
        model = new ArrayList<TruyenTranhModel>();
        TruyenTranhModel modelTruyen = new TruyenTranhModel("ẤDSD","Tiên Tôn Hổ","ádadsasd","https://bit.ly/2YoJ77H");


        TruyenTranhModel modelTruyen1 = new TruyenTranhModel("ẤDSD","Voi Tu Tiên","ádadsasd","https://bit.ly/2BteuF2");


        TruyenTranhModel modelTruyen2 = new TruyenTranhModel("ẤDSD","Pháp Sư bí Ẩn","ádadsasd","https://bit.ly/3fLJf72");


        TruyenTranhModel modelTruyen3 = new TruyenTranhModel("ẤDSD","Bola Bolo","ádadsasd","https://bit.ly/3fLJf72");


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
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}