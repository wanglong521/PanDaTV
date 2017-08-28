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

public class GvAdapter extends  BaseCommAdapter<Home.DataBean.PandaliveBean.ListBean> {
    public GvAdapter(List<Home.DataBean.PandaliveBean.ListBean> li) {
        super(li);
    }

    @Override
    protected void setUI(ViewHolder holder, int position, Context context) {
        Home.DataBean.PandaliveBean.ListBean item = getItem(position);

        TextView tv_name = holder.getItemView(R.id.tv_gv);
        tv_name.setText(item.getTitle());
        ImageView im = holder.getItemView(R.id.gv_im);
        Glide.with(App.mBaseActivity).load(item.getImage()).into(im);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.homegv_item;
    }
}