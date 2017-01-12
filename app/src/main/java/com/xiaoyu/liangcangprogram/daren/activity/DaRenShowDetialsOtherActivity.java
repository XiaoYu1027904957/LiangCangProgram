package com.xiaoyu.liangcangprogram.daren.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.daren.adapter.DaRenFansAdapter;
import com.xiaoyu.liangcangprogram.daren.adapter.DarenLikeAdapter;
import com.xiaoyu.liangcangprogram.daren.bean.DaRenDetialsBean;
import com.xiaoyu.liangcangprogram.daren.bean.FansBean;
import com.xiaoyu.liangcangprogram.daren.bean.LikesBean;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DaRenShowDetialsOtherActivity extends AppCompatActivity {

    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.daren_detial_icon)
    ImageView darenDetialIcon;
    @InjectView(R.id.daren_detial_name)
    TextView darenDetialName;
    @InjectView(R.id.daren_detial_introduce)
    TextView darenDetialIntroduce;
    @InjectView(R.id.daren_guanzhu)
    TextView darenGuanzhu;
    @InjectView(R.id.daren_sixin)
    TextView darenSixin;
    @InjectView(R.id.like)
    TextView like;
    @InjectView(R.id.tuijain)
    TextView tuijain;
    @InjectView(R.id.guanzhu)
    TextView guanzhu;
    @InjectView(R.id.fensi)
    TextView fensi;
    @InjectView(R.id.daren_detials_recycler)
    RecyclerView darenDetialsRecycler;
    @InjectView(R.id.activity_da_ren_show_detials)
    LinearLayout activityDaRenShowDetials;
    private List<DaRenDetialsBean.DataBean.ItemsBean.UsersBean> users;
    private String uid;
    private List<LikesBean.DataBean.ItemsBean.GoodsBean> goods;
    private DarenLikeAdapter adapter;
    private String url;
    private List<FansBean.DataBean.ItemsBean.UsersBean> user;
    private DaRenFansAdapter fansadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_ren_show_detials);
        ButterKnife.inject(this);
        initData();
    }


    private void initData() {
        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");

        GetNetData.get(NetUrl.DA_REN_DETIALS_HEAD + uid + NetUrl.DA_REN_DETIALS_FOOT, null, new OnGetDataListener() {
            @Override
            public void onSuccess(String json) {
                parseData(json);
            }

            @Override
            public void onError(String e) {

            }
        });
        GetDataFromNetForDetials(NetUrl.TUIJIAN_DAREN_HEAD + uid + NetUrl.TUIJAN_DAREN_FOOT);

    }

    private void parseData(String json) {
        DaRenDetialsBean daRenDetialsBean = processData(json);
        users = daRenDetialsBean.getData().getItems().getUsers();
        if (json != null) {
            Glide.with(this).load(daRenDetialsBean.getData().getItems().getUser_image().getOrig()).into(darenDetialIcon);
            title.setText(daRenDetialsBean.getData().getItems().getUser_name());
            darenDetialName.setText(daRenDetialsBean.getData().getItems().getUser_name());
            darenDetialIntroduce.setText(daRenDetialsBean.getData().getItems().getUser_desc());
        }
    }

    private DaRenDetialsBean processData(String json) {
        return JSON.parseObject(json, DaRenDetialsBean.class);
    }

    @OnClick({R.id.title, R.id.like, R.id.tuijain, R.id.guanzhu, R.id.fensi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title:
                finish();
                break;
            case R.id.like:
                url = NetUrl.LIKE_DAREN_HEAD + uid + NetUrl.LIKE_DAREN_FOOT;
                GetDataFromNetForDetials(url);
                break;
            case R.id.tuijain:
                url = NetUrl.TUIJIAN_DAREN_HEAD + uid + NetUrl.TUIJAN_DAREN_FOOT;
                GetDataFromNetForDetials(url);
                break;
            case R.id.guanzhu:
                url = NetUrl.GUANZHU_DAREN_HEAD + uid + NetUrl.GUAZHU_DAREN_FOOT;
                GetDataFromNetForDetialsFans(url);
                break;
            case R.id.fensi:
                url = NetUrl.FANS_DAREN_HEAD + uid + NetUrl.FANS_DAREN_FOOT;
                GetDataFromNetForDetialsFans(url);
                break;
        }
    }

    private void GetDataFromNetForDetialsFans(String url) {
        GetNetData.get(url, null, new OnGetDataListener() {
            @Override
            public void onSuccess(String json) {
                parseDataDetialsFans(json);
            }

            @Override
            public void onError(String e) {
            }
        });
    }

    private void parseDataDetialsFans(String json) {
        final FansBean fansBean = JSON.parseObject(json, FansBean.class);
        user = fansBean.getData().getItems().getUsers();
        if (user != null) {
            fansadapter = new DaRenFansAdapter(this, user);
            darenDetialsRecycler.setAdapter(fansadapter);
            GridLayoutManager manager = new GridLayoutManager(this, 3);
            darenDetialsRecycler.setLayoutManager(manager);
            fansadapter.setOnItemClickListener(new DaRenFansAdapter.OnItemClickListener() {
                @Override
                public void getPosition(int position) {
                    String uri = user.get(position).getUser_id();
                    url = NetUrl.GUANZHU_DAREN_HEAD + uri + NetUrl.GUAZHU_DAREN_FOOT;
                    GetDataFromNetForDetialsFans(url);
                }
            });
        }

    }

    private void GetDataFromNetForDetials(String url) {
        GetNetData.get(url, null, new OnGetDataListener() {
            @Override
            public void onSuccess(String json) {
                parseDataDetials(json);
            }

            @Override
            public void onError(String e) {


            }
        });
    }

    private void parseDataDetials(String json) {
        LikesBean likesBean = JSON.parseObject(json, LikesBean.class);
        goods = likesBean.getData().getItems().getGoods();
        if (goods != null) {
            adapter = new DarenLikeAdapter(this, goods);
            darenDetialsRecycler.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(this, 2);
            darenDetialsRecycler.setLayoutManager(manager);
            adapter.setOnItemClickListener(new DarenLikeAdapter.OnItemClickListener() {
                @Override
                public void getPosition(int position) {
                    String goods_id = goods.get(position).getGoods_id();
                    Intent intent = new Intent(DaRenShowDetialsOtherActivity.this, ShowGoodsInfoActivity.class);
                    intent.putExtra("goodsid", goods_id);
                    startActivity(intent);
                }
            });
        }

    }
}
