package com.example.gztruyen.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gztruyen.R;
import com.example.gztruyen.model.TruyenTranhModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TruyenTranhAdapter extends BaseAdapter {
    private List<TruyenTranhModel> mList;
    private Context mContext;

    public TruyenTranhAdapter( Context mContext,List<TruyenTranhModel> mList) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  static class ViewHolder{
    ImageView imageView;
    TextView textView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            // if it's not recycled, initialize some attributes
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            view =inflater.inflate(R.layout.view_holder,null);
            holder.imageView = view.findViewById(R.id.imageView);
            holder.textView = view.findViewById(R.id.textView2);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ImageView imageView = view.findViewById(R.id.imageView);
        holder.textView.setText(mList.get(i).Name);
        Picasso.get().load(mList.get(i).getImage()).into(imageView);
        return view;
    }
}
