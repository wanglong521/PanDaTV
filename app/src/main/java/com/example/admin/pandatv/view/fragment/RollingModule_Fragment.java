package com.example.admin.pandatv.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.modelutils.GlideImageLoader;
import com.example.admin.pandatv.prosenter.IPresenterImplRlling;
import com.example.admin.pandatv.view.adapter.RollingAdapter;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.IView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/23.
 */

public class RollingModule_Fragment extends BaseFragment implements IView {

    private Banner rollingBanner;
    private RecyclerView RollingRecyclerView;
    private ImageView RollingPersonal;
    private ArrayList<RllingBean.ListBean> listBeen = new ArrayList<RllingBean.ListBean>();
    private RecyclerAdapterWithHF adap;
    private ArrayList<String> images = new ArrayList<String>();
    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> imagesurl = new ArrayList<String>();

    @Override
    public int getLayout() {
        return R.layout.rollingmodule_fragment;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        IPresenterImplRlling iPresenterImplItem = new IPresenterImplRlling(this);
        iPresenterImplItem.GetcontrollerRlling();
    }

    @Override
    protected void initView(View view) {
        rollingBanner = view.findViewById(R.id.RollingBanner);
        RollingRecyclerView = view.findViewById(R.id.RollingRecyclerView);
        RollingPersonal = view.findViewById(R.id.RollingPersonal);
        //设置图片加载器
        rollingBanner.setImageLoader(new GlideImageLoader());
        //设置banner样式
        rollingBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        RollingAdapter adapter = new RollingAdapter(App.mBaseActivity,listBeen);
        RollingRecyclerView.setLayoutManager(new LinearLayoutManager(App.mBaseActivity, LinearLayoutManager.VERTICAL, false));
        adap = new RecyclerAdapterWithHF(adapter);
        RollingRecyclerView.setAdapter(adap);
    }

    @Override
    public void OnSucceed(BroadcastBean succed) {

    }

    @Override
    public void OnDefeated() {

    }

    @Override
    public void OnSucceedItem(BoradcastBeanitem beanitem) {

    }

    @Override
    public void OnDefeatedItem() {

    }

    @Override
    public void OnSucceedRlling(RllingBean beanitem) {
        images.clear();
        titles.clear();
        imagesurl.clear();
        List<RllingBean.BigImgBean> bigImg = beanitem.getBigImg();
        for (int i = 0; i < bigImg.size(); i++) {
            RllingBean.BigImgBean bigImgBean = bigImg.get(i);
            images.add(bigImgBean.getImage());
            titles.add(bigImgBean.getTitle());
            imagesurl.add(i, bigImgBean.getUrl());
            //设置标题集合（当banner样式有显示title时）
            Log.e("TAG",titles.size()+titles.get(0));
            rollingBanner.setBannerTitles(titles);
            //设置图片集合
            rollingBanner.setImages(images);
            //banner设置方法全部调用完毕时最后调用
            rollingBanner.start();
        }
        listBeen.clear();
        List<RllingBean.ListBean> list = beanitem.getList();
        for (int i = 0; i < list.size(); i++) {
            RllingBean.ListBean listBean1 = list.get(i);
            listBeen.add(listBean1);
        }
        adap.notifyDataSetChanged();
    }

    @Override
    public void OnDefeatedRlling() {
        Log.e("TAG", "失败了");
    }
}
