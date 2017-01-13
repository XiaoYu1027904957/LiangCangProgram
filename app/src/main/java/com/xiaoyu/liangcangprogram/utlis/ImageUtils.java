package com.xiaoyu.liangcangprogram.utlis;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.util.Util;
import com.squareup.picasso.Picasso;

/**
 * 图片加载工具
 */

public class ImageUtils {


    public static void Picasso(Context mContext, String url, ImageView imageView) {
        Picasso.with(mContext).load(url).into(imageView);
    }

    public static void Glide(Context mContext, String url, ImageView imageView) {
        if (Util.isOnMainThread()) {
            Glide.with(mContext).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }
    }
}
