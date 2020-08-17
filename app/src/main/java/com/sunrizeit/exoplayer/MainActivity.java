package com.sunrizeit.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import java.io.File;

public class MainActivity extends AppCompatActivity {
PlayerView playerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerView=findViewById(R.id.video_view);
        initializePlayer();
    }

    private void initializePlayer() {
        SimpleExoPlayer player= ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(this),
                new DefaultTrackSelector(),
                new DefaultLoadControl());
        String filepath;
        filepath = Environment.getExternalStorageDirectory()+ File.separator+
                "video"+File.separator+"video1.mp4";
        Log.e("filepath",filepath);
        Uri uri=Uri.parse(filepath);
        ExtractorMediaSource audioSource=new ExtractorMediaSource(
                uri,
                new DefaultDataSourceFactory(this,"MyExoplayer"),
                new DefaultExtractorsFactory(),
                null,
                null);
            player.prepare(audioSource);
            playerView.setPlayer(player);
            player.setPlayWhenReady(true);



    }
}
