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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gztruyen.Activity.SearchActivity;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.TruyenChuAdapter;
import com.example.gztruyen.databinding.FragmentTruyenChuBinding;
import com.example.gztruyen.model.ComicModel;

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
        adapter = new TruyenChuAdapter(getTruyen());
        gridLayoutManager = new GridLayoutManager(context,3);
        Log.d("Data",""+adapter.getItemCount());
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
    private List<ComicModel> getTruyen() {
        List<ComicModel> models = new ArrayList<>();
        ComicModel modelTruyen = new ComicModel("ẤDSD","Tiên Tôn Hổ","ádadsasd","https://bit.ly/2YoJ77H");
        ComicModel modelTruyen1 = new ComicModel("ẤDSD","Voi Tu Tiên","ádadsasd","https://bit.ly/2BteuF2");
        ComicModel modelTruyen2 = new ComicModel("ẤDSD","Pháp Sư bí Ẩn","ádadsasd","https://bit.ly/3fLJf72");
        ComicModel modelTruyen3 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/173/chuyen-sinh-thanh-kiem.jpg");
        ComicModel modelTruyen4 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/138/bong-mot-ngay-xuyen-thanh-hoang-hau-ac-d-7720.jpg");
        ComicModel modelTruyen5 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/183/chuyen-khong-the.jpg");
        ComicModel modelTruyen6 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/54/1001-cach-chinh-phuc-chong-yeu.jpg");
        ComicModel modelTruyen7 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/72/tu-luc-bat-dau-lien-vo-dich.jpg");
        ComicModel modelTruyen8 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/177/quyet-chien.jpg");
        ComicModel modelTruyen9 = new ComicModel("ẤDSD","Bola Bolo","ádadsasd","https://st.nettruyenup.com/data/comics/230/ta-vo-dich-luc-nao.jpg");


        models.add(modelTruyen);
        models.add(modelTruyen1);
        models.add(modelTruyen2);
        models.add(modelTruyen3);
        models.add(modelTruyen4);
        models.add(modelTruyen5);
        models.add(modelTruyen6);
        models.add(modelTruyen7);
        models.add(modelTruyen8);
        models.add(modelTruyen9);
        return models;
    }
    private void btnSearchOnClick(View view) {
//        Toast.makeText(context, "As u wish", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, SearchActivity.class);
        startActivity(intent);
    }
}