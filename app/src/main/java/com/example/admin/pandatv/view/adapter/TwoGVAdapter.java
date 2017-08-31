package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.bean.Wonderful;
import com.example.admin.pandatv.view.base.App;

import java.util.List;

/**
 * Created by admin on 2017/8/26.
 */

public class TwoGVAdapter extends  BaseCommAdapter<Wonderful.ListBean> {
    public TwoGVAdapter( List<Wonderful.ListBean>  li) {
        super(li);
    }

    @Override
    protected void setUI(ViewHolder holder, int position, Context context) {
        Wonderful.ListBean item = getItem(position);

        TextView tv_name = holder.getItemView(R.id.twotv_gv);
        //时间
        TextView time_wf = holder.getItemView(R.id.time_wf);

        TextView tv_time = holder.getItemView(R.id.time_tv);
        time_wf.setText(item.getVideoLength());
        tv_time.setText(item.getDaytime());
        tv_name.setText(item.getTitle());
        ImageView im = holder.getItemView(R.id.twogv_im);
        Glide.with(App.mBaseActivity).load(item.getImage()).into(im);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.hometwogv_item;
    }
}