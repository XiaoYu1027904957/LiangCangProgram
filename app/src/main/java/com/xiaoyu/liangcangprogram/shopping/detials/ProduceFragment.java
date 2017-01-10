package com.xiaoyu.liangcangprogram.shopping.detials;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.shopping.bean.PinPaiDetialBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/10.
 */

public class ProduceFragment extends BaseFragment {
    private final List<PinPaiDetialBean.DataBean.ItemsBean> datas;
    @InjectView(R.id.recycler_produce)
    RecyclerView recyclerProduce;

    private GoodSProduceAdapter adapter;

    public ProduceFragment(List<PinPaiDetialBean.DataBean.ItemsBean> items) {
        this.datas = items;


    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext,R.layout.shop_detials_produce, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        adapter = new GoodSProduceAdapter(mContext,datas);
        recyclerProduce.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        recyclerProduce.setLayoutManager(manager);
    }
}
