package com.example.admin.pandatv.view.activity;

import android.content.Intent;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseActivity;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends BaseActivity {

    private Intent intent;
    private JCVideoPlayer videoView;

    @Override
    protected void initListener() {

    }

    @Override

    protected void initData() {

    }

    @Override
    protected void initView() {
        videoView = (JCVideoPlayer) findViewById(R.id.video);
     intent = getIntent();
   videoView.setUp(intent.getStringExtra("video"),intent.getStringExtra("title"));


      }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
