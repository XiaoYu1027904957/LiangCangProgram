package com.xiaoyu.liangcangprogram.daren.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.daren.bean.GoodsDetialsBean;
import com.xiaoyu.liangcangprogram.data.CartData;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;
import com.xiaoyu.liangcangprogram.view.AddSubView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.AccordionTransformer;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShowGoodsInfotwoActivity extends AppCompatActivity {

    @InjectView(R.id.Goods_pic)
    Banner GoodsPic;
    @InjectView(R.id.GoodsInfo_name)
    TextView GoodsInfoName;
    @InjectView(R.id.goods_price)
    TextView goodsPrice;
    @InjectView(R.id.aixin)
    ImageView aixin;
    @InjectView(R.id.like_count)
    TextView likeCount;
    @InjectView(R.id.user_icon)
    ImageView userIcon;
    @InjectView(R.id.user_name)
    TextView userName;
    @InjectView(R.id.pinglun)
    LinearLayout pinglun;
    @InjectView(R.id.gouwuche)
    TextView gouwuche;
    @InjectView(R.id.buy)
    TextView buy;
    @InjectView(R.id.activity_show_goods_info)
    LinearLayout activityShowGoodsInfo;
    @InjectView(R.id.Gods_back)
    TextView GodsBack;
    private String goodsid;
    private String url;
    private ArrayList<String> imageurl;
    private ArrayList<String> arrayList;
    private GoodsDetialsBean goodsBean;
    //      缓存数据
    private GoodsDetialsBean tmpeGoodsBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_goods_info_two);
        ButterKnife.inject(this);
        initData();

    }


    private void initData() {
        arrayList = new ArrayList();
        Intent intent = getIntent();
        goodsid = intent.getStringExtra("goodsid");
        getDataFromNet();
    }

    private void getDataFromNet() {
        url = NetUrl.GOODS_HEAD + goodsid + NetUrl.GOODS_FOOT;
        GetNetData.get(url, null, new OnGetDataListener() {
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
        goodsBean = processData(json);
        imageurl = (ArrayList<String>) goodsBean.getData().getItems().getImages_item();

        if (json != null) {
            for (int i = 0; i < imageurl.size(); i++) {
                arrayList.add(imageurl.get(i));
            }
            GoodsPic.setImages(arrayList).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(ShowGoodsInfotwoActivity.this).load(path).into(imageView);
                }
            }).start();
//             设置样式
            GoodsPic.setBannerAnimation(AccordionTransformer.class);
            GoodsInfoName.setText(goodsBean.getData().getItems().getGoods_name());
            goodsPrice.setText(goodsBean.getData().getItems().getPrice());
            likeCount.setText(goodsBean.getData().getItems().getLike_count());
            Glide.with(this).load(goodsBean.getData().getItems().getHeadimg()).into(userIcon);
            userName.setText(goodsBean.getData().getItems().getOwner_name());
        }
    }

    private GoodsDetialsBean processData(String json) {
        return JSON.parseObject(json, GoodsDetialsBean.class);
    }


    @OnClick({R.id.Gods_back, R.id.gouwuche, R.id.buy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Gods_back:
                finish();
                break;
            case R.id.gouwuche:
                Toast.makeText(ShowGoodsInfotwoActivity.this, "我是popupwindow", Toast.LENGTH_SHORT).show();

                showPopPupWindow();
                break;
            case R.id.buy:
                Toast.makeText(ShowGoodsInfotwoActivity.this, "我要直接买我有钱任性", Toast.LENGTH_SHORT).show();
                Log.e("TAG", "--------------->" + goodsBean);
                Log.e("TAG", "----------------><-----" + goodsBean.getData().getItems().getCount());
                CartData.getInstance().addGoods(goodsBean,
                        goodsBean.getData().getItems().getCount());
                break;
        }
    }

    /**
     * 显示商品购买数量以及提交订单
     */
    private void showPopPupWindow() {

//        tmpeGoodsBean = CartStorage.getIntance(this).findData(goodsBean.getData().getItems().getGoods_id());
//        //         查找是否存在
//        boolean isExist;
//        if (tmpeGoodsBean == null) {
////            之前在购物车里没有
//            isExist = false;
//            tmpeGoodsBean = goodsBean.getData().getItems();
//        } else {
//            isExist = true;
//        }
//           1、 利用layoutInflate获得view
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popwindow_show_gouwuche, null);
//       2、  得到宽和高 getWindow().getDecorView().getWidth();,设置popwindow的宽高。
        final PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//       /3、 设置参数
// 设置popWindow弹出窗体可点击，必须进行如下设置。
        window.setFocusable(true);
//       4、 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xffffffff);
        window.setBackgroundDrawable(dw);
//        设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);

//       5、    不能使用BUtterKnife绑定视图
        ImageView goods_icon_gouwuche = (ImageView) view.findViewById(R.id.goods_icon_gouwuche);
        ImageView goods_delete = (ImageView) view.findViewById(R.id.goods_delete);
        TextView gouwuceh_goods_name = (TextView) view.findViewById(R.id.gouwuceh_goods_name);
        TextView gouwuceh_goods_introduce = (TextView) view.findViewById(R.id.gouwuceh_goods_introduce);
        TextView gouwuceh_goods_price = (TextView) view.findViewById(R.id.gouwuceh_goods_price);
        Button make_sure = (Button) view.findViewById(R.id.make_sure);
        AddSubView nasGoodinfoNum = (AddSubView) view.findViewById(R.id.nas_goodinfo_num);


//         6、加载图片
        Glide.with(this).load(goodsBean.getData().getItems().getGoods_image()).into(goods_icon_gouwuche);
        gouwuceh_goods_name.setText(goodsBean.getData().getItems().getGoods_name());
        gouwuceh_goods_introduce.setText(goodsBean.getData().getItems().getGoods_desc());
        gouwuceh_goods_price.setText(goodsBean.getData().getItems().getPrice());

//       设置最大值和最小指
        nasGoodinfoNum.tvValue.setText(goodsBean.getData().getItems().getCount() + "");
        nasGoodinfoNum.setMinValue(1);
        nasGoodinfoNum.setMaxValue(20);

//
        nasGoodinfoNum.setOnNumberChangeListener(new AddSubView.OnNumberChangeListener() {
            @Override
            public void numberChange(int value) {

                goodsBean.getData().getItems().setCount(value);
            }
        });
//
//
////  设置显示
        window.showAtLocation(ShowGoodsInfotwoActivity.this.findViewById(R.id.showpopupwindow), Gravity.BOTTOM, 0, 0);
//          设置监听(自己写接口)
//
//        设置取消按钮的点击事件
//        goods_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tmpeGoodsBean.setNumber(goodsBean.getData().getItems().getNumber());
//                window.dismiss();
//
//            }
//        });
//         设置确认按钮的监听
        make_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowGoodsInfotwoActivity.this, "00000000000000000000000", Toast.LENGTH_SHORT).show();
                window.dismiss();
                CartData.getInstance().addGoods(goodsBean,
                        goodsBean.getData().getItems().getCount());
            }
        });
//        设置window消失的监听
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                window.dismiss();
            }
        });
    }
}
