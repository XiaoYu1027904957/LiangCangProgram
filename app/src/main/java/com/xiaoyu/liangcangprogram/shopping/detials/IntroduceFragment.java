package com.xiaoyu.liangcangprogram.shopping.detials;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.shopping.bean.PinPaiDetialBean;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/10.
 */

public class IntroduceFragment extends BaseFragment {

    private final PinPaiDetialBean.DataBean.ItemsBean itembean;
    @InjectView(R.id.doods_introduce)
    TextView doodsIntroduce;
    private LayoutInflater inflater;

    public IntroduceFragment(PinPaiDetialBean.DataBean.ItemsBean items) {
        this.itembean = items;
    }

    @Override
    protected View initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.goods_introduce, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        if (itembean != null) {

            doodsIntroduce.setText(itembean.getBrand_info().getBrand_desc());
        }
    }
}
