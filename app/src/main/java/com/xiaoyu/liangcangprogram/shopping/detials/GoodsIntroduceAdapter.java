package com.xiaoyu.liangcangprogram.shopping.detials;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.shopping.bean.NewDetilasBean;
import com.xiaoyu.liangcangprogram.shopping.bean.PinPaiDetialBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/9.
 */

public class GoodsIntroduceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private  Context mContext;
    private  List<NewDetilasBean.DataBean.ItemsBean> datas;
    private  List<PinPaiDetialBean.DataBean.ItemsBean> list;
    private LayoutInflater inflater;

    public GoodsIntroduceAdapter(Context mContext, List<NewDetilasBean.DataBean.ItemsBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        inflater = LayoutInflater.from(mContext);

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_goods_item, parent, false);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.GoodsInfo_icon)
        ImageView GoodsInfoIcon;
        @InjectView(R.id.GoodsInfo_name)
        TextView GoodsInfoName;
        @InjectView(R.id.like_personal)
        TextView likePersonal;
        @InjectView(R.id.GoodsInfo_introduce)
        TextView GoodsInfoIntroduce;
        @InjectView(R.id.goods_price)
        TextView goodsPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }


        public void setData(NewDetilasBean.DataBean.ItemsBean itemsBean) {
            Glide.with(mContext).load(itemsBean.getGoods_image()).into(GoodsInfoIcon);
            GoodsInfoName.setText(itemsBean.getGoods_name());
            GoodsInfoIntroduce.setText(itemsBean.getBrand_info().getBrand_name());
            likePersonal.setText(itemsBean.getLike_count());
            goodsPrice.setText("￥" + itemsBean.getPrice());

        }
    }
}
