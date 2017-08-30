package com.example.admin.pandatv.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseActivity;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class RollingVideoActivity extends BaseActivity {


    private TextView videoTitle;
    private JCVideoPlayer rollingVideo;
    private int a = 1;
    private int b = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 123:
                    if (a==1){
                        rollingArrow.setImageResource(R.drawable.live_china_detail_up);
                    }else {
                        rollingArrow.setImageResource(R.drawable.live_china_detail_down);
                    }
                    break;
            }
        }
    };
    private ImageView rollingArrow;
    private TextView rollingIntroduction;
    private ImageView RollingCollection;
    private ImageView RollingShare;

    @Override
    protected void initListener() {
        findViewById(R.id.RollingBackwards).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.mBaseActivity.finish();
            }
        });
        rollingArrow .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a==1){
                    a=2;
                    rollingIntroduction.setVisibility(View.VISIBLE);
                }else {
                    a=1;
                    rollingIntroduction.setVisibility(View.GONE);
                }
                handler.sendEmptyMessage(123);
            }
        });
        RollingCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a==0){
                    RollingCollection.setImageResource(R.drawable.collect_yes);
                    RollingCollection.setEnabled(false);
                    Toast.makeText(App.mBaseActivity, "已添加，请到【我的收藏】中查看", Toast.LENGTH_SHORT).show();
                    RollingCollection.setEnabled(true);
                    a=1;
                }else {
                    RollingCollection.setImageResource(R.drawable.collect_no);
                    RollingCollection.setEnabled(false);
                    Toast.makeText(App.mBaseActivity, "已取消收藏", Toast.LENGTH_SHORT).show();
                    RollingCollection.setEnabled(true);
                    a=0;
                }
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        rollingVideo.setUp(intent.getStringExtra("video"),intent.getStringExtra("title"));
    }

    @Override
    protected void initView() {
        videoTitle = (TextView) findViewById(R.id.VideoTitle);
        rollingVideo = (JCVideoPlayer) findViewById(R.id.RollingVideo);
        rollingArrow = (ImageView) findViewById(R.id.RollingArrow);
        rollingIntroduction = (TextView) findViewById(R.id.RollingIntroduction);
        RollingCollection = (ImageView) findViewById(R.id.RollingCollection);
        RollingShare = (ImageView) findViewById(R.id.RollingShare);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_rolling_video;
    }
}
