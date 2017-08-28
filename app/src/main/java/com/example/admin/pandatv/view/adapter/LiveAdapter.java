package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.bean.Home;
import com.example.admin.pandatv.view.base.App;

import java.util.List;

/**
 * Created by admin on 2017/8/26.
 */

public class LiveAdapter extends  BaseCommAdapter<Home.DataBean.ChinaliveBean.ListBeanX> {
    public LiveAdapter(List<Home.DataBean.ChinaliveBean.ListBeanX> li) {
        super(li);
    }

    @Override
    protected void setUI(ViewHolder holder, int position, Context context) {
        Home.DataBean.ChinaliveBean.ListBeanX item = getItem(position);

        TextView tv_name = holder.getItemView(R.id.live_tv_gv);
        tv_name.setText(item.getTitle());
        ImageView im = holder.getItemView(R.id.live_gv_im);
        Glide.with(App.mBaseActivity).load(item.getImage()).into(im);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_live_gv_item;
    }
}