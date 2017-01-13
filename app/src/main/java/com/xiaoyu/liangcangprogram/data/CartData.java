package com.xiaoyu.liangcangprogram.data;

import android.util.Log;

import com.xiaoyu.liangcangprogram.daren.bean.GoodsDetialsBean;

import java.util.ArrayList;

/**
 * 购物车数据 - 单例
 */

public class CartData {


    ArrayList<GoodsDetialsBean> list = new ArrayList();

    /**
     * 获得list数据
     */
    public ArrayList<GoodsDetialsBean> getCartList() {
        return list;
    }

    /**
     * 添加一个商品
     *
     * @param goods
     */
    public void addGoods(GoodsDetialsBean goods, int count) {
        String goods_id = goods.getData().getItems().getGoods_id();
        for (int i = 0; i < list.size(); i++) {
            GoodsDetialsBean.DataBean.ItemsBean items = list.get(i).getData().getItems();
            if (goods_id.equals(items.getGoods_id())) {
                items.setCount(count + items.getCount());
                return;
            }
        }

        list.add(goods);
    }

    /**
     * 根据位置获得一个物品的数据
     */
    public GoodsDetialsBean getGoods(int position) {
        if (position >= list.size() && position < 0) {
            return null;
        }
        return list.get(position);
    }

    /**
     * 添加一个商品
     */
    public void addOneGoods(int position) {
        GoodsDetialsBean.DataBean.ItemsBean items = list.get(position).getData().getItems();
        if (items.getCount() < 10) {
            Log.e("TAG", "222222" + items.getCount());
            items.setCount(items.getCount() + 1);
        }
    }

    /**
     * 减少一个商品
     */
    public void minusGoods(int position) {
        GoodsDetialsBean.DataBean.ItemsBean items = list.get(position).getData().getItems();
        if (items.getCount() > 0) {
            items.setCount(items.getCount() - 1);
        }
    }

    /**
     * 删除一个商品
     */
    public void removeGoods(int position) {
        list.get(position).getData().getItems().setCount(1);
        list.remove(position);
    }

    /**
     * 删除所有商品
     * 没有用处啊---好像---选定全选之后点击才有用。。。
     * 再看看吧
     */
    public void removeAllGoods() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).getData().getItems().setCount(1);
        }
        list.clear();
    }

    /**
     * 计算选中的金额
     */
    public double getAllPrice() {
        double price = 0;
        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getData().getItems().isChecked()) {
                    price += Double.parseDouble(list.get(i).getData().getItems().getPrice())
                            * list.get(i).getData().getItems().getCount();
                }
            }
        } catch (NumberFormatException e) {
//            Wzf.e("TAG", "CartData String转double出现异常" + e.getMessage());
        }
        return price;
    }

    /**
     * 判断是否全部选中
     */
    public boolean isAllChecked() {
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getData().getItems().isChecked()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 全选或者全不选
     */
    public void setAllCheckOrNot(boolean isChecked) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).getData().getItems().setChecked(isChecked);
        }
    }

    /**
     * 设置一个商品的数量
     * 保证存在，显示的即使list中存在的
     */
    public void setGoodsCount(int position, int count) {
        list.get(position).getData().getItems().setCount(count);
    }

    private static volatile CartData sInst = null;  // <<< 这里添加了 volatile

    public static CartData getInstance() {
        CartData inst = sInst;  // <<< 在这里创建临时变量
        if (inst == null) {
            synchronized (CartData.class) {
                inst = sInst;
                if (inst == null) {
                    inst = new CartData();
                    sInst = inst;
                }
            }
        }
        return inst;  // <<< 注意这里返回的是临时变量
    }


}
