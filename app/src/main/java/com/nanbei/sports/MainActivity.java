package com.nanbei.sports;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.File;
import java.net.URI;

public class MainActivity extends Activity {

    private static Context context;

    private Button btMusic;
    private Button btMap;
    private Button btDynamic;
    private Button btMusicDemo;
    private Button btStaticDemo;
    private Button btNotification;
    private Button btSharePictrue;
    private Button btGallery;
    private Button btCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.context = context;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //日历
        btCalender = (Button) findViewById(R.id.buttoncalender);
        btCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalenderActivity.class);
                startActivityForResult(intent, 1);
            }
        });


        //图片轮播器
        btGallery = (Button) findViewById(R.id.gallery) ;
        btGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });

        btMusic = (Button) findViewById(R.id.music);
        btMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicWebActivity.class);
                startActivity(intent);
            }
        });

        btMap = (Button) findViewById(R.id.map);
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        btDynamic = (Button) findViewById(R.id.Dynamic);
        btDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DynamicDemo.class);
                startActivity(intent);
            }
        });

        btMusicDemo = (Button) findViewById(R.id.musicdemo);
        btMusicDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicDemo.class);
                startActivity(intent);
            }
        });

        btStaticDemo = (Button) findViewById(R.id.staticdemo);
        btStaticDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StaticDemo.class);
                startActivity(intent);
            }
        });

        btNotification = (Button) findViewById(R.id.notification);
        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotificationDemo.class);
                startActivity(intent);
            }
        });

        btSharePictrue = (Button) findViewById(R.id.buttonsharepictrue);
        btSharePictrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showLocationShare(2);
                File file = null;
                //String path =  Environment.getExternalStorageDirectory().getPath() + File.separator;
                String path = Environment.getExternalStorageDirectory().getPath() + File.separator;
                file = new File(path + "fyd.png");
                sharePictrue(file);
            }
        });
    }

    private void sharePictrue(File file){
        Intent shareIntent = new Intent();
        //解决android.os.FileUriExposedException问题

        //由文件得到uri
        Uri imageUri;
        // 判断版本大于等于7.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // "net.csdn.blog.ruancoder.fileprovider"即是在清单文件中配置的authorities
            imageUri = FileProvider.getUriForFile(context, "net.csdn.blog.ruancoder.fileprovider", file);
            // 给目标应用一个临时授权
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            imageUri = Uri.fromFile(file);
        }
        shareIntent.setDataAndType(imageUri, "application/vnd.android.package-archive");
        //通过微信分享
        //ComponentName comp = new ComponentName("com.tencent.mm","com.tencent.mm.ui.tools.ShareToTimeLineUI");
        //shareIntent.setComponent(comp);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            int cyear = data.getIntExtra("year",0);
            int cmonth = data.getIntExtra("month", 0);
            int cday = data.getIntExtra("day", 0);
            Log.i("tag", cyear + ":" + cmonth + ":" + cday);
        }
    }
}


