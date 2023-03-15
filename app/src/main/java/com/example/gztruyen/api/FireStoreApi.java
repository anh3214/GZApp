package com.example.gztruyen.api;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.adapters.ApiAdapter;
import com.example.gztruyen.adapters.ComonAdapter.ChaptersAdapter;
import com.example.gztruyen.adapters.ComonAdapter.ReadingComicAdapter;
import com.example.gztruyen.adapters.ComonAdapter.TopTruyenAdapter;
import com.example.gztruyen.adapters.TruyenChuAdapter.TruyenChuAdapter;
import com.example.gztruyen.adapters.TruyenTranhAdapter.TruyenTranhAdapter;
import com.example.gztruyen.fragment.truyenchu.TruyenChuFragment;
import com.example.gztruyen.fragment.truyentranh.TruyenTranhFragment;
import com.example.gztruyen.model.ComicModel;
import com.example.gztruyen.model.DocumentChap;
import com.example.gztruyen.model.QueryResponse;
import com.example.gztruyen.model.TruyenHot;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FireStoreApi {
    private static List<String> urlsHot = new ArrayList<>();

    public static List<ComicModel> getAllCommic(TruyenTranhAdapter adapter) {
        List<ComicModel> comicModelss = new ArrayList<>();
        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<ComicModel> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    comicModelss.addAll(queryResponse.getDocuments());
                    Log.d("Data", "" + comicModelss.size());
                    if (comicModelss.size() > 0) {
                        adapter.updateData(comicModelss);
                        for (ComicModel comic : comicModelss) {
                            getUrlImage(comic.getFields().getImageShow().getReferenceValue(), adapter, comic.getName());
                        }
                    }
                } else {
                    Log.d("Error", "Get data falseSSE");
                }
            }

            @Override
            public void onFailure(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Throwable t) {
                Log.d("Error", "Get data false: " + t);
            }
        }, "TruyenTranh");
        return comicModelss;
    }

    public static List<ComicModel> getAllStory(TruyenChuAdapter adapter) {
        List<ComicModel> storyModelss = new ArrayList<>();
        ApiAdapter.getInstance().basicIformationComic(new Callback<QueryResponse<ComicModel>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Response<QueryResponse<ComicModel>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<ComicModel> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    storyModelss.addAll(queryResponse.getDocuments());
                    Log.d("Data Story Size",""+storyModelss.size());
                    if(storyModelss.size() > 0){
                        adapter.updateData(storyModelss);
                        for (ComicModel comic : storyModelss) {
                            getUrlImage(comic.getFields().getImageShow().getReferenceValue(), adapter, comic.getName());
                        }
                    }
                } else {
                    Log.d("Error", "Get data falseSSE");
                }
            }

            @Override
            public void onFailure(@NonNull Call<QueryResponse<ComicModel>> call, @NonNull Throwable t) {
                Log.d("Error", "Get data false: " + t);
            }
        }, "TruyenChu");
        return storyModelss;
    }

    public static List<DocumentChap> getAllChap(ChaptersAdapter adapter, String type, String name) {

        List<DocumentChap> chaps = new ArrayList<>();
        ApiAdapter.getInstance().getAllChap(new Callback<QueryResponse<DocumentChap>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<DocumentChap>> call, @NonNull Response<QueryResponse<DocumentChap>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<DocumentChap> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    chaps.addAll(
                            queryResponse.getDocuments()
                    );
                    if (chaps.size() > 0) {
                        adapter.setChapterList(chaps);
                    }
                } else {
                    Log.d("Error", "Get data falseSSE");
                }
            }

            @Override
            public void onFailure(@NonNull Call<QueryResponse<DocumentChap>> call, @NonNull Throwable t) {
                Log.d("Error", "Get data false: " + t);
            }
        }, type, name);
        return chaps;
    }

    public static List<String> getUrlImage(String path, RecyclerView.Adapter adapter, String name) {

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(path); // path thư mục của bạn
        List<Task<Uri>> tasks = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        // Lấy danh sách các file trong thư mục
        Task<ListResult> listTask = storageRef.listAll();
        listTask.addOnSuccessListener(listResult -> {
            // Lấy tất cả các URL ảnh
            for (StorageReference item : listResult.getItems()) {
                Task<Uri> uriTask = item.getDownloadUrl();
                tasks.add(uriTask);
            }
            // Đợi tất cả các nhiệm vụ hoàn thành
            Tasks.whenAllComplete(tasks).addOnSuccessListener(result -> {
                for (Task<Uri> task : tasks) {
                    if (task.isSuccessful()) {
                        urls.add(task.getResult().toString());
                    }
                }
                try {
                    ReadingComicAdapter adapter1 = adapter instanceof ReadingComicAdapter ? ((ReadingComicAdapter) adapter) : null;
                    adapter1.updateAdapter(urls);
                }
                catch (Exception ex) {
                    try{
                        TruyenChuAdapter adapterC = adapter instanceof TruyenChuAdapter ? ((TruyenChuAdapter) adapter) : null;
                        adapterC.updateUrlStory(urls,name);
                    }catch (Exception e){
                        TruyenTranhAdapter adapter2 = adapter instanceof TruyenTranhAdapter ? ((TruyenTranhAdapter) adapter) : null;
                        adapter2.updateUrl(urls, name);
                    }
                }
            });
        });
        return urls;
    }

    public static List<ComicModel> getAllCommicBXH(TopTruyenAdapter adapter){
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
                        for (ComicModel comic: comicModelss) {
                            getUrlImageTopTruyen(comic.getFields().getImageShow().getReferenceValue(), adapter,comic.getName());
                        }
                    }
                } else {
                    Log.d("Error","Get data falseSSE");
                }
            }

            @Override
            public void onFailure(@NonNull Call<QueryResponse<ComicModel>> call, Throwable t) {
                Log.d("Error","Get data false: " + t);
            }
        },"TruyenTranh");
        return comicModelss;
    }

    public static List<ComicModel> getAllStoryBXH(TopTruyenAdapter adapter){
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
                        for (ComicModel comic: storyModelss) {
                            getUrlImageTopTruyen(comic.getFields().getImageShow().getReferenceValue(), adapter,comic.getName());
                        }
                    }
                } else {
                    Log.d("Error","Get data falseSSE");
                }
            }
            @Override
            public void onFailure(Call<QueryResponse<ComicModel>> call, @NonNull Throwable t) {
                Log.d("Error","Get data false: " + t);
            }
        },"TruyenChu");
        return storyModelss;
    }

    public static void getUrlImageTopTruyen(String path, RecyclerView.Adapter adapter, String name){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(path); // path thư mục của bạn
        List<Task<Uri>> tasks = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        // Lấy danh sách các file trong thư mục
        Task<ListResult> listTask = storageRef.listAll();
        listTask.addOnSuccessListener(listResult -> {
            // Lấy tất cả các URL ảnh
            for (StorageReference item : listResult.getItems()) {
                Task<Uri> uriTask = item.getDownloadUrl();
                tasks.add(uriTask);
            }

            // Đợi tất cả các nhiệm vụ hoàn thành
            Tasks.whenAllComplete(tasks).addOnSuccessListener(result -> {
                for (Task<Uri> task : tasks) {
                    if (task.isSuccessful()) {
                        urls.add(task.getResult().toString());
                    }
                }
                try {
                    ReadingComicAdapter adapter1 = adapter instanceof ReadingComicAdapter ? ((ReadingComicAdapter) adapter) : null;
                    adapter1.updateAdapter(urls);
                }catch (Exception ex){
                    TopTruyenAdapter adapter2 = adapter instanceof TopTruyenAdapter ? ((TopTruyenAdapter) adapter) : null;
                    adapter2.updateUrl(urls,name);
                }

                Log.d("Demo",""+urls);
            });
        });
    }

    public static List<String> getAllHot(String type, Fragment fragment) {
        List<TruyenHot> hots = new ArrayList<>();
        ApiAdapter.getInstance().getAllHot(new Callback<QueryResponse<TruyenHot>>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse<TruyenHot>> call, @NonNull Response<QueryResponse<TruyenHot>> response) {
                if (response.isSuccessful()) {
                    QueryResponse<TruyenHot> queryResponse = response.body();
                    // Xử lý kết quả trả về ở đây
                    hots.addAll(queryResponse.getDocuments());

                    for (TruyenHot hot:
                         hots) {
                        getUrl(hot.getFields().getImageShow().getStringValue(),urlsHot,fragment);
                    }

                } else {
                    Log.d("Error","Get data falseSSE");
                }
            }

            @Override
            public void onFailure(Call<QueryResponse<TruyenHot>> call, Throwable t) {
                Log.d("Error","Get data false: " + t);
            }
        },type);
        return urlsHot;
    }

    public static void getUrl(String path, List<String> strings, Fragment fragment) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(path);
        List<Task<Uri>> tasks = new ArrayList<>();
        Task<ListResult> listTask = storageRef.listAll();
        listTask.addOnSuccessListener(listResult -> {
            // Lấy tất cả các URL ảnh
            for (StorageReference item : listResult.getItems()) {
                Task<Uri> uriTask = item.getDownloadUrl();
                tasks.add(uriTask);
            }
            Tasks.whenAllComplete(tasks).addOnSuccessListener(result -> {
                for (Task<Uri> task : tasks) {
                    if (task.isSuccessful()) {
                        urlsHot.add(task.getResult().toString());
                        strings.add(task.getResult().toString());
                    }
                }
                try{
                    TruyenTranhFragment fragment1 = fragment instanceof TruyenTranhFragment ? ((TruyenTranhFragment) fragment) : null;
                    fragment1.reloadImageSlide(strings);
                    urlsHot.clear();
                }catch (Exception ex){
                    TruyenChuFragment fragment1 = fragment instanceof TruyenChuFragment ? ((TruyenChuFragment) fragment) : null;
                    fragment1.reloadImageSlide(strings);
                    urlsHot.clear();
                }
            });
        });
    }
}
