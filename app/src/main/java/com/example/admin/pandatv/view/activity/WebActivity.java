package com.example.admin.pandatv.view.activity;

import android.webkit.WebView;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseActivity;

public class WebActivity extends BaseActivity {


    private ImageView WebCollection;
    private ImageView WebShare;
    private WebView webView;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.WebView);
        WebCollection = (ImageView) findViewById(R.id.WebCollection);
        WebShare = (ImageView) findViewById(R.id.WebShare);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }


}
