package com.example.musiapp;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button play,pause,stop ;
    MediaPlayer mediaplayer;
int currentposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);


        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        play.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.play:
                if(mediaplayer==null) {
                    mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.tamil);
                    mediaplayer.start();
                }
                else if(!mediaplayer.isPlaying())
                {
                    mediaplayer.seekTo(currentposition);
                    mediaplayer.start();

                }
                break;
            case R.id.pause:
                if(mediaplayer!=null)
                {
                    mediaplayer.pause();
                    currentposition=mediaplayer.getCurrentPosition();
                }

            case R.id.stop:
                mediaplayer.stop();
                mediaplayer=null;




        }
    }
}
