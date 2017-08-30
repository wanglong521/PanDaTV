package com.example.admin.pandatv.view.fragment.ChinaModule;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.entity.LvieItemBean;
import com.example.admin.pandatv.view.activity.MainActivity;
import com.example.admin.pandatv.view.adapter.China_Item_FragmentAdapter;
import com.example.admin.pandatv.view.base.BaseFragment;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static android.R.attr.filter;
import static android.R.id.list;

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
            for (int i = 0; i < brief.size(); i++) {
                LvieItemBean bean = new LvieItemBean(brief.get(i)
                        ,image.get(i),title.get(i));
                list.add(bean);
            }
            adapter = new China_Item_FragmentAdapter(getActivity(),list);
            china_recycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
            china_recycler.setAdapter(adapter);


        }
    };
    private RecyclerView china_recycler;
    private ProgressDialog dialog;
    private ProgressBar china_progress;
    private PtrFrameLayout china_item_pro;

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

}
