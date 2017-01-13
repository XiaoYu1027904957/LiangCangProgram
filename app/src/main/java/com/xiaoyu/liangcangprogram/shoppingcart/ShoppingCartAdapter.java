package com.xiaoyu.liangcangprogram.shoppingcart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.daren.bean.GoodsDetialsBean;

import java.util.Iterator;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/13.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    private final Context mContext;
    private final List<GoodsDetialsBean.DataBean.ItemsBean> datas;
    private final RadioButton checkBoxall;
    private final TextView tvShopcartTotal;



    private LayoutInflater inflater;


    public ShoppingCartAdapter(Context mContext, List<GoodsDetialsBean.DataBean.ItemsBean> datas, RadioButton checkBoxall, TextView tvShopcartTotal) {
        this.mContext = mContext;
        this.datas = datas;
        inflater = LayoutInflater.from(mContext);
        this.checkBoxall = checkBoxall;
        this.tvShopcartTotal = tvShopcartTotal;

//               显示总价格
        showTotalPrice();
    }

    public void showTotalPrice() {
        tvShopcartTotal.setText(getTotalPrice() + "");
    }

    public double getTotalPrice() {
        double total = 0;
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                GoodsDetialsBean.DataBean.ItemsBean goodsBean = datas.get(i);
//                if (goodsBean.isChecked()) {
//                    total += Double.parseDouble(goodsBean.getCover_price()) * Double.parseDouble(goodsBean.getNumber() + "");
//
//                }
            }
        }
        return total;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.goodsinfo_item, null));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//         得到该位置的数据
        final GoodsDetialsBean.DataBean.ItemsBean goodsBean = datas.get(position);
////         绑定数据
//        holder.cbGov.setChecked(goodsBean.isChecked());
////         图片
//        Glide.with(mContext).load(ConstantUtils.BASE_URL_IMAGE + goodsBean.getFigure()).into(holder.ivGov);
//        holder.tvDescGov.setText(goodsBean.getName());//商品名字
//        holder.tvPriceGov.setText("￥" + goodsBean.getCover_price());//商品价格
//        holder.addSubView.setValue(goodsBean.getNumber());
//        holder.addSubView.tvValue.setText(goodsBean.getNumber() + "");
//        Log.e("TAG", "----------++++--------" + goodsBean.getNumber());
//        //至少要购买一个
//        holder.addSubView.setMinValue(1);
//        //设置商品库存
//        holder.addSubView.setMaxValue(100);
//
//        holder.addSubView.setOnNumberChangeListener(new AddSubView.OnNumberChangeListener() {
//            @Override
//            public void numberChange(int value) {
////                 对象设置数据
//                goodsBean.setNumber(value);
//                Log.e("TAG", "------------------" + goodsBean.getNumber());
////                显示总价格
//                showTotalPrice();
//                //3.同步到内存和本地中
//                CartStorage.getIntance(mContext).updataData(goodsBean);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.chick)
        RadioButton chick;
        @InjectView(R.id.icon_shopcart)
        ImageView iconShopcart;
        @InjectView(R.id.name_shopcart)
        TextView nameShopcart;
        @InjectView(R.id.ntroduce_shopcart)
        TextView ntroduceShopcart;
        @InjectView(R.id.price_shopcart)
        TextView priceShopcart;
        @InjectView(R.id.number)
        TextView number;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
//            设置对点击某一项的监听
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClickListener(v, getLayoutPosition());

                    }
                }
            });


        }


    }


    /**
     * 写一个接口监听item的点击事件
     * 回调点击事件的监听
     */
    public OnItemClickListener itemClickListener;

    /**
     * 点击item的监听
     */
    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    /**
     * 设置item的监听
     *
     * @param l
     */
    public void setOnItemClickListener(OnItemClickListener l) {
        this.itemClickListener = l;
    }


    /**
     * 校验CheckBox状态
     */
    public void CheckAll() {

        if (datas != null && datas.size() > 0) {
            int number = 0;
            for (int i = 0; i < datas.size(); i++) {
                GoodsDetialsBean.DataBean.ItemsBean goodsBean = datas.get(i);
//                if (!goodsBean.isChecked()) {
//                    checkBoxall.setChecked(false);
////                    checkboxDeleteAll.setChecked(false);
//                } else {
//                    number++;
//                }
            }

            if (datas.size() == number) {
                checkBoxall.setChecked(true);
//                checkboxDeleteAll.setChecked(true);

            }

        } else {
            checkBoxall.setChecked(false);
//            checkboxDeleteAll.setChecked(false);
        }
    }

    /**
     * 全选反选
     */
    public void checkAll_none(boolean checked) {
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
//                datas.get(i).setChecked(checked);
                checkBoxall.setChecked(checked);
//                checkboxDeleteAll.setChecked(checked);
                notifyItemChanged(i);
            }
        } else {
            checkBoxall.setChecked(false);
//            checkboxDeleteAll.setChecked(false);
        }

    }

    /**
     * 删除数据, 使用迭代器进行数据的存储
     */
    public void deleteData() {

        if (datas != null && datas.size() > 0) {
            for (Iterator iterator = datas.iterator(); iterator.hasNext(); ) {
//                GoodsBean goodsBean = (GoodsBean) iterator.next();
//                if (goodsBean.isChecked()) {
////                    根据对象找到在列表中的位置
//                    int position = datas.indexOf(goodsBean);
//                    iterator.remove();
////                     从本地删除
//                    CartStorage.getIntance(mContext).deteleData(goodsBean);
////                     刷新界面
//                    notifyItemRemoved(position);
//
//                }
            }
        }
    }

}
