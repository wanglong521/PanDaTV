package com.example.admin.pandatv.view.fragment;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.bean.Home;
import com.example.admin.pandatv.model.bean.RoolView;
import com.example.admin.pandatv.model.bean.Wonderful;
import com.example.admin.pandatv.view.activity.LoginActivity;
import com.example.admin.pandatv.view.activity.OriginalInteractionActivity;
import com.example.admin.pandatv.view.activity.banderavtivitys.FristActivity;
import com.example.admin.pandatv.view.adapter.GvAdapter;
import com.example.admin.pandatv.view.adapter.LiveAdapter;
import com.example.admin.pandatv.view.adapter.RoolViewAdapter;
import com.example.admin.pandatv.view.adapter.TwoGVAdapter;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.UrlUtils;
import com.example.admin.pandatv.view.customview.GlideImageLoader;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/23.
 */

public class HomeModule_Fragment extends BaseFragment {
    ImageView imageView2, imageView;
    Toolbar toolbr;
    Banner banner;
    ProgressBar pbr;
    TextView panda_Broadcast_Text, zj_tv, zj_tvs, qs_tv,
            qs_tvs, liveshwtv, wendforment_tv, roll_tv, live_china;
    private List<String> images;
    private List<String> titles;
    private List<Home.DataBean.BigImgBean> listim;
    private String title;
    private String zj;
    private String titlezj;
    private String brief;
    private String titleqs;
    private ImageView im_home;
    String pandaeyelogo;
    String titlepandalive;
    List<Home.DataBean.PandaliveBean.ListBean> li = new ArrayList<>();
    GridView home_gv, gv_wendforment, home_live_gv;
    ListView homethree_gv;
    private GvAdapter gvAdapter;
    String wnderfulmomnet;
    List<Wonderful.ListBean> wonderfullists = new ArrayList<>();
    private TwoGVAdapter twoGVAdapter;
    String rooltitle;
    List<RoolView.ListBean> roolViewlists = new ArrayList<>();
    List<Home.DataBean.ChinaliveBean.ListBeanX> chinaLivelists = new ArrayList<>();
    String chinalivetitle;
    private List<Home.DataBean.BigImgBean> bigImg;

    @Override
    public int getLayout() {
        return R.layout.homemodule_fragment;
    }

    @Override
    protected void initListener() {
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OriginalInteractionActivity.class);
                getActivity().startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        images = new ArrayList<>();
        //设置加载标题
        titles = new ArrayList<>();
        OkHttpClientManager.getAsyn(UrlUtils.HOMEURLALL, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Home home = new Gson().fromJson(response, Home.class);
                bigImg = home.getData().getBigImg();
                title = home.getData().getPandaeye().getTitle();
                List<Home.DataBean.PandaeyeBean.ItemsBean> items = home.getData().getPandaeye().getItems();
                zj = items.get(0).getBrief();
                titlezj = items.get(0).getTitle();
                brief = items.get(1).getBrief();
                titleqs = items.get(1).getTitle();
                pandaeyelogo = home.getData().getPandaeye().getPandaeyelogo();
                Home.DataBean.PandaliveBean pandalive = home.getData().getPandalive();
                titlepandalive = pandalive.getTitle();
                wnderfulmomnet = home.getData().getCctv().getTitle();
                //直播中国

                Home.DataBean.ChinaliveBean chinalive = home.getData().getChinalive();
                chinalivetitle = chinalive.getTitle();
                List<Home.DataBean.ChinaliveBean.ListBeanX> chinalivelist = chinalive.getList();
                if (chinaLivelists.size() == 0) {
                    chinaLivelists.addAll(chinalivelist);
                }
                OkHttpClientManager.getAsyn(home.getData().getCctv().getListurl(), new OkHttpClientManager.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Toast.makeText(getActivity(), "错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response) {
                        Wonderful wonderful = new Gson().fromJson(response, Wonderful.class);
                        List<Wonderful.ListBean> wonderfullist = wonderful.getList();
                        if (wonderfullists.size() == 0) {
                            wonderfullists.addAll(wonderfullist);
                        }


                    }
                });

                List<Home.DataBean.PandaliveBean.ListBean> list = pandalive.getList();
                if (li.size() == 0) {
                    li.addAll(list);
                }

