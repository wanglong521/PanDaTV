package com.example.admin.pandatv.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.livapandabean.SpecialBean;

import java.util.List;

/**
 * Created by LiYRong on 2017/8/28.
 */

public class SpecialAdapter extends BaseAdapter {
    private Context context;
    private List<SpecialBean.VideoBean> list;
    private ViewHolder viewHolder;

    public SpecialAdapter(Context context, List<SpecialBean.VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            viewHolder = new ViewHolder();

            view = View.inflate(context, R.layout.otherlist_item, null);

            viewHolder.img = view.findViewById(R.id.img);

            viewHolder.t = view.findViewById(R.id.other_title);

            viewHolder.prtime = view.findViewById(R.id.other_time);

            view.setTag(viewHolder);
        }else {

            viewHolder = (ViewHolder) view.getTag();
        }


        Glide.with(context).load(list.get(i).getImg()).into(viewHolder.img);
        viewHolder.prtime.setText(list.get(i).getPtime());
        viewHolder.t.setText(list.get(i).getT());
        return view;
    }
    static class ViewHolder{

        ImageView img;
        TextView t,prtime;

    }

}