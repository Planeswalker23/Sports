package com.nanbei.sports;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MusicDemo extends Activity {

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Button btstartmusictest;
    private Button btendmusictest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicdemo);

        btstartmusictest = (Button) findViewById(R.id.buttonstartmusictest);
        btstartmusictest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    initMediaPlayer(R.raw.startmusic);//初始化MediaPlayer的开始运动资源
                    mediaPlayer.start(); // 开始播放
                    Toast.makeText(MusicDemo.this, "开始运动", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btendmusictest = (Button) findViewById(R.id.buttonendmusictest);
        btendmusictest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.reset(); // 停止播放
                initMediaPlayer(R.raw.endmusic);//初始化MediaPlayer的结束运动资源
                mediaPlayer.start();
                Toast.makeText(MusicDemo.this, "停止运动", Toast.LENGTH_SHORT).show();
            }
        });

        if (ContextCompat.checkSelfPermission(MusicDemo.this, Manifest.permission.
                WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MusicDemo.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }else{
            initMediaPlayer(R.raw.startmusic);//初始化MediaPlayer的开始运动资源
        }
    }

    private void initMediaPlayer(int res) {
        try {
            mediaPlayer = MediaPlayer.create(this, res);
            mediaPlayer.prepare(); // 让MediaPlayer进入到准备状态
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initMediaPlayer(R.raw.startmusic);//初始化MediaPlayer的开始运动资源
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

}
