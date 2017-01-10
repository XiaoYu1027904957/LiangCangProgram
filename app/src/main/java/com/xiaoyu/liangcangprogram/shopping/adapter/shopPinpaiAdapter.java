package com.xiaoyu.liangcangprogram.shopping.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.shopping.bean.PinPaiBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class shopPinpaiAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<PinPaiBean.DataBean.ItemsBean> datas;

    public shopPinpaiAdapter(Context mContext, List<PinPaiBean.DataBean.ItemsBean> datas) {
        this.mContext = mContext;
        this.datas = datas;

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.shop_pinpai_list_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        PinPaiBean.DataBean.ItemsBean itemsBean = datas.get(position);
        holder.pinpaiName.setText(itemsBean.getBrand_name());
        Glide.with(mContext).load(itemsBean.getBrand_logo()).into(holder.pinpaiIcon);
        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.pinpai_icon)
        ImageView pinpaiIcon;
        @InjectView(R.id.pinpai_name)
        TextView pinpaiName;
        @InjectView(R.id.pinpai_tomore)
        TextView pinpaiTomore;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
