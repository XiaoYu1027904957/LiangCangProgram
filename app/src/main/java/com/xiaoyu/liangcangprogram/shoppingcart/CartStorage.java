package com.xiaoyu.liangcangprogram.shoppingcart;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaoyu.liangcangprogram.daren.bean.GoodsDetialsBean;
import com.xiaoyu.liangcangprogram.utlis.CacheUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiaobai on 2017/1/12.
 * 购物车存储类
 */

public class CartStorage {
    private static CartStorage cartStorage;
    private final Context mContext;
    private SparseArray<GoodsDetialsBean.DataBean.ItemsBean> SparseArray;
    private static final String JSON_CART = "json_cart";

    private CartStorage(Context context) {
        this.mContext = context;
        SparseArray = new SparseArray<>();
        ListToSpare();
    }

    private void ListToSpare() {
        List<GoodsDetialsBean.DataBean.ItemsBean> list = getAllData();
        if (list != null && list.size() > 0) for (int i = 0; i < list.size(); i++) {
            GoodsDetialsBean.DataBean.ItemsBean goodsDetialBean = list.get(i);
            Log.e("TAG", "SparseArray" + SparseArray.toString());
            SparseArray.put(Integer.valueOf(goodsDetialBean.getGoods_id()), goodsDetialBean);
        }
    }

    public List<GoodsDetialsBean.DataBean.ItemsBean> getAllData() {
        return getDataFronLoacl();
    }

    private List<GoodsDetialsBean.DataBean.ItemsBean> getDataFronLoacl() {
        List<GoodsDetialsBean.DataBean.ItemsBean> list = new ArrayList<>();
//        得到保持的数据
        String savejson = CacheUtils.getString(mContext, JSON_CART);
        if (TextUtils.isEmpty(savejson)) {
            list = new Gson().fromJson(savejson, new TypeToken<List<GoodsDetialsBean>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 得到CartStorage的实例
     */
    public static CartStorage getIntance(Context context) {

        if (cartStorage == null) {
            synchronized (CartStorage.class) {
                if (cartStorage != null) {
                    cartStorage = new CartStorage(context);
                }
            }
        }
        return cartStorage;
    }

    /**
     * 添加数据
     */
    public void addData(GoodsDetialsBean goodsDetialsBean,int count) {
        GoodsDetialsBean.DataBean.ItemsBean temp = SparseArray.get(Integer.valueOf(goodsDetialsBean.getData().getItems().getGoods_id()));
//        if (temp != null) {
////            存在
//            temp.setNumber(temp.getNumber() + goodsDetialsBean.getData().getItems().getNumber());
//        } else {
//            temp = goodsDetialsBean.getData().getItems();
////            至少设置一个
//            Log.e("TAG", goodsDetialsBean.getData().getItems().getNumber() + "");
//            temp.setNumber(goodsDetialsBean.getData().getItems().getNumber());
//        }
    }

    /**
     * 修改数据
     */
    public void updataData(GoodsDetialsBean goodsDetialsBean) {
        SparseArray.put(Integer.parseInt(goodsDetialsBean.getData().getItems().getGoods_id()), goodsDetialsBean.getData().getItems());
        commit();
    }

    //     提交数据的方法
    private void commit() {
        List<GoodsDetialsBean.DataBean.ItemsBean> list = sparseArrayToList();
        String json = new Gson().toJson(list);
        CacheUtils.putString(mContext, JSON_CART, json);
    }

    /**
     * sparseArray转List数据
     *
     * @return
     */
    private List<GoodsDetialsBean.DataBean.ItemsBean> sparseArrayToList() {
        List<GoodsDetialsBean.DataBean.ItemsBean> list = new ArrayList<>();
        for (int i = 0; i < SparseArray.size(); i++) {
            GoodsDetialsBean.DataBean.ItemsBean goodsBean = SparseArray.valueAt(i);
            list.add(goodsBean);
        }

        return list;
    }

    public GoodsDetialsBean.DataBean.ItemsBean findData(String product_id) {
        GoodsDetialsBean.DataBean.ItemsBean goodsBean = SparseArray.get(Integer.parseInt(product_id));
        return goodsBean;
    }
}
