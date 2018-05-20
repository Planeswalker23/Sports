package com.nanbei.sports;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by nanbei on 2017/12/15.
 */

public class WelCome extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent();
                it.setClass(WelCome.this,MainActivity.class);
                startActivity(it);
                finish();
            }
        },1*1000);
    }

}
