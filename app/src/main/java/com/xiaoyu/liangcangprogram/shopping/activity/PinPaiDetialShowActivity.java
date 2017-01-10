package com.xiaoyu.liangcangprogram.shopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.shopping.bean.PinPaiBean;
import com.xiaoyu.liangcangprogram.shopping.bean.PinPaiDetialBean;
import com.xiaoyu.liangcangprogram.shopping.detials.IntroduceFragment;
import com.xiaoyu.liangcangprogram.shopping.detials.ProduceFragment;
import com.xiaoyu.liangcangprogram.utlis.GlideCircleTransform;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PinPaiDetialShowActivity extends AppCompatActivity {

    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.pinpai_icon)
    ImageView pinpaiIcon;
    @InjectView(R.id.pinpai_name)
    TextView pinpaiName;
    @InjectView(R.id.pinpai_story)
    RadioButton pinpaiStory;
    @InjectView(R.id.pinpai_produce)
    RadioButton pinpaiProduce;
    @InjectView(R.id.activity_pin_pai_detial_show)
    LinearLayout activityPinPaiDetialShow;
    @InjectView(R.id.show_switch)
    FrameLayout showSwitch;
    private int id;
    Intent intent;
    int position;
    private FragmentTransaction transaction;
    private List<PinPaiDetialBean.DataBean.ItemsBean> items;
    private PinPaiBean.DataBean.ItemsBean itemben;
    private Fragment temfragment;
    private IntroduceFragment introduceFragment;
    private ProduceFragment producefragment;
    private PinPaiDetialBean.DataBean.ItemsBean itemsBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_pai_detial_show);
        ButterKnife.inject(this);


        transaction = getSupportFragmentManager().beginTransaction();
        initDataFromIntent();
    }

    private void initDataFromIntent() {
        intent = getIntent();
        id = intent.getIntExtra("url", -1);
        position = intent.getIntExtra("position", -1);
        itemben = (PinPaiBean.DataBean.ItemsBean) intent.getSerializableExtra("haha");
        getDataFromNet();
    }

    private void getDataFromNet() {
        GetNetData.get(NetUrl.PIN_PAI_HEAD + id + NetUrl.PIN_PAI_FOOT, null, new OnGetDataListener() {
            @Override
            public void onSuccess(String json) {
                parseData(json);
            }

            @Override
            public void onError(String e) {

            }
        });

    }

    private void parseData(String json) {
        PinPaiDetialBean pinPaiDetialBean = processData(json);
        items = pinPaiDetialBean.getData().getItems();
        Glide.with(this).load(itemben.getBrand_logo()).transform(new GlideCircleTransform(this)).into(pinpaiIcon);
        pinpaiName.setText(itemben.getBrand_name());
        if (items.size() > 0) {
            itemsBean = items.get(0);
        }
        introduceFragment = new IntroduceFragment(itemsBean);
        producefragment = new ProduceFragment(items);
        SwitchFragment(producefragment);

    }

    private PinPaiDetialBean processData(String json) {
        return JSON.parseObject(json, PinPaiDetialBean.class);
    }

    @OnClick({R.id.title, R.id.pinpai_story, R.id.pinpai_produce})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title:
                finish();
                break;
            case R.id.pinpai_story:
                SwitchFragment(introduceFragment);

                break;
            case R.id.pinpai_produce:
                SwitchFragment(producefragment);
                break;
            default:
                transaction.commit();
                break;
        }
    }

    private void SwitchFragment(Fragment currentfragment) {

        if (temfragment != currentfragment) {
            if (currentfragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (!currentfragment.isAdded()) {
                    if (temfragment != null) {
                        transaction.hide(temfragment);
                    }
                    transaction.add(R.id.show_switch, currentfragment);
                } else {
                    if (temfragment != null) {
                        transaction.hide(temfragment);
                    }
                    transaction.show(currentfragment);
                }
                transaction.commit();
                temfragment = currentfragment;
            }
        }

    }


}
