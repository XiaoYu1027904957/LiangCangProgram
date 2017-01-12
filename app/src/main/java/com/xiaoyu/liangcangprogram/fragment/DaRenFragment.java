package com.xiaoyu.liangcangprogram.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.daren.DaRenShowDetialsActivity;
import com.xiaoyu.liangcangprogram.daren.adapter.DaRenAdapter;
import com.xiaoyu.liangcangprogram.daren.bean.DaRenBean;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

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
    @InjectView(R.id.moren)
    TextView moren;
    @InjectView(R.id.zuiduo)
    TextView zuiduo;
    @InjectView(R.id.popular)
    TextView popular;
    @InjectView(R.id.zuixin)
    TextView zuixin;
    @InjectView(R.id.join)
    TextView join;
    @InjectView(R.id.show_menu)
    LinearLayout showMenu;
    private LayoutInflater inflater;
    private List<DaRenBean.DataBean.ItemsBean> datas;
    private DaRenAdapter adapter;
    private boolean isshow;

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
            adapter = new DaRenAdapter(mContext, datas);
            darenRecyclerview.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(mContext, 3);
            darenRecyclerview.setLayoutManager(manager);
        }
        adapter.setOnItemClickListener(new DaRenAdapter.OnItemClickListener() {
            @Override
            public void getPosition(int position) {
                String uid = datas.get(position).getUid();
                Intent intent = new Intent(mContext, DaRenShowDetialsActivity.class);
                intent.putExtra("uid", uid);
                mContext.startActivity(intent);
            }
        });
    }

    private DaRenBean porcessData(String json) {
        return JSON.parseObject(json, DaRenBean.class);
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

    @OnClick({R.id.main_goods, R.id.moren, R.id.zuiduo, R.id.popular, R.id.zuixin, R.id.join})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_goods:
                if (isshow) {
                    showMenu.setVisibility(View.GONE);

                    isshow = false;
                } else {
                    showMenu.setVisibility(View.VISIBLE);
                    isshow = true;
                }
                break;
            case R.id.moren:
                break;
            case R.id.zuiduo:
                break;
            case R.id.popular:
                break;
            case R.id.zuixin:
                break;
            case R.id.join:
                break;
        }
    }
}
