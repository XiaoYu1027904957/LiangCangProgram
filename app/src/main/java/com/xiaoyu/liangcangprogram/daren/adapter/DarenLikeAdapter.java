package com.xiaoyu.liangcangprogram.daren.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.daren.bean.LikesBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/9.
 */

public class DarenLikeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private final List<LikesBean.DataBean.ItemsBean.GoodsBean> datas;


    private LayoutInflater inflater;

    public DarenLikeAdapter(Context mContext, List<LikesBean.DataBean.ItemsBean.GoodsBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.share_image_show, parent, false);
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
        @InjectView(R.id.share_image)
        ImageView shareImage;

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


        public void setData(LikesBean.DataBean.ItemsBean.GoodsBean goodsBean) {
            Glide.with(mContext).load(goodsBean.getGoods_image()).into(shareImage);
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
