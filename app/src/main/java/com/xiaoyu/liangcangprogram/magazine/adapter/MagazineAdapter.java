package com.xiaoyu.liangcangprogram.magazine.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.magazine.bean.MagazineBean;
import com.xiaoyu.liangcangprogram.shopping.activity.WebShowInfoActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/11.
 */

public class MagazineAdapter extends BaseAdapter {
    private final Context mContext;
    private final MagazineBean magazineBean;
    private LayoutInflater inflater;
    private List<String> keys;

    public MagazineAdapter(Context mContext, MagazineBean magazineBean) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.magazineBean = magazineBean;
        keys = magazineBean.getData().getKeys();
    }

    @Override
    public int getCount() {
        return keys.size();
    }

    @Override
    public Object getItem(int position) {
        return keys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.listview_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        int pos = magazineBean.getData().getMagazineItemBeens().get(position).size();
        holder.timePicShow.removeAllViews();
        for (int i = 0; i < pos; i++) {
            View view = View.inflate(mContext, R.layout.iamge_show, null);
            ImageView image = (ImageView) view.findViewById(R.id.image_show_item);
            TextView text = (TextView) view.findViewById(R.id.introduce1);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.addshow);
            Glide.with(mContext).load(magazineBean.getData().getMagazineItemBeens().get(position).get(i).getCover_img_new()).crossFade().animate(R.anim.anim).skipMemoryCache(true).into(image);
            text.setText(magazineBean.getData().getMagazineItemBeens().get(position).get(i).getTopic_name());
            holder.timePicShow.addView(relativeLayout);
            holder.timeName.setText(keys.get(position));
            final int finalI = i;
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                    String topic_url = magazineBean.getData().getMagazineItemBeens().get(position).get(finalI).getAccess_url();
                    intent.putExtra("weburl", topic_url);
                    mContext.startActivity(intent);
                }
            });
        }
        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.time_name)
        TextView timeName;
        @InjectView(R.id.time_pic_show)
        LinearLayout timePicShow;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
