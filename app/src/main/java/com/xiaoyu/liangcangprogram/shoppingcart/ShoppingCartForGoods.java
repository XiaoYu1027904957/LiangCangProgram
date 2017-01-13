package com.xiaoyu.liangcangprogram.shoppingcart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.data.CartData;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShoppingCartForGoods extends AppCompatActivity {


    @InjectView(R.id.ib_back)
    ImageButton ibBack;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.tv_shopcart_edit)
    TextView tvShopcartEdit;
    @InjectView(R.id.recyclerview)
    RecyclerView recyclerview;
    @InjectView(R.id.tv_discount1)
    TextView tvDiscount1;
    @InjectView(R.id.tv_discount2)
    TextView tvDiscount2;
    @InjectView(R.id.tv_discount3)
    TextView tvDiscount3;
    @InjectView(R.id.tv_discount4)
    TextView tvDiscount4;
    @InjectView(R.id.checkbox_all)
    CheckBox checkboxAll;
    @InjectView(R.id.tv_shopcart_total)
    TextView tvShopcartTotal;
    @InjectView(R.id.tv_cart_commit)
    TextView tvCartCommit;
    private CartAdapter cartAdapter;

    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart_for_goods);
        ButterKnife.inject(this);

        initRV();
        initCheckBox();
    }


    private void initCheckBox() {
        checkboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartData.getInstance().setAllCheckOrNot(checkboxAll.isChecked());
                cartAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initRV() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this);
        cartAdapter.setIsAllCheckedListener(new CartAdapter.IsAllCheckedListener() {
            @Override
            public void isAllChecked(boolean isAll) {
                tvShopcartTotal.setText("￥ " + CartData.getInstance().getAllPrice());
                checkboxAll.setChecked(isAll);
            }
        });
        cartAdapter.setEdit(isEdit);
        recyclerview.setAdapter(cartAdapter);
        tvShopcartTotal.setText("￥ " + CartData.getInstance().getAllPrice());
    }


    @OnClick(R.id.tv_shopcart_edit)
    public void onClick() {
        setIsEdit();
    }

    private void setIsEdit() {
        isEdit = !isEdit;
        if (isEdit) {
            tvShopcartEdit.setText("完成");
        } else {
            tvShopcartEdit.setText("编辑");
        }
        cartAdapter.setEdit(isEdit);
        cartAdapter.notifyDataSetChanged();
    }
}
