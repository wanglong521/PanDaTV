package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.RllingBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/27.
 */

public class RollingAdapter extends RecyclerView.Adapter {


    private Context context;
    private ArrayList<RllingBean.ListBean> list;

    public RollingAdapter(Context context, ArrayList<RllingBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rollingitem,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        RllingBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getImage()).error(R.mipmap.ic_launcher).into(viewHolder.RollingImage);
        viewHolder.RollingTitle.setText(listBean.getTitle());
        viewHolder.RollingContent.setText(listBean.getBrief());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView RollingImage;
        private final TextView RollingTitle;
        private final TextView RollingContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            RollingImage = itemView.findViewById(R.id.RollingImage);
            RollingTitle = itemView.findViewById(R.id.RollingTitle);
            RollingContent = itemView.findViewById(R.id.RollingContent);
        }
    }
}
