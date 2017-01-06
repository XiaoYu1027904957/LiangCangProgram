package com.xiaoyu.liangcangprogram.okHttpUtils;

/**
 * Created by yuxiaobai on 2017/1/7.
 */

public interface OnGetDataListener {
    void  onSuccess(String json);
    void  onError(String e);
}
