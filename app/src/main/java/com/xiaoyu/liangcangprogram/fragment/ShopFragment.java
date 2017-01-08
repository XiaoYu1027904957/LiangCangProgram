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
    private String mTabTitle[] = {"分类", "品牌", "首页", "专题", "礼物"};

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
                return mTabTitle.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTabTitle[position];
            }
        });

        idTablayout.setupWithViewPager(idViewpager);

    }

}
