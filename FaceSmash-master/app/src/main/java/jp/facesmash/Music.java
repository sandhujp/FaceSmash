package jp.facesmash;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by JP on 12/1/16.
 */

public class Music extends AppCompatActivity {

   static MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static void playMusic(Context context, int musicId){
        player = MediaPlayer.create(context, musicId);
        player.start();
        player.setLooping(true);


    }
}
