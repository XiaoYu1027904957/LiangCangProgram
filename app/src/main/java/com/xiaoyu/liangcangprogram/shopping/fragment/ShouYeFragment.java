package com.xiaoyu.liangcangprogram.shopping.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.shopping.adapter.ShopshouYeAdapter;
import com.xiaoyu.liangcangprogram.shopping.bean.ShouYeBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class ShouYeFragment extends BaseFragment {
    @InjectView(R.id.shop_shouye_recyclerView)
    RecyclerView shopShouyeRecyclerView;
    private List<ShouYeBean.DataBean.ItemsBean.ListBeanX> list;
    private ShopshouYeAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.shop_shouye, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {
        GetNetData.get(NetUrl.SHOU_YE, null, new OnGetDataListener() {
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
        ShouYeBean shouYeBean = processData(json);
        list = shouYeBean.getData().getItems().getList();
        if (json != null) {
            adapter = new ShopshouYeAdapter(mContext, list);
            shopShouyeRecyclerView.setAdapter(adapter);
            LinearLayoutManager manager = new LinearLayoutManager(mContext);
            shopShouyeRecyclerView.setLayoutManager(manager);

        }
    }

    private ShouYeBean processData(String json) {
        return JSON.parseObject(json, ShouYeBean.class);
    }
}
