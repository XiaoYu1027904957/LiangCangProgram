package com.xiaoyu.liangcangprogram.shopping.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.shopping.activity.PinPaiDetialShowActivity;
import com.xiaoyu.liangcangprogram.shopping.adapter.shopPinpaiAdapter;
import com.xiaoyu.liangcangprogram.shopping.bean.PinPaiBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class PinPaiFragment extends BaseFragment {
    @InjectView(R.id.shop_pinpai_listView)
    ListView shopPinpaiListView;
    private shopPinpaiAdapter adapter;
    private List<PinPaiBean.DataBean.ItemsBean> datas;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.shop_pinpai, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();

    }

    private void getDataFromNet() {
        GetNetData.get(NetUrl.PIN_PAI, null, new OnGetDataListener() {
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
        PinPaiBean pinPaiBean = processData(json);
        datas = pinPaiBean.getData().getItems();
        if (json != null) {
            adapter = new shopPinpaiAdapter(mContext, datas);
            shopPinpaiListView.setAdapter(adapter);
        }
        shopPinpaiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, PinPaiDetialShowActivity.class);
                Log.e("TAG", "---------------------->"+datas.get(position).getBrand_id());
                intent.putExtra("url", datas.get(position).getBrand_id());
                intent.putExtra("position",position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("haha",datas.get(position));
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    private PinPaiBean processData(String json) {
        return JSON.parseObject(json, PinPaiBean.class);
    }
}
