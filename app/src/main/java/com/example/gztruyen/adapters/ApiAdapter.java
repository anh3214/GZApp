package com.example.gztruyen.adapters;


import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.gztruyen.api.ApiService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    private static ApiService sFirestoreApi;

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    public ApiAdapter(Context context) {
        mContext = context;
    }

    public static ApiService getFirestoreApi() {
        if (sFirestoreApi == null) {
            SharedPreferences mPrefs = mContext.getSharedPreferences("myPrefs", MODE_PRIVATE);
            String token = mPrefs.getString("token", "");

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request request = chain.request();
                        Request.Builder requestBuilder = request.newBuilder();
                        requestBuilder.addHeader("Authorization", "Bearer "+token); // Kiểm tra phần này
                        return chain.proceed(requestBuilder.build());
                    })
                    .build();

            ApiService retrofit = new Retrofit.Builder()
                    .baseUrl("https://firestore.googleapis.com/v1/projects/appproject-61e7e/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);

            sFirestoreApi = retrofit;
        }
        return sFirestoreApi;
    }
}