                Log.e("TAG", "onResponse: " + li.size());
                listim = new ArrayList<Home.DataBean.BigImgBean>();
                //需要进行判断
                if (listim.size() == 0) {
                    listim.addAll(bigImg);
                }
                rooltitle = home.getData().getList().get(0).getTitle();
                OkHttpClientManager.getAsyn(home.getData().getList().get(0).getListUrl(), new OkHttpClientManager.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Toast.makeText(getActivity(), "错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response) {
                        RoolView roolView = new Gson().fromJson(response, RoolView.class);
                        List<RoolView.ListBean> roolViewlist = roolView.getList();

                        if (roolViewlists.size() == 0) {
                            roolViewlists.addAll(roolViewlist);
                        }


                    }
                });

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (images.size() == 0 && titles.size() == 0) {
                            for (int i = 0; i < listim.size(); i++) {
                                images.add(listim.get(i).getImage());
                                titles.add(listim.get(i).getTitle());
                            }
                        }
                        Log.e("TAG", "run: " + images.size());
                        Log.e("TAG", "run: " + titles.size());
                        panda_Broadcast_Text.setText(HomeModule_Fragment.this.title);
                        zj_tv.setText(zj);
                        zj_tvs.setText(titlezj);
                        qs_tv.setText(brief);
                        qs_tvs.setText(titleqs);
                        Glide.with(getActivity()).load(pandaeyelogo).into(im_home);
                        //精彩一刻
                        wendforment_tv.setText(wnderfulmomnet);

                        twoGVAdapter = new TwoGVAdapter(wonderfullists);
                        gv_wendforment.setAdapter(twoGVAdapter);
                        //熊猫直播
                        gvAdapter = new GvAdapter(li);
                        home_gv.setAdapter(gvAdapter);
                        pbr.setVisibility(View.INVISIBLE);
                        gvAdapter.notifyDataSetChanged();
                        //滚滚视频
                        roll_tv.setText(rooltitle);
                        RoolViewAdapter roolViewAdapter = new RoolViewAdapter(roolViewlists);
                        homethree_gv.setAdapter(roolViewAdapter);

                        liveshwtv.setText(titlepandalive);
                        //直播中国
                        live_china.setText(chinalivetitle);
                        LiveAdapter liveAdapter = new LiveAdapter(chinaLivelists);
                        home_live_gv.setAdapter(liveAdapter);
                        //设置banner样式
                        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                        banner.setIndicatorGravity(BannerConfig.RIGHT);
                        banner.setBannerTitles(titles);
                        banner.setImages(images);

                        //banner设置方法全部调用完毕时最后调用
                        banner.start();
                        banner.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                switch (position) {
                                    case 1:
                                        Intent intent1 = new Intent(getActivity(), FristActivity.class);
                                          intent1.putExtra("url",bigImg.get(1).getUrl());
                                        getActivity().startActivity(intent1);

                                        break;
                                    case 2:
                                        Intent intent2 = new Intent(getActivity(), FristActivity.class);
                                        intent2.putExtra("url",bigImg.get(2).getUrl());
                                        getActivity().startActivity(intent2);
                                        break;
                                    case 3:
                                        Intent intent3 = new Intent(getActivity(), FristActivity.class);
                                        intent3.putExtra("url",bigImg.get(3).getUrl());
                                        getActivity().startActivity(intent3);
                                        break;
                                    case 4:
                                        Intent intent4= new Intent(getActivity(), FristActivity.class);
                                        intent4.putExtra("url",bigImg.get(4).getUrl());
                                        getActivity().startActivity(intent4);
                                        break;
                                }
                            }
                        });
                    }
                });


            }
        });

    }

    @Override
    protected void initView(View view) {
        imageView2 = (ImageView) view.findViewById(R.id.imageView2);
        imageView = (ImageView) view.findViewById(R.id.imageView);

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
        im_home = (ImageView) view.findViewById(R.id.im_home);
        liveshwtv = (TextView) view.findViewById(R.id.liveshwtv);
        home_gv = (GridView) view.findViewById(R.id.home_gv);
        gv_wendforment = (GridView) view.findViewById(R.id.gv_wendforment);
        wendforment_tv = (TextView) view.findViewById(R.id.wendforment_tv);
        homethree_gv = (ListView) view.findViewById(R.id.homethree_gv);
        home_live_gv = (GridView) view.findViewById(R.id.home_live_gv);
        roll_tv = (TextView) view.findViewById(R.id.roll_tv);
        live_china = (TextView) view.findViewById(R.id.live_china);

    }
}
