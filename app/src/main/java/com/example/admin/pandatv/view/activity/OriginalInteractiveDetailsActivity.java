package com.example.admin.pandatv.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseActivity;

public class OriginalInteractiveDetailsActivity extends BaseActivity {
    private WebView wv;
    private TextView xiangqingtitle;
    private String url;
    private String name;
    private ImageView share_im;
private Toolbar toolbar;
    @Override
    protected void initListener() {
        /**
         * 分享监听
         */
        share_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = this.getIntent();
        name = intent.getStringExtra("name");
        url = intent.getStringExtra("url");
        wv = (WebView) findViewById(R.id.web);
        toolbar = (Toolbar) findViewById(R.id.Yuanchuangdetails_toolbar);
        toolbar.setNavigationIcon(R.drawable.personal_back_img);
        toolbar.setTitle("");
        App.mBaseActivity.setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /**
         * 标题
         */
        xiangqingtitle = (TextView) findViewById(R.id.xiangqingtitle);
        /**
         * 分享
         */
        share_im = (ImageView) findViewById(R.id.share_im);
        xiangqingtitle.setText(name);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_original_interactive_details;
    }
}
