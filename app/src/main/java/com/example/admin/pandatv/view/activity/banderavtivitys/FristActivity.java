package com.example.admin.pandatv.view.activity.banderavtivitys;

import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseActivity;

public class FristActivity extends BaseActivity{
private  WebView wv;
private LinearLayout li;
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = this.getIntent();
        String url = intent.getStringExtra("url");

        wv = (WebView) findViewById(R.id.wv);
        li = (LinearLayout) findViewById(R.id.li);
        WebSettings settings = wv.getSettings();
        //wv必须设置支持JavaScript
        settings.setJavaScriptEnabled(true);
        //设置自适应平面，两者合用
        settings.setUseWideViewPort(true);//图片调整到适应wv大小
        settings.setLoadWithOverviewMode(true);//缩放至屏幕大小
        //缩放操作
        settings.setSupportZoom(true);//支持缩放，是下面那个的前提
        settings.setBuiltInZoomControls(true);//设置内置的缩放控件
        settings.setDisplayZoomControls(false);//隐藏原生的缩放控件
        //其他细节操作
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//关闭wv缓存
        settings.setAllowFileAccess(true);//设置可以访问文件
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//支持通过Js打开新窗口
        settings.setLoadsImagesAutomatically(true);//支持自动加载图片
        settings.setDefaultTextEncodingName("utf-8");//设置编码格式

        //选择加载方式
        //1.加载一个网页
        wv.loadUrl(url);
        //2.加载apk中的HTML页面
        //wv.loadUrl("file:///android_assets/text.html");
        //3.加载手机本地的html页面
        //wv.loadUrl("content://"com.android.htmlfileprovider/sdcard/text.html");
        // 步骤3   调用shouldOverrideUrlLoading方法，使打开网页不用系统浏览器，在本页面显示
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });



    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_frist;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        li.removeView(wv);
        wv.destroy();
    }
}
