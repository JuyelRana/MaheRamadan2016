package com.rana.juyelrana.maheramadan;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AllahNintyNineNames extends AppCompatActivity {

    private MediaPlayer player;
    private int i = 0;
    private FloatingActionButton play;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allah_ninty_nine_names);

        player = MediaPlayer.create(this, R.raw.song);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        play = (FloatingActionButton) findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0) {
                    player.start();
                    i = 1;
                    play.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                } else if (i == 1) {
                    player.pause();

                    play.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
                    i = 0;
                }
            }
        });

//
//        FloatingActionButton pause = (FloatingActionButton) findViewById(R.id.pause);
//
//        pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                player.pause();
//            }
//        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("দোয়া");
    }

}
