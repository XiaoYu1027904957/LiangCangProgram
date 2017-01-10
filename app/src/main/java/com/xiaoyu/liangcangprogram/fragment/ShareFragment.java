package com.xiaoyu.liangcangprogram.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.share.adapter.ShareAdapter;
import com.xiaoyu.liangcangprogram.share.bean.ShareBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/6.
 */

public class ShareFragment extends BaseFragment {
    @InjectView(R.id.mian_search)
    TextView mianSearch;
    @InjectView(R.id.main_title)
    TextView mainTitle;
    @InjectView(R.id.main_goods)
    TextView mainGoods;

    @InjectView(R.id.share_recycler)
    RecyclerView shareRecycler;
    private LayoutInflater inflater;
    private List<ShareBean.DataBean.ItemsBean> datas;
    private ShareAdapter adapter;

    @Override
    protected View initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.share_fragment, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        GetDataFromNet();
    }

    private void GetDataFromNet() {

        GetNetData.get(NetUrl.SHARE, null, new OnGetDataListener() {
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
        ShareBean shareBean = processData(json);
        datas = shareBean.getData().getItems();
        if (json != null) {
            adapter = new ShareAdapter(mContext, datas);
            shareRecycler.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2);
            shareRecycler.setLayoutManager(manager);

        }
    }

    private ShareBean processData(String json) {
        return JSON.parseObject(json, ShareBean.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
