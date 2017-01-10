package com.xiaoyu.liangcangprogram.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.daren.adapter.DaRenAdapter;
import com.xiaoyu.liangcangprogram.daren.bean.DaRenBean;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/6.
 */

public class DaRenFragment extends BaseFragment {
    @InjectView(R.id.mian_search)
    TextView mianSearch;
    @InjectView(R.id.main_title)
    TextView mainTitle;
    @InjectView(R.id.main_goods)
    TextView mainGoods;
    @InjectView(R.id.daren_recyclerview)
    RecyclerView darenRecyclerview;
    private LayoutInflater inflater;
    private List<DaRenBean.DataBean.ItemsBean> datas;
    private DaRenAdapter adapter;

    @Override
    protected View initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.daren_fragment, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {
        GetNetData.get(NetUrl.DA_REN, null, new OnGetDataListener() {
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
        DaRenBean daRenBean = porcessData(json);
        datas = daRenBean.getData().getItems();
        if (json != null) {
          adapter = new DaRenAdapter(mContext,datas);
            darenRecyclerview.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(mContext,3);
            darenRecyclerview.setLayoutManager(manager);
        }
    }

    private DaRenBean porcessData(String json) {
        return JSON.parseObject(json, DaRenBean.class);
    }

}
