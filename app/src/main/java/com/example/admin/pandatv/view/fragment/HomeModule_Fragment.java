package com.example.admin.pandatv.view.fragment;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.bean.Home;
import com.example.admin.pandatv.model.networkutils.utils;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.customview.GlideImageLoader;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/23.
 */

public class HomeModule_Fragment extends BaseFragment {
    XRecyclerView home_xrv;
    Toolbar toolbr;
    Banner banner;
    ProgressBar pbr;
    TextView panda_Broadcast_Text, zj_tv, zj_tvs, qs_tv, qs_tvs;
    private List<String> images;
    private List<String> titles;
    private List<Home.DataBean.BigImgBean> listim = new ArrayList<>();
    private String title;
    private String zj;
    private String titlezj;
    private String brief;
    private String titleqs;
    private ImageView im_home;
    String pandaeyelogo;
    @Override
    public int getLayout() {
        return R.layout.homemodule_fragment;
    }

    @Override
    protected void initListener() {


    }

    @Override
    protected void initData() {
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        images = new ArrayList<>();
        //设置加载标题
        titles = new ArrayList<>();
        OkHttpClientManager.getAsyn(utils.HomeURL, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Home home = new Gson().fromJson(response, Home.class);
                List<Home.DataBean.BigImgBean> bigImg = home.getData().getBigImg();
                title = home.getData().getPandaeye().getTitle();
                List<Home.DataBean.PandaeyeBean.ItemsBean> items = home.getData().getPandaeye().getItems();
                zj = items.get(0).getBrief();
                titlezj = items.get(0).getTitle();
                brief = items.get(1).getBrief();
                titleqs = items.get(1).getTitle();
                pandaeyelogo = home.getData().getPandaeye().getPandaeyelogo();
                //需要进行判断
                if (listim.size() == 0) {
                    listim.addAll(bigImg);
                }


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < listim.size(); i++) {
                            images.add(listim.get(i).getImage());
                            titles.add(listim.get(i).getTitle());


                        }
                        Log.e("TAG", "run: " + images.size());
                        Log.e("TAG", "run: " + titles.size());
                        panda_Broadcast_Text.setText(HomeModule_Fragment.this.title);
                        zj_tv.setText(zj);
                        zj_tvs.setText(titlezj);
                        qs_tv.setText(brief);
                        qs_tvs.setText(titleqs);
                        Glide.with(getActivity()).load(pandaeyelogo).into(im_home);
                        pbr.setVisibility(View.INVISIBLE);

                        //设置banner样式
                        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                        banner.setIndicatorGravity(BannerConfig.RIGHT);
                        banner.setBannerTitles(titles);
                        banner.setImages(images);

                        //banner设置方法全部调用完毕时最后调用
                        banner.start();
                    }
                });


            }
        });

    }

    @Override
    protected void initView(View view) {
        toolbr = (Toolbar) view.findViewById(R.id.toolbar);
        toolbr.setNavigationIcon(R.mipmap.panda_sign);
        toolbr.setTitle("");
        App.mBaseActivity.setSupportActionBar(toolbr);
        banner = (Banner) view.findViewById(R.id.banner);
        pbr = (ProgressBar) view.findViewById(R.id.pbr);
        panda_Broadcast_Text = (TextView) view.findViewById(R.id.panda_Broadcast_Text);
        zj_tv = (TextView) view.findViewById(R.id.zj_tv);
        zj_tvs = (TextView) view.findViewById(R.id.zj_tvs);
        qs_tv = (TextView) view.findViewById(R.id.qs_tv);
        qs_tvs = (TextView) view.findViewById(R.id.qs_tvs);
        im_home=(ImageView) view.findViewById(R.id.im_home);
    }
}
