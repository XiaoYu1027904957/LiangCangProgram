package com.xiaoyu.liangcangprogram;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import pl.droidsonroids.gif.GifTextView;

public class WelcomeActivity extends AppCompatActivity {

    @InjectView(R.id.gifView)
    GifTextView gifView;
    @InjectView(R.id.activity_welcome)
    RelativeLayout activityWelcome;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //4.5s后进入主界面
                startMainActivity();
            }
        }, 4100);
    }
    private void startMainActivity() {
//        boolean isStartMain = CacheUtils.getBoolean(WelcomeActivity.this, GuideActivity.START_MAIN);
//
//        if (isStartMain) {
//            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        } else {
//            Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
//            startActivity(intent);
//            finish();
//        }

            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
    }
}
