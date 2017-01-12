package com.xiaoyu.liangcangprogram.shoppingcart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaoyu.liangcangprogram.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShoppingCartForGoods extends AppCompatActivity {

    @InjectView(R.id.detials_back)
    TextView detialsBack;
    @InjectView(R.id.title)
    RelativeLayout title;
    @InjectView(R.id.gouwuchelistview)
    ListView gouwuchelistview;
    @InjectView(R.id.buttom)
    LinearLayout buttom;
    @InjectView(R.id.activity_shopping_cart_for_goods)
    RelativeLayout activityShoppingCartForGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart_for_goods);
        ButterKnife.inject(this);
    }

}
