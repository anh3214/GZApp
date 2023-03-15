package com.example.gztruyen.adapters;


import com.example.gztruyen.api.ApiService;
import com.example.gztruyen.model.Category;
import com.example.gztruyen.model.ChapterModel1;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.CommicModel;
import com.example.gztruyen.model.DocumentChap;
import com.example.gztruyen.model.Page;
import com.example.gztruyen.model.QueryResponse;
import com.example.gztruyen.model.TruyenHot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    private static ApiAdapter mInstance;
    private static ApiService sFirestoreApi;

    private static ApiService sDbApi;

    private ApiAdapter() {
        if (sFirestoreApi == null) {

            sFirestoreApi = new Retrofit.Builder()
                    .baseUrl("https://firestore.googleapis.com/v1/projects/appproject-61e7e/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }
        if(sDbApi == null){
            sDbApi = new Retrofit.Builder()
                    .baseUrl("http://58.186.84.114:8001/api/")
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
    public void getAllHot(Callback<QueryResponse<TruyenHot>> callback,String type){
        Call<QueryResponse<TruyenHot>> call = sFirestoreApi.getAllHot(type);
        call.enqueue(callback);
    }
    public void getAllCategory(Callback<QueryResponse<Category>> callback){
        Call<QueryResponse<Category>> call = sDbApi.getAllCategory();
        call.enqueue(callback);
    }
    public void gettAllCommic(Callback<QueryResponse<CommicModel>> callback,int type){
        Call<QueryResponse<CommicModel>> call = sDbApi.gettAllCommic(type);
        call.enqueue(callback);
    }
    public void getAllChapByCommic(Callback<QueryResponse<ChapterModel1>> callback, int commic){
        Call<QueryResponse<ChapterModel1>> call = sDbApi.getAllChapByCommic(commic);
        call.enqueue(callback);
    }
    public void getPage(Callback<QueryResponse<Page>> callback,int chap){
        Call<QueryResponse<Page>> call = sDbApi.getPage(chap);
        call.enqueue(callback);
    }
}
