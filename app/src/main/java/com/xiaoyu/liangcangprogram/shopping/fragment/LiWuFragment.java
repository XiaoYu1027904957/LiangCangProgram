package com.xiaoyu.liangcangprogram.shopping.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.shopping.detials.ShowLiWuDetialsFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class LiWuFragment extends BaseFragment {


    @InjectView(R.id.liwu_image_7)
    ImageView liwuImage7;
    @InjectView(R.id.liwu_image_1)
    ImageView liwuImage1;
    @InjectView(R.id.liwu_image_2)
    ImageView liwuImage2;
    @InjectView(R.id.liwu_image_3)
    ImageView liwuImage3;
    @InjectView(R.id.liwu_image_4)
    ImageView liwuImage4;
    @InjectView(R.id.liwu_image_5)
    ImageView liwuImage5;
    @InjectView(R.id.liwu_image_6)
    ImageView liwuImage6;
    ShowLiWuDetialsFragment showliwuDetialsFragment = new ShowLiWuDetialsFragment();
    private String url;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.shop_liwu, null);
        ButterKnife.inject(this, view);
        return view;
    }


    @OnClick({R.id.liwu_image_7, R.id.liwu_image_1, R.id.liwu_image_2, R.id.liwu_image_3, R.id.liwu_image_4, R.id.liwu_image_5, R.id.liwu_image_6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.liwu_image_7:
                url = NetUrl.LI_WU_HEAD + "7" + NetUrl.LI_WU_FOOT;
                Log.e("TAG", "----------><-------" + url);
                StartOtherFragment(url);
                break;
            case R.id.liwu_image_1:
                url = NetUrl.LI_WU_HEAD + "1" + NetUrl.LI_WU_FOOT;
                StartOtherFragment(url);
                break;
            case R.id.liwu_image_2:
                url = NetUrl.LI_WU_HEAD + "2" + NetUrl.LI_WU_FOOT;
                StartOtherFragment(url);
                break;
            case R.id.liwu_image_3:
                url = NetUrl.LI_WU_HEAD + "3" + NetUrl.LI_WU_FOOT;
                StartOtherFragment(url);
                break;
            case R.id.liwu_image_4:
                url = NetUrl.LI_WU_HEAD + "4" + NetUrl.LI_WU_FOOT;
                StartOtherFragment(url);
                break;
            case R.id.liwu_image_5:
                url = NetUrl.LI_WU_HEAD + "5" + NetUrl.LI_WU_FOOT;
                StartOtherFragment(url);
                break;
            case R.id.liwu_image_6:
                url = NetUrl.LI_WU_HEAD + "6" + NetUrl.LI_WU_FOOT;
                StartOtherFragment(url);
                break;
        }
    }

    public void StartOtherFragment(String url) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.main_framelayout, showliwuDetialsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        showliwuDetialsFragment.setArguments(bundle);
    }
}
