package com.xiaoyu.liangcangprogram.shopping.detials;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.shopping.bean.NewDetilasBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/9.
 */

public class ShowDetialsFragment extends BaseFragment {


    @InjectView(R.id.detials_back)
    TextView detialsBack;
    @InjectView(R.id.detials_titles)
    TextView detialsTitles;
    @InjectView(R.id.detials_shopcard)
    TextView detialsShopcard;
    @InjectView(R.id.show_recyclerview)
    RecyclerView showRecyclerview;
    private String url;
    private GoodsIntroduceAdapter adapter;
    private List<NewDetilasBean.DataBean.ItemsBean> datas;
    private int position;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.shop_detials_show, null);
        ButterKnife.inject(this, view);
        return view;
    }
    @Override
    public void initData() {
        super.initData();
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        position = bundle.getInt("position");
        initListener();
        initUrl();
        getDataFrom();

    }

    private void initUrl() {
        if (position < 7) {
            url = "00" + url;
        }
        if (position <= 18 && position >= 7) {
            url = "0" + url;
        }
    }

    private void getDataFrom() {
        Log.e("TAG", "===========================>" + url);
        Log.e("TAG", "==========>" + NetUrl.FENLEI_DETIAL_HEAD + url + NetUrl.FENLEI_DETIAL_FOOT);
        GetNetData.get(NetUrl.FENLEI_DETIAL_HEAD + url + NetUrl.FENLEI_DETIAL_FOOT, null, new OnGetDataListener() {
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
        NewDetilasBean detialsBean = processData(json);
        datas = detialsBean.getData().getItems();
        if (json != null) {
            adapter = new GoodsIntroduceAdapter(mContext, datas);
            showRecyclerview.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2);
            showRecyclerview.setLayoutManager(manager);
        }
    }

    private NewDetilasBean processData(String json) {
        return JSON.parseObject(json, NewDetilasBean.class);
    }

    private void initListener() {
        detialsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(ShowDetialsFragment.this);
                transaction.commit();
            }
        });
    }


}
