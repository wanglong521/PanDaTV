package com.example.admin.pandatv.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.livapandabean.MoreBean;

import java.util.List;

/**
 * Created by LiYRong on 2017/8/29.
 */

public class MoreRAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<MoreBean.ListBean> list;
    private Lisennter lisennter;

    public MoreRAdapter(Context context, List<MoreBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.more_item, null);

        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ((ViewHolder)holder).more_title.setText(list.get(position).getTitle());

        Glide.with(context).load(list.get(position).getImage()).into(((ViewHolder) holder).more_image);

        ((ViewHolder) holder).more_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisennter.OnClick(position,view);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView more_image;
        TextView more_title;
        public ViewHolder(View itemView) {
            super(itemView);
            more_image= itemView.findViewById(R.id.more_image);
            more_title = itemView.findViewById(R.id.more_title);
        }
    }

    public interface Lisennter{

        void OnClick(int position,View view);
    }

    public void ItemROnClickLisennter(Lisennter lisennter){

        this.lisennter=lisennter;
    }
}
