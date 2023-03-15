package com.example.gztruyen.adapters;


import com.example.gztruyen.api.ApiService;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.DocumentChap;
import com.example.gztruyen.model.QueryResponse;
import com.example.gztruyen.model.TruyenHot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    private static ApiAdapter mInstance;
    private static ApiService sFirestoreApi;

    private ApiAdapter() {
        if (sFirestoreApi == null) {

            sFirestoreApi = new Retrofit.Builder()
                    .baseUrl("https://firestore.googleapis.com/v1/projects/appproject-61e7e/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }
    }
    public static synchronized ApiAdapter getInstance() {
        if (mInstance == null) {
            mInstance = new ApiAdapter();
        }
        return mInstance;
    }

    public void basicIformationComic(Callback<QueryResponse<ComicModel>> callback,String type) {
        Call<QueryResponse<ComicModel>> call = sFirestoreApi.basicIformationComic(type);
        call.enqueue(callback);
    }

    public void getAllChap(Callback<QueryResponse<DocumentChap>> callback, String type, String name) {
        Call<QueryResponse<DocumentChap>> call = sFirestoreApi.getAllChap(type,name);
        call.enqueue(callback);
    }

    public void getComicModel(Callback<QueryResponse<ComicModel>> callback, String type, String name) {

    }
    public void getAllHot(Callback<QueryResponse<TruyenHot>> callback,String type){
        Call<QueryResponse<TruyenHot>> call = sFirestoreApi.getAllHot(type);
        call.enqueue(callback);
    }
}
