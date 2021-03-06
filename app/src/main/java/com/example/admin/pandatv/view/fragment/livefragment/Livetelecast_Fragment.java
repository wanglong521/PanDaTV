package com.example.admin.pandatv.view.fragment.livefragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.bean.LiveShow;
import com.example.admin.pandatv.model.entity.livapandabean.LiveMBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImplLivemBean;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.LiveMBeanView;
import com.example.admin.pandatv.view.base.UrlUtils;
import com.example.admin.pandatv.view.fragment.livefragment.lfragment.Lookalittle;
import com.example.admin.pandatv.view.fragment.livefragment.lfragment.MoreLiveFragment;
import com.example.admin.pandatv.view.view.WrapContentHeightViewPager;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by LiYRong on 2017/8/25.
 *
 *          直播
 *
 */
//这是小媛荣的代码
public class Livetelecast_Fragment extends BaseFragment implements LiveMBeanView,io.vov.vitamio.MediaPlayer.OnPreparedListener {

    private JCVideoPlayer  live_img;
    private TextView live_title;
    private ImageView live_up;
    private TextView brief;
    private View oneself;
    private  TabLayout live_tablayout;
    private WrapContentHeightViewPager live_viewpager;
    private List<LiveMBean> liveMBeen=new ArrayList<LiveMBean>();
    private int NUM=1;
    private List<String> tabnamelist;
    private List<Fragment> fragmentlist=new ArrayList<Fragment>();

    private String URLIVE;
    private String LIVEB;
    private ImageView bfing;
    private RelativeLayout live_re;
    private ImageView lve_img;
    private String hls1;
    private String network;
    private String liv_title;
    private String hls2;
    private ProgressBar bar;
    private LinearLayout linear;

    @Override
    public int getLayout() {
        return R.layout.livetelecast_item;
    }

    @Override
    protected void initListener() {

        bar.setVisibility(View.GONE);
        linear.setVisibility(View.VISIBLE);
        live_up.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                if (NUM == 1) {
                    brief.setVisibility(View.VISIBLE);
                    oneself.setVisibility(View.VISIBLE);
                    live_up.setImageResource(R.drawable.live_up);
                     NUM++;
                }else{
                    brief.setVisibility(View.GONE);
                    oneself.setVisibility(View.GONE);
                    live_up.setImageResource(R.drawable.live_down);
                    NUM--;
                }

            }
        });

        fragmentlist.clear();
        fragmentlist.add(new MoreLiveFragment());
        fragmentlist.add(new Lookalittle());

        //这里是点击按钮然后视屏开始播放

        bfing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                live_img.setVisibility(View.VISIBLE);

                live_re.setVisibility(View.GONE);
                lve_img.setVisibility(View.GONE);

//                LIVEB="";
/*
                Vitamio.isInitialized(getActivity());
/*        http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd" + livelist.get(position).getId() + "&client=androidapp")*/
               String CD="http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=u50YiaMPwsAnMa/F569M06USVaqoGbQ/BSQW/Bwf3vxmqOOLuTmiRXMxrbrj3s3tbAdWWS2ucXtLeNduoWA/Lg==";

