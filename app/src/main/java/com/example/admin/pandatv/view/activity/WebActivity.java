package com.example.admin.pandatv.view.activity;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseActivity;

public class WebActivity extends BaseActivity {


    private ImageView WebCollection;
    private ImageView WebShare;
    private WebView webView;
    private int a = 0 ;

    @Override
    protected void initListener() {
        WebCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a==0){
                    WebCollection.setImageResource(R.drawable.collect_yes);
                    WebCollection.setEnabled(false);
                    Toast.makeText(WebActivity.this, "已添加，请到【我的收藏】中查看", Toast.LENGTH_SHORT).show();
                    WebCollection.setEnabled(true);
                    a=1;
                }else {
                    WebCollection.setImageResource(R.drawable.collect_no);
                    WebCollection.setEnabled(false);
                    Toast.makeText(WebActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                    WebCollection.setEnabled(true);
                    a=0;
                }
            }
        });
    }

    @Override
    protected void initData() {
        String imageurl = getIntent().getStringExtra("imageurl");
        webView.loadUrl(imageurl);
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.WebView);
        WebCollection = (ImageView) findViewById(R.id.WebCollection);
        WebShare = (ImageView) findViewById(R.id.WebShare);
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        findViewById(R.id.Backwards).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.mBaseActivity.finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }


}
