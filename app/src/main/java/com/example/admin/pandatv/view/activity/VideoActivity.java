package com.example.admin.pandatv.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.pandatv.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Vitamio.isInitialized(VideoActivity.this);
        videoView = (VideoView) findViewById(R.id.video);
        String video = getIntent().getStringExtra("video");
        videoView.setVideoPath(video);
        MediaController mediaController = new MediaController(VideoActivity.this);
        videoView.setOnPreparedListener(this);
        videoView.setMediaController(mediaController);

    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        videoView.start();
    }
}
