package com.xiaoyu.liangcangprogram.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.shopping.adapter.ShoppingViewPagerAdapter;
import com.xiaoyu.liangcangprogram.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/6.
 */

public class ShopFragment extends BaseFragment {
    @InjectView(R.id.id_tablayout)
    TabLayout idTablayout;
    @InjectView(R.id.id_viewpager)
    ViewPager idViewpager;
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

}
