package com.example.admin.pandatv.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.pandatv.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class Main2Activity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Vitamio.isInitialized(Main2Activity.this);
        videoView = (VideoView) findViewById(R.id.video);
        videoView.setVideoPath("https://vfx.mtime.cn/Video/2017/07/27/mp4/170727100951771139.mp4");
        MediaController mediaController = new MediaController(Main2Activity.this);
        videoView.setOnPreparedListener(this);
        videoView.setMediaController(mediaController);

    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        videoView.start();
    }
}
