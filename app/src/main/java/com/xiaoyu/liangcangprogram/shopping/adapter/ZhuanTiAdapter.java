package com.xiaoyu.liangcangprogram.shopping.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.shopping.bean.ZhuanTiBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class ZhuanTiAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ZhuanTiBean.DataBean.ItemsBean> datas;

    public ZhuanTiAdapter(Context mContext, List<ZhuanTiBean.DataBean.ItemsBean> datas) {
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
            convertView = View.inflate(mContext, R.layout.shop_zhuanti_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ZhuanTiBean.DataBean.ItemsBean itemsBean = datas.get(position);
        holder.zhuantiContent.setText(itemsBean.getTopic_name());
        Glide.with(mContext).load(itemsBean.getCover_img()).into(holder.zhuantiImage);
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.zhuanti_image)
        ImageView zhuantiImage;
        @InjectView(R.id.zhuanti_content)
        TextView zhuantiContent;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }


}
