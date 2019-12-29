package jp.facesmash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView textView3;
    Animation rotate;


        TextView textHighScore,win;
        SharedPreferences preferences;
        String dataName = "highscore";
        String intName = "score";
        int defaultInt = 0;
        int hiScoreWinner;
        SharedPreferences.Editor editor;
        ImageView imageView;
        TextView yougotnewhighscore;
        Button playagain;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_score);

            preferences = getSharedPreferences(dataName, getApplicationContext().MODE_PRIVATE);
            editor = preferences.edit();
            rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);


            //get previous highscore
            hiScoreWinner = preferences.getInt(intName, defaultInt);
            Log.d("Hi score winner: ",""+hiScoreWinner);
            Log.d("Hi Hiscore: ",""+MainActivity.hiScore);

            textHighScore = (TextView) findViewById(R.id.textHighScore);
            win = (TextView) findViewById(R.id.win);
            yougotnewhighscore = (TextView) findViewById(R.id.yougotnewhighscore);
            playagain = (Button) findViewById(R.id.playagain);
            playagain.startAnimation(rotate);
            playagain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Music.player.stop();
                    Intent intent = new Intent(ScoreActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            textHighScore.setText("Score: "+MainActivity.hiScore);
            editor.putInt(intName,MainActivity.hiScore);
            editor.commit();
            Log.d("Saved Score: ", String.valueOf(preferences.getInt("score",1)));
        }



    }

