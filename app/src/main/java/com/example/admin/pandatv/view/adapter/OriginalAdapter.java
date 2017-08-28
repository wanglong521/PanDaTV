package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.bean.Original;
import com.example.admin.pandatv.view.base.App;

import java.util.List;

/**
 * Created by admin on 2017/8/28.
 */

public class OriginalAdapter extends BaseCommAdapter<Original.InteractiveBean> {
    public OriginalAdapter(List<Original.InteractiveBean> li) {
        super(li);
    }

    @Override
    protected void setUI(ViewHolder holder, int position, final Context context) {
        final Original.InteractiveBean item = getItem(position);

        TextView tv_name = holder.getItemView(R.id.or_tv);
        tv_name.setText(item.getTitle());
        ImageView im = holder.getItemView(R.id.or_im);
        Glide.with(App.mBaseActivity).load(item.getImage()).into(im);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.original_item;
    }
}