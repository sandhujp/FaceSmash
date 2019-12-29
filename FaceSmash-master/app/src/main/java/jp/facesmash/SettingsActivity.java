package jp.facesmash;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener
{

    public Button buttonOn, buttonOff, buttonBag, buttonDefault , buttonTurn;
    public ImageView imageViewSunset, imageViewPenguin, imageViewDrums;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buttonOn=(Button) findViewById(R.id.buttonOn);
        buttonOn.setOnClickListener(this);
        buttonOff=(Button) findViewById(R.id.buttonOff);
        buttonOff.setOnClickListener(this);
        buttonBag=(Button) findViewById(R.id.buttonBag);
        buttonBag.setOnClickListener(this);
        buttonTurn=(Button) findViewById(R.id.buttonTurn);
        buttonTurn.setOnClickListener(this);
        buttonDefault=(Button) findViewById(R.id.buttonDefault);
        buttonDefault.setOnClickListener(this);
        imageViewSunset = (ImageView)findViewById(R.id.imageViewSunset);
        imageViewPenguin = (ImageView)findViewById(R.id.imageViewPenguin);
        imageViewDrums = (ImageView)findViewById(R.id.imageViewDrums);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.buttonOff:

                Music.player.pause();
                break;
            case R.id.buttonOn:
                Music.player.start();
                break;
            case R.id.buttonBag:
                Music.player.stop();
                imageViewSunset.setVisibility(View.INVISIBLE);
                imageViewDrums.setVisibility(View.INVISIBLE);
                imageViewPenguin.setVisibility(View.VISIBLE);
                Music.playMusic(this, R.raw.tobaggan);
                Music.player.start();
                break;
            case R.id.buttonTurn:
                imageViewPenguin.setVisibility(View.INVISIBLE);
                imageViewDrums.setVisibility(View.INVISIBLE);
                imageViewSunset.setVisibility(View.VISIBLE);
                Music.player.stop();
                Music.playMusic(this, R.raw.turn);
                Music.player.start();
                break;
            case R.id.buttonDefault:
                imageViewPenguin.setVisibility(View.INVISIBLE);
                imageViewSunset.setVisibility(View.INVISIBLE);
                imageViewDrums.setVisibility(View.VISIBLE);
                Music.player.stop();
                Music.playMusic(this, R.raw.bg);
                Music.player.start();
                break;
        }

    }


}

