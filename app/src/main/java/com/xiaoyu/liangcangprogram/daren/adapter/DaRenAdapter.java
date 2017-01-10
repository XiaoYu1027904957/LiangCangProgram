package com.xiaoyu.liangcangprogram.daren.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.daren.bean.DaRenBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/9.
 */

public class DaRenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private final List<DaRenBean.DataBean.ItemsBean> datas;
    LayoutInflater inflater;


    public DaRenAdapter(Context mContext, List<DaRenBean.DataBean.ItemsBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.daren_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setData(datas.get(position));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.daren_image_show)
        ImageView darenImageShow;
        @InjectView(R.id.name)
        TextView name;
        @InjectView(R.id.introduce)
        TextView introduce;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.getPosition(getAdapterPosition());
                    }
                }
            });
        }

        public void setData(DaRenBean.DataBean.ItemsBean itemsBean) {
            Glide.with(mContext).load(itemsBean.getUser_images().getOrig()).into(darenImageShow);
            name.setText(itemsBean.getUsername());
            introduce.setText(itemsBean.getDuty());
        }
    }

    public interface OnItemClickListener {
        void getPosition(int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
