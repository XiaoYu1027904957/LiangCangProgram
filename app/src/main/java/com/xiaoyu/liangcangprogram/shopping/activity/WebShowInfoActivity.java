package com.xiaoyu.liangcangprogram.shopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.xiaoyu.liangcangprogram.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WebShowInfoActivity extends AppCompatActivity {

    @InjectView(R.id.webview_show_Info)
    WebView webviewShowInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_show_info);
        ButterKnife.inject(this);
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        String weburl = intent.getStringExtra("weburl");
        WebSettings settings = webviewShowInfo.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webviewShowInfo.loadUrl(weburl);
    }
}
