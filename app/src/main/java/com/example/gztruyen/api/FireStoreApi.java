package com.example.gztruyen.api;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.gztruyen.adapters.ApiAdapter;
import com.example.gztruyen.adapters.TruyenChuAdapter;
import com.example.gztruyen.adapters.TruyenTranhAdapter;
import com.example.gztruyen.model.Chap;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.QueryResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FireStoreApi {

    public static List<ComicModel> getAllCommic(TruyenTranhAdapter adapter){
        List<ComicModel> comicModelss = new ArrayList<>();
        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<ComicModel> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    comicModelss.addAll(queryResponse.getDocuments());
                    Log.d("Data",""+comicModelss.size());
                    if(comicModelss.size() > 0){
                        adapter.updateData(comicModelss);
                    }
                } else {
                    Log.d("Error","Get data falseSSE");
                }
            }

            @Override
            public void onFailure(Call<QueryResponse<ComicModel>> call, Throwable t) {
                Log.d("Error","Get data false: " + t);
            }
        },"TruyenTranh");
        return comicModelss;
    }
    public static List<ComicModel> getAllStory(TruyenChuAdapter adapter){
        List<ComicModel> storyModelss = new ArrayList<>();
        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<ComicModel> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    storyModelss.addAll(queryResponse.getDocuments());
                    Log.d("Data",""+storyModelss.size());
                    if(storyModelss.size() > 0){
                        adapter.updateData(storyModelss);
                    }
                } else {
                    Log.d("Error","Get data falseSSE");
                }
            }

            @Override
            public void onFailure(Call<QueryResponse<ComicModel>> call, Throwable t) {
                Log.d("Error","Get data false: " + t);
            }
        },"TruyenChu");
        return storyModelss;
    }
    public static List<Chap> getAllChap(String type, String name){


        List<Chap> chaps = new ArrayList<>();
        ApiAdapter.getInstance().getAllChap(new Callback<QueryResponse<Chap>>() {
            @Override
            public void onResponse(Call<QueryResponse<Chap>> call, Response<QueryResponse<Chap>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<Chap> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    chaps.addAll(queryResponse.getDocuments());
//                    Log.d("Status",""+response.code());
//                    Log.d("Body",""+response.body().getDocuments());
//                    Log.d("Test",""+queryResponse.getDocuments());
                    Log.d("Data",""+chaps.size());
                } else {
                    Log.d("Error","Get data falseSSE");
                }
            }
            @Override
            public void onFailure(Call<QueryResponse<Chap>> call, Throwable t) {
                Log.d("Error","Get data false: " + t);
            }
        },"TruyenTranh","Naruto");
        return chaps;
    }

    private List<String> getUrlImage(String path){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(path); // path thư mục của bạn
        List<String> uriString = new ArrayList<>();
        storageRef.listAll().addOnSuccessListener(listResult -> {
            for (StorageReference item : listResult.getItems()) {
                item.getDownloadUrl().addOnSuccessListener(uri -> {
                    uriString.add(uri.toString());
                    // xử lý uri ở đây
                });
            }
            Log.d("URI", ""+uriString.size());
        }).addOnFailureListener(e -> {
            // xử lý lỗi ở đây
            Log.d("Error", e.getMessage());
        });
        return uriString;
    }
}
