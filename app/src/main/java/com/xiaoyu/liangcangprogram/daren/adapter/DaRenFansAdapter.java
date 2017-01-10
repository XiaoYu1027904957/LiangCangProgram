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
import com.xiaoyu.liangcangprogram.daren.bean.FansBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/9.
 */

public class DaRenFansAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private final List<FansBean.DataBean.ItemsBean.UsersBean> datas;
    private LayoutInflater inflater;


    public DaRenFansAdapter(Context mContext, List<FansBean.DataBean.ItemsBean.UsersBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.daren_recycler_fans_item, parent, false);
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

        public void setData(FansBean.DataBean.ItemsBean.UsersBean usersBean) {
            Glide.with(mContext).load(usersBean.getUser_image().getOrig()).into(darenImageShow);
            name.setText(usersBean.getUser_name());

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
