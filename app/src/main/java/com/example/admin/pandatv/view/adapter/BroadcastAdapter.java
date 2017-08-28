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
import com.example.admin.pandatv.model.entity.BoradcastBeanitem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/25.
 */

public class BroadcastAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<BoradcastBeanitem.ListBean> list;

    public BroadcastAdapter(Context context, ArrayList<BoradcastBeanitem.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.broadcastitem,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        BoradcastBeanitem.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getPicurl()).error(R.mipmap.ic_launcher).into(viewHolder.broadcastImage);
        viewHolder.broadcastTitle.setText(listBean.getTitle());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String format = sdf.format(listBean.getFocus_date());
        viewHolder.broadcastTime.setText(format);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView broadcastImage;
        private final TextView broadcastTitle;
        private final TextView broadcastTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            broadcastImage = itemView.findViewById(R.id.BroadcastImage);
            broadcastTitle = itemView.findViewById(R.id.BroadcastTitle);
            broadcastTime = itemView.findViewById(R.id.BroadcastTime);
        }
    }
}
