package jp.facesmash;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Animation shake;
    SharedPreferences preferences;
    String dataName = "highscore";
    String intName = "score";
    int defaultInt = 0;
    //both activities can see this
    public static int hiScore = 0;
    public  Button buttonSettings, buttonFeedback;
    public ImageView imageViewFace;
    public TextView textView2, textViewTime, textViewHiScore;
    public int counter, score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        Music.playMusic(this, R.raw.bg);

        counter = 0;
        MainActivity.hiScore = 0;

        textViewHiScore = (TextView) findViewById(R.id.textViewHiScore);
        textView2 =(TextView)findViewById(R.id.textView2);
        textViewTime =(TextView)findViewById(R.id.textViewTime);
        imageViewFace = (ImageView) findViewById(R.id.imageViewFace);
        imageViewFace.setOnClickListener(this);
        buttonSettings=(Button) findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(this);
        buttonFeedback = (Button) findViewById(R.id.buttonFeedBack);
        buttonFeedback.setOnClickListener(this);


        preferences = getSharedPreferences(dataName, getApplicationContext().MODE_PRIVATE);
        //Either load our High score or
        //if not available our default of 0
        hiScore = preferences.getInt(intName, defaultInt);


        //Display the hi score
        textViewHiScore.setText("High Score: "+ hiScore);
    }






    @Override
    public void onClick(View v) {
        Intent intent;


        switch (v.getId()) {

            case R.id.buttonSettings:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonFeedBack:
                intent = new Intent(this, FeedbackActivity.class);
                startActivity(intent);
                break;
            case R.id.imageViewFace:
                counter++;
                imageViewFace.startAnimation(shake);

                if (counter == 1) {
                    new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            textViewTime.setText("seconds remaining: " + millisUntilFinished / 1000);
                        }

                        public void onFinish() {
                            textViewTime.setText("done!");
                            if (score > MainActivity.hiScore) {
                                MainActivity.hiScore = counter;
                                textViewHiScore.setText("Score: " + MainActivity.hiScore);
                                Intent intentHome = new Intent(MainActivity.this, ScoreActivity.class);
                                startActivity(intentHome);
                            } else {
                                counter = 0;
                                Toast.makeText(MainActivity.this, "You Lose! try again",
                                        Toast.LENGTH_LONG).show();

                            }
                        }
                    }.start();
                }

                textView2.setText("Score: " + counter);
                score = counter;
                break;
        }

    }
    }






