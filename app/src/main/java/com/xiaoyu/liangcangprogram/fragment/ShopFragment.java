package com.xiaoyu.liangcangprogram.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.shopping.adapter.ShoppingViewPagerAdapter;
import com.xiaoyu.liangcangprogram.shoppingcart.ShoppingCartForGoods;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by yuxiaobai on 2017/1/6.
 */

public class ShopFragment extends BaseFragment {
    @InjectView(R.id.id_tablayout)
    TabLayout idTablayout;
    @InjectView(R.id.id_viewpager)
    ViewPager idViewpager;
    @InjectView(R.id.mian_search)
    TextView mianSearch;
    @InjectView(R.id.main_title)
    TextView mainTitle;
    @InjectView(R.id.main_goods)
    TextView mainGoods;
    private LayoutInflater inflater;


    private ShoppingViewPagerAdapter adapter;

    @Override
    protected View initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.shopping_fragment, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        initViewPager();
        idViewpager.setCurrentItem(2, true);


    }


    /**
     * 配置adapter1
     */
    private void initViewPager() {
        adapter = new ShoppingViewPagerAdapter(getFragmentManager());
        idViewpager.setAdapter(adapter);
        idTablayout.setupWithViewPager(idViewpager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @OnClick(R.id.main_goods)
    public void onClick() {
        Intent intent = new Intent(mContext, ShoppingCartForGoods.class);
        mContext.startActivity(intent);
    }
}
