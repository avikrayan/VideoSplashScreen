package com.example.avik.videosplashscreen;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.VideoView;

public class SplashScreen extends AppCompatActivity {

    VideoView videoView;
    private LinearLayout btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ad);
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        videoView.start();

        btnSkip = (LinearLayout) findViewById(R.id.btnSkip);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.stopPlayback();
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        });
    }

    private void startNextActivity() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
