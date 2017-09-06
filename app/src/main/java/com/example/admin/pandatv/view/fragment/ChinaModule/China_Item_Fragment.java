package com.example.admin.pandatv.view.fragment.ChinaModule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.entity.ChinaAck;
import com.example.admin.pandatv.model.entity.LvieItemBean;
import com.example.admin.pandatv.view.adapter.China_Item_FragmentAdapter;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static com.example.admin.pandatv.R.id.china_dialog_below_recy;

/**
 * Created by lenovo on 2017/8/26.
 *  直播中国内容Fragment
 */

public class China_Item_Fragment extends BaseFragment{
    private Bundle bundle;
    private China_Item_FragmentAdapter adapter;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            china_progress.setVisibility(View.VISIBLE);
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            china_progress.setVisibility(View.GONE);
                        }
                    });
                }
            };
            timer.schedule(timerTask,0,2000);
            bundle = intent.getBundleExtra("bundle");
            final ArrayList<LvieItemBean> list = new ArrayList<>();
            ArrayList<String> brief = bundle.getStringArrayList("brief");
            ArrayList<String> image = bundle.getStringArrayList("image");
            ArrayList<String> title = bundle.getStringArrayList("title");
            ArrayList<String> id = bundle.getStringArrayList("id");
            for (int i = 0; i < brief.size(); i++) {
                String url = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+id.get(i)+"&client=androidapp";
                String setUp = getSetUp(url);

                LvieItemBean bean = new LvieItemBean(setUp,brief.get(i)
                        ,image.get(i),title.get(i));
                list.add(bean);
            }
            china_recycler.setHasFixedSize(true);
            adapter = new China_Item_FragmentAdapter(getActivity(),list);
            china_recycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
            china_recycler.setAdapter(adapter);


        }
    };
    private RecyclerView china_recycler;
    private ProgressBar china_progress;
    private PtrFrameLayout china_item_pro;
    private String hls2;

    @Override
    public int getLayout() {
        return R.layout.china_fragment;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        JCVideoPlayer.releaseAllVideos();
        china_recycler = view.findViewById(R.id.china_recycler);
        china_progress = view.findViewById(R.id.china_progress);
        china_progress.setVisibility(View.VISIBLE);
        IntentFilter filter = new IntentFilter();
        filter.addAction("aaa");
        getActivity().registerReceiver(broadcastReceiver,filter);
        china_item_pro =  view.findViewById(R.id.china_item_pro);
        PtrClassicDefaultHeader header=new PtrClassicDefaultHeader(getActivity());
        china_item_pro.addPtrUIHandler(header);
        china_item_pro.setHeaderView(header);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            // load data here：fragment可见时执行加载数据或者进度条等

        }else {
            // fragment is no longer visible：不可见时不执行操作
        }
    }
    /**
     * 判断手机是否有网络
     *
     * @return true 有网络
     */
    public boolean isConnected() {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        try {
            ConnectivityManager connectivity = (ConnectivityManager) getActivity()
                    .getSystemService(getActivity().CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo info = connectivity.getActiveNetworkInfo();

                if (info != null && info.isConnected()) {
                    // 判断当前网络是否已经连接
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    public String getSetUp(String url){
        OkHttpClientManager.getAsyn(url, new OkHttpClientManager.ResultCallback<String>() {

            @Override
            public void onError(com.squareup.okhttp.Request request, Exception e) {

            }

            @Override
            public void onResponse(String response){
                final ChinaAck chinaAck = new Gson().fromJson(response, ChinaAck.class);

                getActivity().runOnUiThread(new Runnable() {



                    @Override
                    public void run() {
                        hls2 = chinaAck.getHls_url().getHls1();
                    }
                });

            }
        });

        return hls2;
    }
}
