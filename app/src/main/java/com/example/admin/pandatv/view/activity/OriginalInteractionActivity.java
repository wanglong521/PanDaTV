package com.example.admin.pandatv.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.bean.Original;
import com.example.admin.pandatv.view.adapter.OriginalAdapter;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseActivity;
import com.example.admin.pandatv.view.base.UrlUtils;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class OriginalInteractionActivity extends BaseActivity {
    PtrClassicFrameLayout ptrFrameLayout;
    Toolbar toolbr;
    ListView Yuanchuang_gv;
    ProgressBar p;
    List<Original.InteractiveBean> li = new ArrayList<>();
    private OriginalAdapter originalAdapter;

    @Override
    protected void initListener() {
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(this);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(this);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.setFooterView(footer);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.addPtrUIHandler(footer);

        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                Log.e("MainActivity", "开始加载更多");

                initData();
                ptrFrameLayout.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.e("MainActivity", "开始下拉刷新");
                ptrFrameLayout.refreshComplete();
            }
        });

    }

    @Override
    protected void initData() {
        OkHttpClientManager.getAsyn(UrlUtils.ORIGINAL, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Original original = new Gson().fromJson(response, Original.class);
                final List<Original.InteractiveBean> interactive = original.getInteractive();
                if (li.size() == 0) {
                    li.addAll(interactive);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        p.setVisibility(View.INVISIBLE);
                        originalAdapter = new OriginalAdapter(li);
                        Yuanchuang_gv.setAdapter(originalAdapter);
                        Yuanchuang_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent = new Intent(OriginalInteractionActivity.this, OriginalInteractiveDetailsActivity.class);
                                intent.putExtra("name", interactive.get(i).getTitle());
                                intent.putExtra("url", interactive.get(i).getUrl());
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    protected void initView() {
        ptrFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.ptr);
        toolbr = (Toolbar) findViewById(R.id.Yuanchuang_toolbar);
        toolbr.setNavigationIcon(R.drawable.personal_back_img);
        toolbr.setTitle("");
        App.mBaseActivity.setSupportActionBar(toolbr);
        toolbr.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Yuanchuang_gv = (ListView) findViewById(R.id.Yuanchuang_gv);
        p = (ProgressBar) findViewById(R.id.p);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_original_interaction;
    }
}
