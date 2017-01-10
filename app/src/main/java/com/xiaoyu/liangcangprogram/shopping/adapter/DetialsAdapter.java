package com.xiaoyu.liangcangprogram.shopping.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.shopping.bean.DetialsBean;

import java.util.List;

/**
 * Created by yuxiaobai on 2017/1/9.
 */

public class DetialsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private final List<DetialsBean.DataBean.ItemsBean> items;
    private LayoutInflater inflater;

    public DetialsAdapter(Context mContext, List<DetialsBean.DataBean.ItemsBean> items) {
        this.mContext = mContext;
        this.items = items;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_detials_show, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
