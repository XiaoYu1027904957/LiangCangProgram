package com.xiaoyu.liangcangprogram.data;

import com.xiaoyu.liangcangprogram.magazine.bean.MagazineBean;

/**
 * Created by yuxiaobai on 2017/1/11.
 */

public class Data {
    //      单利模式
    private static volatile Data minstance = null;  // <<< 这里添加了 volatile

    public static Data getInstance() {
        Data instance = minstance;   //<<< 创建临时变量
        if (instance == null) {
            synchronized (Data.class) {
                instance = minstance;
                if (instance == null) {
                    instance = new Data();
                }
            }
        }
        return instance;
    }

    /**
     * 联网请求获得的杂志的数据
     */
    public MagazineBean magazineBean;


}
