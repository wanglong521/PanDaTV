package com.example.admin.pandatv.view.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.modelutils.GlideImageLoader;
import com.example.admin.pandatv.prosenter.IPresenterImpl;
import com.example.admin.pandatv.prosenter.IPresenterImplItem;
import com.example.admin.pandatv.view.activity.WebActivity;
import com.example.admin.pandatv.view.adapter.BroadcastAdapter;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.IView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/23.
 */

public class BroadcastModule_Fragment extends BaseFragment implements IView {

    private ImageView broadcastPersonal;
    private Banner broadcastBanner;
    private RecyclerView broadcastRecyclerView;
    private ArrayList<String> images = new ArrayList<String>();
    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> imagesurl = new ArrayList<String>();
    private BroadcastAdapter adapter;
    private ArrayList<BoradcastBeanitem.ListBean> listBeen = new ArrayList<BoradcastBeanitem.ListBean>();
    ;

    @Override
    public int getLayout() {
        return R.layout.broadcastmodule_fragment;
    }

    @Override
    protected void initListener() {
        broadcastBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(App.mBaseActivity, WebActivity.class);
                intent.putExtra("imageurl",imagesurl);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        IPresenterImpl iPresenter = new IPresenterImpl(this);
        iPresenter.Getcontroller();
        IPresenterImplItem iPresenterImplItem = new IPresenterImplItem(this);
        iPresenterImplItem.GetcontrollerItem();
    }

    @Override
    protected void initView(View view) {
        broadcastPersonal = view.findViewById(R.id.BroadcastPersonal);
        broadcastBanner = view.findViewById(R.id.BroadcastBanner);
        //设置图片加载器
        broadcastBanner.setImageLoader(new GlideImageLoader());
        //设置banner样式
        broadcastBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        broadcastRecyclerView = view.findViewById(R.id.BroadcastRecyclerView);
        adapter = new BroadcastAdapter(App.mBaseActivity, listBeen);
        broadcastRecyclerView.setLayoutManager(new LinearLayoutManager(App.mBaseActivity, LinearLayoutManager.VERTICAL, false));
        broadcastRecyclerView.setAdapter(adapter);
    }


    @Override
    public void OnSucceed(BroadcastBean succed) {
        images.clear();
        titles.clear();
        imagesurl.clear();
        List<BroadcastBean.DataBean.BigImgBean> bigImg = succed.getData().getBigImg();
        for (int i = 0; i < bigImg.size(); i++) {
            BroadcastBean.DataBean.BigImgBean bigImgBean = bigImg.get(i);
            images.add(bigImgBean.getImage());
            titles.add(bigImgBean.getTitle());
            imagesurl.add(i, bigImgBean.getUrl());
            //设置标题集合（当banner样式有显示title时）
            Log.e("TAG",titles.size()+titles.get(0));
            broadcastBanner.setBannerTitles(titles);
            //设置图片集合
            broadcastBanner.setImages(images);
            //banner设置方法全部调用完毕时最后调用
            broadcastBanner.start();
        }
    }

    @Override
    public void OnDefeated() {
        Log.e("TAG", "失败了");
    }

    @Override
    public void OnSucceedItem(BoradcastBeanitem beanitem) {
        listBeen.clear();
        List<BoradcastBeanitem.ListBean> list = beanitem.getList();
        for (int i = 0; i < list.size(); i++) {
            BoradcastBeanitem.ListBean listBean1 = list.get(i);
            listBeen.add(i, listBean1);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnDefeatedItem() {
        Log.e("TAG", "失败了");
    }
}
