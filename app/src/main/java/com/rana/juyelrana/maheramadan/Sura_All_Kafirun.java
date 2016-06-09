package com.rana.juyelrana.maheramadan;

import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Sura_All_Kafirun extends AppCompatActivity {

    TextView tv;

    private MediaPlayer player;
    private int i = 0;
    private FloatingActionButton play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura__all__kafirun);

        tv = (TextView)findViewById(R.id.txt_sura_al_kafirun);
        tv.setMovementMethod(new ScrollingMovementMethod());

        player = MediaPlayer.create(this, R.raw.kafirun);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        play = (FloatingActionButton) findViewById(R.id.fab);
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.pause();
    }

}
