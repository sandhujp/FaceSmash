package jp.facesmash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer start;
    Animation fade;
    ImageView imageViewRedFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        int secondsDelayed = 1;
        imageViewRedFace = (ImageView) findViewById(R.id.imageViewRedFace);
        imageViewRedFace.startAnimation(fade);
        start= MediaPlayer.create(this, R.raw.start);
        start.start();
        new Handler().postDelayed(new Runnable() {
            public void run() {


                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
                start.stop();
            }
        },  secondsDelayed * 3000);


    }
}
