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
import com.example.admin.pandatv.model.bean.Home;
import com.example.admin.pandatv.view.base.App;

import java.util.List;

/**
 * Created by admin on 2017/8/31.
 */

public class HomeXRVAdapter extends RecyclerView.Adapter<HomeXRVAdapter.ViewHolder> implements View.OnClickListener {
    Context context;
    List<Home.DataBean.ChinaliveBean.ListBeanX> chinaLivelists;
    //使外界可以set
    private onclicklinster onclicklinster;

    public void setOnclicklinster(HomeXRVAdapter.onclicklinster onclicklinster) {
        this.onclicklinster = onclicklinster;
    }

    public HomeXRVAdapter(Context context, List<Home.DataBean.ChinaliveBean.ListBeanX> chinaLivelists) {
        this.context = context;
        this.chinaLivelists = chinaLivelists;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_live_gv_item, parent, false);
        //调用点击事件
        view.setOnClickListener(this);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Home.DataBean.ChinaliveBean.ListBeanX listBeanX = chinaLivelists.get(position);
        holder.live_tv_gv.setText(listBeanX.getTitle());

        Glide.with(App.mBaseActivity).load(listBeanX.getImage()).into(holder.live_gv_im);
        //打上标签吧
        holder.itemView.setTag(position);

    }


    @Override
    public int getItemCount() {
        return chinaLivelists.size();
    }


    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView live_tv_gv;
        public ImageView live_gv_im;
        public TextView tv_live;

        public ViewHolder(View view) {
            super(view);
            live_tv_gv = (TextView) view.findViewById(R.id.live_tv_gv);


            live_gv_im = (ImageView) view.findViewById(R.id.live_gv_im);

        }
    }

    /**
     * 1--->声明一个接口;
     * 2-->写实现类,
     * 3-->调用
     */
    public interface onclicklinster {
        public void onItemClick(int ppp);
    }
//进行赋值
    @Override
    public void onClick(View view) {
        if (null != onclicklinster) {
            Integer per = (Integer) view.getTag();
            onclicklinster.onItemClick(per);
        }
    }


}
