package com.example.gztruyen.ui.truyenchu;

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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gztruyen.Activity.SearchActivity;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.TruyenChuAdapter;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.api.FireStoreApi;
import com.example.gztruyen.databinding.FragmentTruyenChuBinding;
import com.example.gztruyen.databinding.FragmentTruyenTranhBinding;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.ui.truyentranh.TruyenTranhViewModel;
import com.example.gztruyen.ui.truyentranh.TruyenTranhViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TruyenChuFragment extends Fragment {
    private TruyenChuAdapter adapter;
    private ArrayList<SlideModel> imageList;
    private RecyclerView item_truyen;
    private FragmentTruyenChuBinding binding;
    private ImageSlider imageSlider;
    private ImageButton btnSearch;
    private GridLayoutManager gridLayoutManager;
    private Context context;

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
    }

    private void bindingAction(){
        btnSearch.setOnClickListener(this::btnSearchOnClick);
        imageSlider.setImageList(getImageList());
        imageSlider.setItemClickListener(this::itemClicker);
        item_truyen.setLayoutManager(gridLayoutManager);
        item_truyen.setAdapter(adapter);
    }
    private void itemClicker(int i) {
        Log.d( "Items","Clicked" + i);
    }

    private List<SlideModel> getImageList() {
        TruyenChuViewModel viewModel = new ViewModelProvider(this).get(TruyenChuViewModel.class);
        imageList = new ArrayList<>(); // Create image list
        ArrayList<String> imageUrl = viewModel.getText();

        for (String s:imageUrl) {
            imageList.add(new SlideModel(s, ScaleTypes.FIT));
        }
        return imageList;
    }
    private List<ComicModel> getTruyen(TruyenChuAdapter adapter) {
        List<ComicModel> list = FireStoreApi.getAllStory(adapter);
        return list;
    }
    private void btnSearchOnClick(View view) {
//        Toast.makeText(context, "As u wish", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, SearchActivity.class);
        startActivity(intent);
    }
}