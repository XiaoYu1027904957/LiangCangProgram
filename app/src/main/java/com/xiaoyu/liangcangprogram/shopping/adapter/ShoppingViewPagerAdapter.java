package com.xiaoyu.liangcangprogram.shopping.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xiaoyu.liangcangprogram.shopping.fragment.FenLeiFragment;
import com.xiaoyu.liangcangprogram.shopping.fragment.LiWuFragment;
import com.xiaoyu.liangcangprogram.shopping.fragment.PinPaiFragment;
import com.xiaoyu.liangcangprogram.shopping.fragment.ShouYeFragment;
import com.xiaoyu.liangcangprogram.shopping.fragment.ZhuanTiFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class ShoppingViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String mTabTitle[] = {"分类", "品牌", "首页", "专题", "礼物"};

    public ShoppingViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment() {
        list = new ArrayList<>();
        list.add(new FenLeiFragment());
        list.add(new PinPaiFragment());
        list.add(new ShouYeFragment());
        list.add(new ZhuanTiFragment());
        list.add(new LiWuFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return  list.get(position);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitle[position];
    }
}
