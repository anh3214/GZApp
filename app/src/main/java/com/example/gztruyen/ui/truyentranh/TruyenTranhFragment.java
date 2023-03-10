package com.example.gztruyen.ui.truyentranh;

import static android.content.Intent.getIntent;

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
import com.example.gztruyen.Activity.activity_bangxephang;
import com.example.gztruyen.R;
import com.example.gztruyen.Activity.SearchActivity;
import com.example.gztruyen.adapters.ApiAdapter;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.api.ApiService;
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.databinding.FragmentTruyenTranhBinding;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.QueryResponse;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TruyenTranhFragment extends Fragment {
    private TruyenTranhAdapter adapter;
    private ArrayList<SlideModel> imageList;
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
        imageSlider.setItemClickListener(this::itemClicker);
        item_truyen.setLayoutManager(gridLayoutManager);
        bxhTextView.setOnClickListener(this::onOpenBangXepHang);
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
    private List<ComicModel> getTruyen(TruyenTranhAdapter adapter) {
        List<ComicModel> list = FireStoreApi.getAllCommic(adapter);
        return list;
    }
    private void btnSearchOnClick(View view) {
//        Toast.makeText(context, "As u wish", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, SearchActivity.class);
        startActivity(intent);
    }

    private  void onOpenBangXepHang(View view){
        Intent i = new Intent(context, activity_bangxephang.class);
        context.startActivity(i);
        Toast.makeText(context, "open BXH", Toast.LENGTH_SHORT).show();
    }


}