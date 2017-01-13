package com.xiaoyu.liangcangprogram.shoppingcart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.daren.bean.GoodsDetialsBean;
import com.xiaoyu.liangcangprogram.data.CartData;
import com.xiaoyu.liangcangprogram.utlis.ImageUtils;
import com.xiaoyu.liangcangprogram.view.AddSubView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 购物车显示的item的适配器
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {


    private final Context mContext;
    /**
     * 设置是否编辑模式
     */
    private boolean isEdit;

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public CartAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_shopping_cart, null);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, final int position) {
        final GoodsDetialsBean goods = CartData.getInstance().getGoods(position);
        boolean checked = goods.getData().getItems().isChecked();

        ImageUtils.Picasso(mContext, goods.getData().getItems().getGoods_image(), holder.ivGov);
        holder.tvDescGov.setText(goods.getData().getItems().getGoods_name());
        holder.tvPriceGov.setText("￥" + goods.getData().getItems().getPrice());
        holder.cbGov.setChecked(checked);
        holder.cbGov.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                goods.getData().getItems().setChecked(isChecked);
                isAllChecked.isAllChecked(CartData.getInstance().isAllChecked());
            }
        });

        if (isEdit) {
            //编辑
            holder.addSubView.setVisibility(View.VISIBLE);
            holder.buttonDelete.setVisibility(View.VISIBLE);
            holder.addSubView.setValue(goods.getData().getItems().getCount());
            holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "11111111111111", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(mContext).setTitle("是否确定删除")
                            .setMessage("是否确定删除此商品")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    CartData.getInstance().removeGoods(position);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("取消", null)
                            .show();
                }
            });
            holder.tvShopCartZhonglei.setVisibility(View.GONE);
            holder.tvShopCartCount.setVisibility(View.GONE);
        } else {
            //完成
            holder.addSubView.setVisibility(View.GONE);
            holder.buttonDelete.setVisibility(View.GONE);
            holder.tvShopCartZhonglei.setVisibility(View.VISIBLE);
            //设置种类的数据
            holder.tvShopCartZhonglei.setText("先固定写" + goods.getData().getItems().getShuXing());
            holder.tvShopCartCount.setVisibility(View.VISIBLE);
            holder.tvShopCartCount.setText("x" + goods.getData().getItems().getCount());
        }


    }

    @Override
    public int getItemCount() {
        return CartData.getInstance().getCartList().size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.cb_gov)
        CheckBox cbGov;
        @InjectView(R.id.iv_gov)
        ImageView ivGov;
        @InjectView(R.id.addSubView)
        AddSubView addSubView;
        @InjectView(R.id.tv_desc_gov)
        TextView tvDescGov;
        @InjectView(R.id.tv_shop_cart_zhonglei)
        TextView tvShopCartZhonglei;
        @InjectView(R.id.tv_price_gov)
        TextView tvPriceGov;
        @InjectView(R.id.button_delete)
        Button buttonDelete;
        @InjectView(R.id.tv_shop_cart_count)
        TextView tvShopCartCount;
        private Context mContext;

        public CartViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }

    private IsAllCheckedListener isAllChecked;

    public void setIsAllCheckedListener(IsAllCheckedListener isAllChecked) {
        this.isAllChecked = isAllChecked;
    }


    public interface IsAllCheckedListener {
        void isAllChecked(boolean isAll);
    }
}
