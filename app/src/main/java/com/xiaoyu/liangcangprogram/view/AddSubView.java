package com.xiaoyu.liangcangprogram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaoyu.liangcangprogram.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by yuxiaobai on 2016/12/21.
 * <p>
 * 自定义钮控件
 */

public class AddSubView extends LinearLayout implements View.OnClickListener {
    private final Context mContext;
    @InjectView(R.id.iv_sub)
    ImageView ivSub;
    @InjectView(R.id.tv_value)
     public  TextView tvValue;
    @InjectView(R.id.iv_add)
    ImageView ivAdd;
//    设置最小值和最大值，和刚开始显示的值
    public  int value = 1;
    private int minValue = 1;
    private int maxValue = 10;



    public AddSubView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        View view = View.inflate(mContext, R.layout.add_sub_view, this);
        ButterKnife.inject(this, view);

//         设置点击事件
        ivSub.setOnClickListener(this);
        ivAdd.setOnClickListener(this);

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @OnClick({R.id.iv_sub, R.id.iv_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_sub:
                subNumber();
                break;
            case R.id.iv_add:
                addNumber();
                break;
        }
        if (numberChangeListener != null) {
            numberChangeListener.numberChange(value);
        }
    }

    //  计数家
    private void addNumber() {
        if (value < maxValue) {
            value++;
        }
        tvValue.setText(value + "");
    }

    //     计数减
    private void subNumber() {
        if (value > minValue) {
            value--;
        }
        tvValue.setText(value + "");
    }

    /**
     * 写一个接口来监听
     */

    public interface OnNumberChangeListener {
        /**
         * 档按钮被点击时回调
         */
       void numberChange(int value);
    }

    private OnNumberChangeListener numberChangeListener;

    /**
     * 监听数据的变化
     *
     * @param listener
     */

    public void setOnNumberChangeListener(OnNumberChangeListener listener) {
        this.numberChangeListener = listener;
    }
}
