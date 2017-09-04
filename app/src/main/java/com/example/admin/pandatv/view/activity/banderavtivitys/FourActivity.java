package com.example.admin.pandatv.view.activity.banderavtivitys;

import android.content.Intent;
import android.view.WindowManager;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseActivity;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class FourActivity extends BaseActivity implements MediaPlayer.OnPreparedListener {
    private VideoView vitamio_viedoview;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = this.getIntent();
        String url = intent.getStringExtra("url4");
        vitamio_viedoview = (VideoView) findViewById(R.id.vitamio_viedoviewfour);
        Vitamio.isInitialized(this);
        vitamio_viedoview.setVideoPath(url);

        vitamio_viedoview.setOnPreparedListener(this);
        vitamio_viedoview.setMediaController(new MediaController(this));

    }

    @Override
    public int getLayoutId() {
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_four;
    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        vitamio_viedoview.start();
    }

    @Override
    protected void onDestroy() {
        vitamio_viedoview.setVideoPath("");
        vitamio_viedoview.stopPlayback();
        super.onDestroy();
    }
}
