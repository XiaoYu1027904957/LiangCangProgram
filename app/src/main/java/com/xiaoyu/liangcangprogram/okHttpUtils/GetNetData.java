package com.xiaoyu.liangcangprogram.okHttpUtils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by yuxiaobai on 2017/1/7.
 * 封装okhttputils
 */

public class GetNetData {

    public static void get(String url, Map<String, String> map, final OnGetDataListener onGetDataListener) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (onGetDataListener != null) {
                    onGetDataListener.onError(e.getMessage());
                }
            }

            @Override
            public void onResponse(String response, int id) {
                if (onGetDataListener != null) {
                    onGetDataListener.onSuccess(response);
                }

            }
        });

    }


}
