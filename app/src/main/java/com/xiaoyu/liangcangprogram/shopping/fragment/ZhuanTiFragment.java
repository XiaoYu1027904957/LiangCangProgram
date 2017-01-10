package com.xiaoyu.liangcangprogram.shopping.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.shopping.activity.WebShowInfoActivity;
import com.xiaoyu.liangcangprogram.shopping.adapter.ZhuanTiAdapter;
import com.xiaoyu.liangcangprogram.shopping.bean.ZhuanTiBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class ZhuanTiFragment extends BaseFragment {
    @InjectView(R.id.shop_zhuanti_listView)
    ListView shopZhuantiListView;
    private List<ZhuanTiBean.DataBean.ItemsBean> datas;
    private ZhuanTiAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.shop_zhuanti, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {

        GetNetData.get(NetUrl.ZHUAN_TI, null, new OnGetDataListener() {
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
        ZhuanTiBean zhuanTiBean = processData(json);
        datas = zhuanTiBean.getData().getItems();
        if (json != null) {
            adapter = new ZhuanTiAdapter(mContext, datas);
            shopZhuantiListView.setAdapter(adapter);
        }
        shopZhuantiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String topic_url = datas.get(position).getTopic_url();
                Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                intent.putExtra("weburl", topic_url);
                mContext.startActivity(intent);
            }
        });
    }

    private ZhuanTiBean processData(String json) {
        return JSON.parseObject(json, ZhuanTiBean.class);
    }


}
