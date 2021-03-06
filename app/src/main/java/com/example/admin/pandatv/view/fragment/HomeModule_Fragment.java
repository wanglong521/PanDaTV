package com.example.admin.pandatv.view.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.bean.FLFBen;
import com.example.admin.pandatv.model.bean.Home;
import com.example.admin.pandatv.model.bean.LiveShow;
import com.example.admin.pandatv.model.bean.RoolView;
import com.example.admin.pandatv.model.bean.Wonderful;
import com.example.admin.pandatv.view.activity.LoginActivity;
import com.example.admin.pandatv.view.activity.OriginalInteractionActivity;
import com.example.admin.pandatv.view.activity.banderavtivitys.FourActivity;
import com.example.admin.pandatv.view.activity.banderavtivitys.FristActivity;
import com.example.admin.pandatv.view.activity.banderavtivitys.SecondActivity;
import com.example.admin.pandatv.view.activity.banderavtivitys.ThirdActivity;
import com.example.admin.pandatv.view.adapter.GvAdapter;
import com.example.admin.pandatv.view.adapter.HomeXRVAdapter;
import com.example.admin.pandatv.view.adapter.RoolViewAdapter;
import com.example.admin.pandatv.view.adapter.TwoGVAdapter;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.UrlUtils;
import com.example.admin.pandatv.view.customview.GlideImageLoader;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
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
    String Fristurl;
    View header, broadheader, livebheader, marvellousheader, videoheader;

    XRecyclerView xrv;
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
    private String url;
    private String url2;
    private String url3;
    private String url4;
    private List<Home.DataBean.PandaeyeBean.ItemsBean> items;
    private HomeXRVAdapter homeXRVAdapter;
    private HomeXRVAdapter homeXRVAdapter1;
    private String vid;
    private String uri;
    private String vid1;

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
        //熊猫播报第一个
        zj_tvs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid = items.get(0).getPid();
                OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + pid, new OkHttpClientManager.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                        url = flfBen.getVideo().getChapters().get(0).getUrl();
                        Log.e("TAG", "onResponse: " + url.toString());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(getActivity(), FristActivity.class);
                                intent1.putExtra("url", url);
                                getActivity().startActivity(intent1);
                            }
                        });


                    }
                });

            }
        });
        //熊猫播报第一个
        qs_tvs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid = items.get(1).getPid();
                OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + pid, new OkHttpClientManager.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                        url = flfBen.getVideo().getChapters().get(0).getUrl();
                        Log.e("TAG", "onResponse: " + url.toString());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(getActivity(), FristActivity.class);
                                intent1.putExtra("url", url);
                                getActivity().startActivity(intent1);
                            }
                        });


                    }
                });

            }
        });

    }

    @Override
    protected void initData() {

        banner = (Banner) header.findViewById(R.id.banner);
        panda_Broadcast_Text = (TextView) broadheader.findViewById(R.id.panda_Broadcast_Text);
        zj_tv = (TextView) broadheader.findViewById(R.id.zj_tv);
        zj_tvs = (TextView) broadheader.findViewById(R.id.zj_tvs);


        qs_tv = (TextView) broadheader.findViewById(R.id.qs_tv);
        qs_tvs = (TextView) broadheader.findViewById(R.id.qs_tvs);


        im_home = (ImageView) broadheader.findViewById(R.id.im_home);
        liveshwtv = (TextView) livebheader.findViewById(R.id.liveshwtv);
        home_gv = (GridView) livebheader.findViewById(R.id.home_gv);
        gv_wendforment = (GridView) marvellousheader.findViewById(R.id.gv_wendforment);
        wendforment_tv = (TextView) marvellousheader.findViewById(R.id.wendforment_tv);
        homethree_gv = (ListView) videoheader.findViewById(R.id.homethree_gv);

        roll_tv = (TextView) videoheader.findViewById(R.id.roll_tv);

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
                items = home.getData().getPandaeye().getItems();
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
                        //精彩一刻点击事件

                        gv_wendforment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String pid = wonderfullists.get(i).getPid();
                                OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + pid, new OkHttpClientManager.ResultCallback<String>() {
                                    @Override
                                    public void onError(Request request, Exception e) {

                                    }

                                    @Override
                                    public void onResponse(String response) {
                                        FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                                        url = flfBen.getVideo().getChapters().get(0).getUrl();
                                        Log.e("TAG", "onResponse: " + url.toString());
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent intent1 = new Intent(getActivity(), FristActivity.class);
                                                intent1.putExtra("url", url);
                                                getActivity().startActivity(intent1);
                                            }
                                        });


                                    }
                                });

                            }
                        });

                        //直播秀场
                        gvAdapter = new GvAdapter(li);
                        home_gv.setAdapter(gvAdapter);
                        // TODO: 2017/9/5 这里是直播用的
                        //直播秀场点击事件
                        home_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                vid = li.get(i).getId();
                                Log.e("ZZZ", "onItemClick:" + vid.toString());//ipanda

                                //http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hdipanda&client=androidapp
                                OkHttpClientManager.getAsyn(UrlUtils.LIVESHOW + vid + "&client=androidapp", new OkHttpClientManager.ResultCallback<String>() {
                                    @Override
                                    public void onError(Request request, Exception e) {

                                    }

                                    @Override
                                    public void onResponse(String response) {
                                        LiveShow liveShow = new Gson().fromJson(response, LiveShow.class);
                                        final String hls1 = liveShow.getHls_url().getHls1();
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent intent=new Intent(getActivity(),FristActivity.class);
                                                intent.putExtra("url",hls1);
                                                getActivity().startActivity(intent);

                                            }
                                        });
                                    }
                                });
                            }
                        });

                        gvAdapter.notifyDataSetChanged();
                        //滚滚视频
                        roll_tv.setText(rooltitle);
                        RoolViewAdapter roolViewAdapter = new RoolViewAdapter(roolViewlists);
                        homethree_gv.setAdapter(roolViewAdapter);

                        liveshwtv.setText(titlepandalive);
                        //滚滚点击事件

                        homethree_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String pid = roolViewlists.get(i).getPid();
                                OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + pid, new OkHttpClientManager.ResultCallback<String>() {
                                    @Override
                                    public void onError(Request request, Exception e) {

                                    }

                                    @Override
                                    public void onResponse(String response) {
                                        FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                                        url = flfBen.getVideo().getChapters().get(0).getUrl();
                                        Log.e("TAG", "onResponse: " + url.toString());
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent intent1 = new Intent(getActivity(), FristActivity.class);
                                                intent1.putExtra("url", url);
                                                getActivity().startActivity(intent1);
                                            }
                                        });


                                    }
                                });

                            }
                        });
                        //直播中国
                        homeXRVAdapter = new HomeXRVAdapter(getActivity(), chinaLivelists);
