package com.example.admin.pandatv.view.activity.banderavtivitys;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.activity.ShareActivity;
import com.example.admin.pandatv.view.base.BaseActivity;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class FristActivity extends BaseActivity implements MediaPlayer.OnPreparedListener {
    private VideoView vitamio_viedoview;
    private ImageView live_share;

    @Override
    protected void initListener() {

        live_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(FristActivity.this, ShareActivity.class);

                startActivity(intent);


            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = this.getIntent();
        String url = intent.getStringExtra("url");
        vitamio_viedoview = (VideoView) findViewById(R.id.vitamio_viedoviews);
        Vitamio.isInitialized(this);
        vitamio_viedoview.setVideoPath(url);
        vitamio_viedoview.setOnPreparedListener(this);
        vitamio_viedoview.setMediaController(new MediaController(this));
        live_share = (ImageView) findViewById(R.id.live_share);


    }

    @Override
    public int getLayoutId() {

        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_frist;
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
