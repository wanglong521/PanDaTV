package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.bean.RoolView;
import com.example.admin.pandatv.view.base.App;

import java.util.List;

/**
 * Created by admin on 2017/8/26.
 */

public class RoolViewAdapter  extends  BaseCommAdapter<RoolView.ListBean> {
    public RoolViewAdapter( List<RoolView.ListBean>li) {
        super(li);
    }

    @Override
    protected void setUI(ViewHolder holder, int position, Context context) {
        RoolView.ListBean item = getItem(position);

        TextView tv_name = holder.getItemView(R.id.three_tt);
        TextView tv_time = holder.getItemView(R.id.three_time);
        tv_time.setText(item.getDaytime());
        tv_name.setText(item.getTitle());
        ImageView im = holder.getItemView(R.id.three_im);
        Glide.with(App.mBaseActivity).load(item.getImage()).into(im);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.homeroolgv_item;
    }
}