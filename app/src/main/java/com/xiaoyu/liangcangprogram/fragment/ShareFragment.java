package com.xiaoyu.liangcangprogram.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.daren.activity.ShowGoodsInfoActivity;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.share.adapter.ShareAdapter;
import com.xiaoyu.liangcangprogram.share.bean.ShareBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

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
    @InjectView(R.id.shoe_other)
    TextView shoeOther;
    @InjectView(R.id.layout)
    LinearLayout layout;
    @InjectView(R.id.layout_hint)
    LinearLayout layoutHint;
    @InjectView(R.id.all_share)
    TextView allShare;
    @InjectView(R.id.shop_share)
    TextView shopShare;
    @InjectView(R.id.men)
    TextView men;
    @InjectView(R.id.women)
    TextView women;
    @InjectView(R.id.jiaju)
    TextView jiaju;
    @InjectView(R.id.shuma)
    TextView shuma;
    @InjectView(R.id.tools)
    TextView tools;
    @InjectView(R.id.wanju)
    TextView wanju;
    @InjectView(R.id.meirong)
    TextView meirong;
    @InjectView(R.id.child)
    TextView child;
    @InjectView(R.id.chongwu)
    TextView chongwu;
    @InjectView(R.id.sport)
    TextView sport;
    @InjectView(R.id.meishi)
    TextView meishi;
    @InjectView(R.id.wenhua)
    TextView wenhua;
    private LayoutInflater inflater;
    private List<ShareBean.DataBean.ItemsBean> datas;
    private ShareAdapter adapter;
    private boolean isshow;

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
        adapter.setOnItemClickListener(new ShareAdapter.OnItemClickListener() {
            @Override
            public void getPosition(int position) {
                String goods_id = datas.get(position).getGoods_id();
                Intent intent = new Intent(mContext, ShowGoodsInfoActivity.class);
                intent.putExtra("goodsid", goods_id);
                startActivity(intent);
            }
        });
    }

    private ShareBean processData(String json) {
        return JSON.parseObject(json, ShareBean.class);
    }




    @OnClick({R.id.main_goods, R.id.all_share, R.id.shop_share, R.id.shoe_other, R.id.men, R.id.women, R.id.jiaju, R.id.shuma, R.id.tools, R.id.wanju, R.id.meirong, R.id.child, R.id.chongwu, R.id.sport, R.id.meishi, R.id.wenhua})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_goods:
                if (isshow) {
                    layout.setVisibility(View.GONE);
                    layoutHint.setVisibility(View.GONE);
                    isshow = false;
                } else {
                    layout.setVisibility(View.VISIBLE);
                    isshow = true;
                }

                break;
            case R.id.all_share:
                break;
            case R.id.shop_share:
                break;
            case R.id.shoe_other:
                layoutHint.setVisibility(View.VISIBLE);
                break;
            case R.id.men:
                break;
            case R.id.women:
                break;
            case R.id.jiaju:
                break;
            case R.id.shuma:
                break;
            case R.id.tools:
                break;
            case R.id.wanju:
                break;
            case R.id.meirong:
                break;
            case R.id.child:
                break;
            case R.id.chongwu:
                break;
            case R.id.sport:
                break;
            case R.id.meishi:
                break;
            case R.id.wenhua:
                break;
        }
    }
}
