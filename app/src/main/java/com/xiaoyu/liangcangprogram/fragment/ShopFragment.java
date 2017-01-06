package com.xiaoyu.liangcangprogram.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.xiaoyu.liangcangprogram.R;
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
    private int mTabCount = 5;

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
    }

    /**
     * 配置adapter
     */
    private void initViewPager() {
        idViewpager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new SimpleFragment();
            }

            @Override
            public int getCount() {
                return mTabCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "Tab:" + position;
            }
        });

        idTablayout.setupWithViewPager(idViewpager);

    }

}
