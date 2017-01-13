package com.xiaoyu.liangcangprogram.data;


import com.xiaoyu.liangcangprogram.daren.bean.GoodsDetialsBean;
import com.xiaoyu.liangcangprogram.magazine.bean.MagazineBean;
import com.xiaoyu.liangcangprogram.share.bean.ShareBean;

/**
 * Data用来存储，联网请求到的数据
 */

public class Data {

    private static volatile Data sInst = null;  // <<< 这里添加了 volatile

    public static Data getInstance() {
        Data inst = sInst;  // <<< 在这里创建临时变量
        if (inst == null) {
            synchronized (Data.class) {
                inst = sInst;
                if (inst == null) {
                    inst = new Data();
                    sInst = inst;
                }
            }
        }
        return inst;  // <<< 注意这里返回的是临时变量
    }


    /**
     * 联网请求到的分享的数据
     */
    public ShareBean shareBean;

    /**
     * 联网请求获得的杂志的数据
     */
    public MagazineBean magazineBean;


    /**
     * 上次请求到的商品详情页面的地址
     */
    public String goods_url;

    /**
     * 联网请求到的商品详情页面的信息
     */
    public GoodsDetialsBean goodsDetailsBean;

}
