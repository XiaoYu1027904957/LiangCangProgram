package com.xiaoyu.liangcangprogram.shopping.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.MainActivity;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.shopping.adapter.ShopFenLeiAdapter;
import com.xiaoyu.liangcangprogram.shopping.bean.DetialsBean;
import com.xiaoyu.liangcangprogram.shopping.bean.FenLeiBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class FenLeiFragment extends BaseFragment {
    @InjectView(R.id.shop_fenlei_recycler)
    RecyclerView shopFenleiRecycler;
    private LayoutInflater inflater;
    private ShopFenLeiAdapter adapter;
    private List<FenLeiBean.DataBean.ItemsBean> datas;
    private List<DetialsBean.DataBean.ItemsBean> items;


    @Override
    protected View initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.shop_fenlei, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();

    }

    private void getDataFromNet() {
        GetNetData.get(NetUrl.FEN_LEI, null, new OnGetDataListener() {
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
        FenLeiBean fenLeiBean = processData(json);
        datas = fenLeiBean.getData().getItems();
        if (json != null) {
            adapter = new ShopFenLeiAdapter(mContext, datas);
            shopFenleiRecycler.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2);
            shopFenleiRecycler.setLayoutManager(manager);
            adapter.setOnItemClickListener(new ShopFenLeiAdapter.OnItemClickListener() {
                @Override
                public void getPosition(int position) {
                    String url = datas.get(position).getCat_id();
                    Bundle bundle = new Bundle();
                    MainActivity mainActivity = (MainActivity) mContext;
                    mainActivity.getFragmet(5).setArguments(bundle);
                    int currentFragment = mainActivity.getCurrentFragment();
                    mainActivity.SwitchFragment(mainActivity.getFragmet(5));
                    bundle.putString("url", url);
                    bundle.putInt("position", position);
                    bundle.putInt("current", currentFragment);


                }
            });


        }

    }

    private FenLeiBean processData(String json) {
        return JSON.parseObject(json, FenLeiBean.class);
    }


}
