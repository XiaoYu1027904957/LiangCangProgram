package com.xiaoyu.liangcangprogram.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;

/**
 * Created by yuxiaobai on 2017/1/6.
 */

public class PersonalFragment extends BaseFragment {
    private LayoutInflater inflater;

    @Override
    protected View initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.personal_fragment, null);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