//                live_img.setVideoPath(LIVEB);
//                live_img.setOnPreparedListener(App.mBaseFragment);
//                live_img.setMediaController(new MediaController(getActivity()));

                live_img.setUp(CD,"熊猫直播");

                bfing.setVisibility(View.GONE);

            }
        });

    }
    @Override
    protected void initData() {
//        bar.setVisibility(View.VISIBLE);
        tabnamelist=new ArrayList<>();
        IPresenterImplLivemBean iPresenterImplLivemBean=new IPresenterImplLivemBean(this);
        iPresenterImplLivemBean.Getcontroller();

    }

    @Override
    protected void initView(View view) {

        live_img = view.findViewById(R.id.livetel_img);
        live_title = view.findViewById(R.id.live_title);
        live_up = view.findViewById(R.id.live_up);
        brief = view.findViewById(R.id.brief);
        oneself = view.findViewById(R.id.oneself);
        lve_img = view.findViewById(R.id.lve_img);

        bfing = view.findViewById(R.id.bfang);

        live_re = view.findViewById(R.id.live_re);
        bar = view.findViewById(R.id.bar);
        linear = view.findViewById(R.id.linear);

        live_tablayout = view.findViewById(R.id.live_tablayout);
        live_viewpager = view.findViewById(R.id.live_viewpager);
        live_tablayout.setupWithViewPager(live_viewpager);

    }

    @Override
    public void OnSucceed(LiveMBean succed) {


      liveMBeen.add(succed);

        tabnamelist.clear();

            for (LiveMBean item :
                    liveMBeen) {
                List<LiveMBean.LiveBean> live = item.getLive();

            LiveMBean.BookmarkBean bookmark = item.getBookmark();



                List<LiveMBean.BookmarkBean.MultipleBean> multiple = bookmark.getMultiple();
                for (LiveMBean.BookmarkBean.MultipleBean multipleBean :
                        multiple) {

                    tabnamelist.add(multipleBean.getTitle());

                }

                List<LiveMBean.BookmarkBean.WatchTalkBean> watchTalk = bookmark.getWatchTalk();

                for (LiveMBean.BookmarkBean.WatchTalkBean watchTalkBean :
                        watchTalk) {

                    tabnamelist.add(watchTalkBean.getTitle());

                }


            for (LiveMBean.LiveBean bean:
            live){

                Glide.with(getActivity()).load(bean.getImage()).into(lve_img);

                live_title.setText(bean.getTitle());

                brief.setText(bean.getBrief());

                URLIVE= UrlUtils.LIVESHOW+bean.getId()+"&client=androidapp";

            }

        }
        //        这里是接受广播的
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(getActivity());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("abcc");
        BroadcastReceiver mItemViewListClickReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent){
                network = intent.getStringExtra("network");

                liv_title = intent.getStringExtra("title");
                live_title.setText(liv_title);

                //这里是网络请求到视屏播放的地址

                OkHttpClientManager.getAsyn(network, new OkHttpClientManager.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {

                        LIVEB="";
                        LiveShow liveShow = new Gson().fromJson(response, LiveShow.class);
                        hls2 = liveShow.getHls_url().getHls1();

                        LIVEB=hls2;

                        live_img.setUp(LIVEB,"熊猫直播");
                    }
                });


            }
        };
        broadcastManager.registerReceiver(mItemViewListClickReceiver, intentFilter);

//这里是网络请求到视屏播放的地址

//        OkHttpClientManager.getAsyn(URLIVE, new OkHttpClientManager.ResultCallback<String>() {
//            @Override
//            public void onError(Request request, Exception e) {
//
//            }
//
//            @Override
//            public void onResponse(String response) {
//
//                LIVEB="";
//                LiveShow liveShow = new Gson().fromJson(response, LiveShow.class);
//
//                LIVEB=hls1;
//                hls1 = liveShow.getHls_url().getHls1();
//
//                Log.i("BBB",hls1);
//            }
//        });

        live_tablayout.addTab(live_tablayout.newTab().setText(tabnamelist.get(0)));
        live_tablayout.addTab(live_tablayout.newTab().setText(tabnamelist.get(1)));
        FragmentManager manager = getActivity().getSupportFragmentManager();

        MyliveAdapter adapter=new MyliveAdapter(manager);

        live_viewpager.setAdapter(adapter);

    }

    @Override
    public void OnDefeated() {

        Log.e("TAG","请求失败");

    }

    public  class MyliveAdapter extends FragmentPagerAdapter {

        public MyliveAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override//返回对应位置的
        public Fragment getItem(int position) {

            return fragmentlist.get(position);
        }

        @Override//赶回viewpage总条目数
        public int getCount() {

            return fragmentlist.size();
        }

        @Override
        //给TabLayout加标题   与TabLayout起使用
        public CharSequence getPageTitle(int position)
        {
            return tabnamelist.get(position);
        }
    }
}
