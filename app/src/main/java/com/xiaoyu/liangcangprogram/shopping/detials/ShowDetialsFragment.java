package com.xiaoyu.liangcangprogram.shopping.detials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.MainActivity;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.daren.activity.ShowGoodsInfotwoActivity;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.shopping.bean.NewDetilasBean;
import com.xiaoyu.liangcangprogram.shoppingcart.ShoppingCartForGoods;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by yuxiaobai on 2017/1/9.
 */

public class ShowDetialsFragment extends BaseFragment {


    @InjectView(R.id.detials_back)
    TextView detialsBack;
    @InjectView(R.id.detials_titles)
    TextView detialsTitles;
    @InjectView(R.id.detials_shopcard)
    TextView detialsShopcard;
    @InjectView(R.id.show_recyclerview)
    RecyclerView showRecyclerview;
    private String url;
    private GoodsIntroduceAdapter adapter;
    private List<NewDetilasBean.DataBean.ItemsBean> datas;
    private int position;
    private int currentfragment;
    private ShowDetialsFragment fragment;


    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.shop_detials_show, null);
        ButterKnife.inject(this, view);
        fragment = new ShowDetialsFragment();
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        Bundle bundle = getArguments();
        position = bundle.getInt("position");
        url = bundle.getString("url");
        currentfragment = bundle.getInt("current");
        initListener();
        initUrl();
        getDataFrom();

    }

    private void initUrl() {
        if (position < 7) {
            url = "00" + url;
        }
        if (position <= 18 && position >= 7) {
            url = "0" + url;
        }
    }

    private void getDataFrom() {
        GetNetData.get(NetUrl.FENLEI_DETIAL_HEAD + url + NetUrl.FENLEI_DETIAL_FOOT, null, new OnGetDataListener() {
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
        NewDetilasBean detialsBean = processData(json);
        datas = detialsBean.getData().getItems();
        if (json != null) {
            adapter = new GoodsIntroduceAdapter(mContext, datas);
            showRecyclerview.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2);
            showRecyclerview.setLayoutManager(manager);
        }
        adapter.setOnItemClickListener(new GoodsIntroduceAdapter.OnItemClickListener() {
            @Override
            public void getPosition(int position) {

                String goods_id = datas.get(position).getGoods_id();
                Intent intent = new Intent(mContext, ShowGoodsInfotwoActivity.class);
                intent.putExtra("goodsid", goods_id);
                mContext.startActivity(intent);
            }
        });


    }

    private NewDetilasBean processData(String json) {
        return JSON.parseObject(json, NewDetilasBean.class);
    }

    private void initListener() {
        detialsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) mContext;
                activity.SwitchFragment(activity.getFragmet(currentfragment));
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.fragmeng_left_in, R.anim.fragment_right_out, R.anim.fragment_right_in, R.anim.fragment_left_out);
                transaction.replace(R.id.main_framelayout, activity.getFragmet(currentfragment));
                transaction.commit();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.detials_shopcard)
    public void onClick() {
        Intent intent = new Intent(mContext, ShoppingCartForGoods.class);
        mContext.startActivity(intent);
    }
}