//                        xrv.setadapte(homeXRVAdapter);
                        xrv.setAdapter(homeXRVAdapter);
                        //直播中国条目点击事件

                        homeXRVAdapter.setOnclicklinster(new HomeXRVAdapter.onclicklinster() {
                            @Override
                            public void onItemClick(int ppp) {
                                vid1 = chinaLivelists.get(ppp).getId();
                                Log.e("TAG", "onItemClick:" + vid1.toString());
                                OkHttpClientManager.getAsyn(UrlUtils.LIVESHOW + vid1 + "&client=androidapp", new OkHttpClientManager.ResultCallback<String>() {
                                    @Override
                                    public void onError(Request request, Exception e) {

                                    }

                                    @Override
                                    public void onResponse(String response) {
                                        LiveShow liveShow = new Gson().fromJson(response, LiveShow.class);
                                        final String hls2 = liveShow.getHls_url().getHls1();
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent intent = new Intent(getActivity(), FristActivity.class);
                                                intent.putExtra("url", hls2);
                                                getActivity().startActivity(intent);
                                            }
                                        });
                                    }
                                });
                            }
                        });


                        //设置banner样式
                        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                        banner.setIndicatorGravity(BannerConfig.RIGHT);
                        banner.setBannerTitles(titles);
                        banner.setImages(images);

                        //banner设置方法全部调用完毕时最后调用
                        banner.start();

                        pbr.setVisibility(View.INVISIBLE);

                        banner.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                switch (position) {
                                    case 0:
                                        String pid1 = bigImg.get(0).getPid();

                                        String title1 = bigImg.get(0).getTitle();
                                        OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + pid1, new OkHttpClientManager.ResultCallback<String>() {
                                            @Override
                                            public void onError(Request request, Exception e) {

                                            }

                                            @Override
                                            public void onResponse(String response) {
                                                FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                                                url = flfBen.getVideo().getChapters().get(0).getUrl();
                                                Log.e("TAG", "onResponse: " + url.toString());
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Intent intent1 = new Intent(getActivity(), FristActivity.class);
                                                        intent1.putExtra("url", url);
                                                        getActivity().startActivity(intent1);
                                                    }
                                                });


                                            }
                                        });

                                        break;
                                    case 1:
                                        String pid2 = bigImg.get(1).getPid();

                                        String title2 = bigImg.get(1).getTitle();
                                        OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + pid2, new OkHttpClientManager.ResultCallback<String>() {
                                            @Override
                                            public void onError(Request request, Exception e) {

                                            }

                                            @Override
                                            public void onResponse(String response) {
                                                FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                                                url2 = flfBen.getVideo().getChapters().get(0).getUrl();
                                                Log.e("TAG", "onResponse: " + url2.toString());
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Intent intent2 = new Intent(getActivity(), SecondActivity.class);
                                                        intent2.putExtra("url2", url2);
                                                        getActivity().startActivity(intent2);
                                                    }
                                                });


                                            }
                                        });
                                        break;
                                    case 2:
                                        String pid3 = bigImg.get(2).getPid();

                                        String title3 = bigImg.get(2).getTitle();
                                        OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + pid3, new OkHttpClientManager.ResultCallback<String>() {
                                            @Override
                                            public void onError(Request request, Exception e) {

                                            }

                                            @Override
                                            public void onResponse(String response) {
                                                FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                                                url3 = flfBen.getVideo().getChapters().get(0).getUrl();
                                                Log.e("TAG", "onResponse: " + url3.toString());
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Intent intent3 = new Intent(getActivity(), ThirdActivity.class);
                                                        intent3.putExtra("url3", url3);
                                                        getActivity().startActivity(intent3);
                                                    }
                                                });


                                            }
                                        });
                                        break;
                                    case 3:
                                        String pid4 = bigImg.get(3).getPid();

                                        String title4 = bigImg.get(3).getTitle();
                                        OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + pid4, new OkHttpClientManager.ResultCallback<String>() {
                                            @Override
                                            public void onError(Request request, Exception e) {

                                            }

                                            @Override
                                            public void onResponse(String response) {
                                                FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                                                url4 = flfBen.getVideo().getChapters().get(0).getUrl();
                                                Log.e("TAG", "onResponse: " + url4.toString());
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Intent intent4 = new Intent(getActivity(), FourActivity.class);
                                                        intent4.putExtra("url4", url4);
                                                        getActivity().startActivity(intent4);
                                                    }
                                                });


                                            }
                                        });
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
        pbr = (ProgressBar) view.findViewById(R.id.pbr);
        toolbr = (Toolbar) view.findViewById(R.id.toolbar);
        toolbr.setNavigationIcon(R.mipmap.panda_sign);
        toolbr.setTitle("");
        App.mBaseActivity.setSupportActionBar(toolbr);
        xrv = (XRecyclerView) view.findViewById(R.id.xrv);
        imageView2 = (ImageView) view.findViewById(R.id.imageView2);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        //轮播图
        header = LayoutInflater.from(getActivity()).inflate(R.layout.home_banner, (ViewGroup) getActivity().findViewById(android.R.id.content), false);
        //熊猫播报
        broadheader = LayoutInflater.from(getActivity()).inflate(R.layout.home_broadheader, (ViewGroup) getActivity().findViewById(android.R.id.content), false);
        //直播秀场
        livebheader = LayoutInflater.from(getActivity()).inflate(R.layout.home_livebroadheader, (ViewGroup) getActivity().findViewById(android.R.id.content), false);
        //精彩一刻
        marvellousheader = LayoutInflater.from(getActivity()).inflate(R.layout.home_marvellousheader, (ViewGroup) getActivity().findViewById(android.R.id.content), false);
        //滚滚视频
        videoheader = LayoutInflater.from(getActivity()).inflate(R.layout.home_videoheader, (ViewGroup) getActivity().findViewById(android.R.id.content), false);

        xrv.addHeaderView(header);
        xrv.addHeaderView(broadheader);
        xrv.addHeaderView(livebheader);
        xrv.addHeaderView(marvellousheader);
        xrv.addHeaderView(videoheader);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        xrv.setLayoutManager(manager);
        xrv.setRefreshProgressStyle(ProgressStyle.SysProgress);
        xrv.setArrowImageView(R.drawable.custom_tab_indicator_selected2);

        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrv.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                xrv.refreshComplete();

            }
        });
    }
}

