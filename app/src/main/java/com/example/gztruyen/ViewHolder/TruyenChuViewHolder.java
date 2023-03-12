package com.example.gztruyen.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gztruyen.Activity.detailActivity.MangaDetailActivity;
import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.R;
import com.example.gztruyen.model.ComicModel;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TruyenChuViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView titleView;
    private LinearLayout item_truyen_line;
    private Context context;
    private ComicModel a;

    private void bindindView() {
        imageView = itemView.findViewById(R.id.imageView);
        titleView = itemView.findViewById(R.id.txView);
        item_truyen_line = itemView.findViewById(R.id.item_truyen_line);
    }
    private void btnItemDetail(View view) {
        Log.d("Error","Truyen Chu ne");
    }
    private void bindingAction(){
        imageView.setOnClickListener(this::onImgClick);
        item_truyen_line.setOnClickListener(this::btnItemDetail);
    }
    private void onImgClick(View view) {
        Intent i = new Intent(context, MangaDetailActivity.class);
        i.putExtra(StaticCode.getInstance().TYPE_KEY, StaticCode.getInstance().STORY);
        String name = a.getName();
        i.putExtra("name", name);
        Log.d("name truyen chu", name);
        String description = a.getFields().getDescription().getStringValue();
        i.putExtra("description",description);
        //String url = a.getAvatar().
        ArrayList url = new ArrayList<String>(a.getAvatar());
        i.putStringArrayListExtra("URLImage",url);
        context.startActivity(i);
        Log.d("thanhdt", a.toString());
        Toast.makeText(context, "u press me " + titleView.getText(), Toast.LENGTH_SHORT).show();
    }

    public void setData(ComicModel comicModel) {
        a = comicModel;
        titleView.setText(comicModel.getFields().getTitle().getStringValue());
        if(comicModel.getAvatar() != null){
            for (String url : comicModel.getAvatar()) {
                Picasso.get()
                        .load(url)
                        .fit()
                        .placeholder(R.drawable.img_loading_img)
                        .error(R.drawable.img_err_img)
                        .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                        .centerCrop()
                        .into(imageView);
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ComicModel comicModel);
    }
    public void setOnItemClickListener(final ComicModel comicModel, final OnItemClickListener onItemClickListener) {
        imageView.setOnClickListener(this::clickImge);
    }

    private void clickImge(View view) {
        Toast.makeText(context, "u press me " + titleView.getText(), Toast.LENGTH_SHORT).show();
    }
    public TruyenChuViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        bindindView();
        bindingAction();
    }
}
