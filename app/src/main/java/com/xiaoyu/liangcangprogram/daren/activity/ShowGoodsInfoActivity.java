package com.xiaoyu.liangcangprogram.daren.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.daren.bean.GoodsDetialsBean;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.AccordionTransformer;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShowGoodsInfoActivity extends AppCompatActivity {
    @InjectView(R.id.Goods_pic)
    Banner GoodsPic;
    @InjectView(R.id.GoodsInfo_name)
    TextView GoodsInfoName;
    @InjectView(R.id.goods_price)
    TextView goodsPrice;
    @InjectView(R.id.aixin)
    ImageView aixin;
    @InjectView(R.id.like_count)
    TextView likeCount;
    @InjectView(R.id.user_icon)
    ImageView userIcon;
    @InjectView(R.id.user_name)
    TextView userName;
    @InjectView(R.id.pinglun)
    LinearLayout pinglun;
    @InjectView(R.id.activity_show_goods_info)
    LinearLayout activityShowGoodsInfo;
    private String goodsid;
    private String url;
    private ArrayList<String> imageurl;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_goods_info);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        arrayList = new ArrayList();
        Intent intent = getIntent();
        goodsid = intent.getStringExtra("goodsid");
        getDataFromNet();
    }

    private void getDataFromNet() {
        url = NetUrl.GOODS_HEAD + goodsid + NetUrl.GOODS_FOOT;
        Log.e("TAG", "url" + url);
        GetNetData.get(url, null, new OnGetDataListener() {
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
        GoodsDetialsBean goodsBean = processData(json);
        imageurl = (ArrayList<String>) goodsBean.getData().getItems().getImages_item();

        if (json != null) {
            for (int i = 0; i < imageurl.size(); i++) {
                arrayList.add(imageurl.get(i));
            }
            GoodsPic.setImages(arrayList).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(ShowGoodsInfoActivity.this).load(path).into(imageView);
                }
            }).start();
//             设置样式
            GoodsPic.setBannerAnimation(AccordionTransformer.class);
            GoodsInfoName.setText(goodsBean.getData().getItems().getGoods_name());
            goodsPrice.setText(goodsBean.getData().getItems().getPrice());
            likeCount.setText(goodsBean.getData().getItems().getLike_count());
            Glide.with(this).load(goodsBean.getData().getItems().getHeadimg()).into(userIcon);
            userName.setText(goodsBean.getData().getItems().getOwner_name());
        }
    }

    private GoodsDetialsBean processData(String json) {
        return JSON.parseObject(json, GoodsDetialsBean.class);
    }

}
