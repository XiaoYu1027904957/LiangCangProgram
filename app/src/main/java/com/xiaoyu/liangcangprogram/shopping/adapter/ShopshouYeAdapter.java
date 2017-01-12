package com.xiaoyu.liangcangprogram.shopping.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.shopping.activity.WebShowInfoActivity;
import com.xiaoyu.liangcangprogram.shopping.bean.ShouYeBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.AccordionTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/8.
 */

public class ShopshouYeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<ShouYeBean.DataBean.ItemsBean.ListBeanX> list;
    private final Context mContext;
    private int currentType;

    /**
     * 书写6个item
     *
     * @param mContext
     * @param list
     */
    private static final int ITEM1 = 0;
    private static final int ITEM2 = 1;
    private static final int ITEM3 = 2;
    private static final int ITEM4 = 3;
    private static final int ITEM5 = 4;
    private static final int ITEM6 = 5;

    public ShopshouYeAdapter(Context mContext, List<ShouYeBean.DataBean.ItemsBean.ListBeanX> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM1) {
            View view = View.inflate(mContext, R.layout.shop_shouye_banner_item, null);
            return new BannerViewHolder(view);
        } else if (viewType == ITEM2) {
//            View view = View.inflate(mContext, R.layout.shop_shouye_two_item, null);
            View view = LayoutInflater.from(mContext).inflate(R.layout.shop_shouye_two_item, parent, false);
            return new SecondViewHolder(view);
        } else if (viewType == ITEM3) {
//            View view = View.inflate(mContext, R.layout.shop_shouye_three_item, null);
            View view = LayoutInflater.from(mContext).inflate(R.layout.shop_shouye_three_item, parent, false);
            return new ThirdViewHolder(view);
        } else if (viewType == ITEM4) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.shop_shouye_four_item, parent, false);
            return new FourViewHolder(view);
        } else if (viewType == ITEM5) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.shop_shouye_three_item, parent, false);
            return new ThirdViewHolder(view);
        } else if (viewType == ITEM6) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.shop_shouye_four_item, parent, false);
            return new FourViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == ITEM1) {
            BannerViewHolder ViewHolder = (BannerViewHolder) holder;
            ViewHolder.setData(list.get(position));
        } else if (position == ITEM2) {
            SecondViewHolder ViewHolder = (SecondViewHolder) holder;
            ViewHolder.setData(list.get(position));
        } else if (position == ITEM3) {
            ThirdViewHolder ViewHolder = (ThirdViewHolder) holder;
            ViewHolder.setData(list.get(position));
        } else if (position == ITEM4) {
            FourViewHolder ViewHolder = (FourViewHolder) holder;
            ViewHolder.setData(list.get(position));
        } else if (position == ITEM5) {
            ThirdViewHolder ViewHolder = (ThirdViewHolder) holder;
            ViewHolder.setData(list.get(position));
        } else if (position == ITEM6) {
            FourViewHolder ViewHolder = (FourViewHolder) holder;
            ViewHolder.setData(list.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == ITEM1) {
            currentType = ITEM1;
        } else if (position == ITEM2) {
            currentType = ITEM2;
        } else if (position == ITEM3) {
            currentType = ITEM3;
        } else if (position == ITEM4) {
            currentType = ITEM4;
        } else if (position == ITEM5) {
            currentType = ITEM5;
        } else if (position == ITEM6) {
            currentType = ITEM6;
        }
        return currentType;
    }


    public class BannerViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.shop_banner_item)
        Banner shopBannerItem;

        public BannerViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, itemView);
        }

        public void setData(ShouYeBean.DataBean.ItemsBean.ListBeanX listBeanX) {
            final List<ShouYeBean.DataBean.ItemsBean.ListBeanX.ListBean> item = listBeanX.getList();
//            集合中添加图片的url
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < item.size(); i++) {
                arrayList.add(item.get(i).getPic_url());
            }
            shopBannerItem.setImages(arrayList).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(mContext).load(path).into(imageView);
                }
            }).start();
//             设置样式
            shopBannerItem.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            shopBannerItem.setBannerAnimation(AccordionTransformer.class);
            shopBannerItem.setDelayTime(1000);
            shopBannerItem.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    if (item.get(position - 1).getTopic_url().trim().equals("")) {
                        String topic_url = item.get(position - 1).getTopic_url();
                        Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                        intent.putExtra("weburl", topic_url);
                        mContext.startActivity(intent);
                    }

                }
            });

        }
    }

    public class SecondViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.one_image)
        ImageView oneImage;
        @InjectView(R.id.two_image)
        ImageView twoImage;
        @InjectView(R.id.three_image)
        ImageView threeImage;
        @InjectView(R.id.four_image)
        ImageView fourImage;

        public SecondViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void setData(final ShouYeBean.DataBean.ItemsBean.ListBeanX listBeanX) {
            Glide.with(mContext).load(listBeanX.getOne().getPic_url()).into(oneImage);
            Glide.with(mContext).load(listBeanX.getTwo().getPic_url()).into(twoImage);
            Glide.with(mContext).load(listBeanX.getThree().getPic_url()).into(threeImage);
            Glide.with(mContext).load(listBeanX.getFour().getPic_url()).into(fourImage);
            oneImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listBeanX.getOne().getTopic_url().trim().equals("")) {
                        String topic_url = listBeanX.getOne().getTopic_url();
                        Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                        intent.putExtra("weburl", topic_url);
                        mContext.startActivity(intent);
                    }
                }
            });
            twoImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listBeanX.getTwo().getTopic_url().trim().equals("")) {
                        String topic_url = listBeanX.getTwo().getTopic_url();
                        Log.e("TAG", "==========" + listBeanX.getTwo().getTopic_url());
                        Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                        intent.putExtra("weburl", topic_url);
                        mContext.startActivity(intent);
                    }
                }
            });
            threeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listBeanX.getThree().getTopic_url().trim().equals("")) {
                        String topic_url = listBeanX.getThree().getTopic_url();
                        Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                        intent.putExtra("weburl", topic_url);
                        mContext.startActivity(intent);
                    }
                }
            });
            fourImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listBeanX.getFour().getTopic_url().trim().equals("")) {
                        String topic_url = listBeanX.getFour().getTopic_url();
                        Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                        intent.putExtra("weburl", topic_url);
                        mContext.startActivity(intent);
                    }
                }
            });

        }
    }

    public class ThirdViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.shouye_item_three)
        ImageView shouyeItemThree;

        public ThirdViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void setData(final ShouYeBean.DataBean.ItemsBean.ListBeanX listBeanX) {
            Glide.with(mContext).load(listBeanX.getOne().getPic_url()).into(shouyeItemThree);
            shouyeItemThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listBeanX.getOne().getTopic_url().trim().equals("")) {
                        String topic_url = listBeanX.getOne().getTopic_url();
                        Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                        intent.putExtra("weburl", topic_url);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }

    public class FourViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.four_one)
        ImageView fourOne;
        @InjectView(R.id.four_two)
        ImageView fourTwo;

        public FourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void setData(final ShouYeBean.DataBean.ItemsBean.ListBeanX listBeanX) {
            Glide.with(mContext).load(listBeanX.getOne().getPic_url()).into(fourOne);
            Glide.with(mContext).load(listBeanX.getTwo().getPic_url()).into(fourTwo);
            fourOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listBeanX.getOne().getTopic_url().trim().equals("")) {
                        String topic_url = listBeanX.getOne().getTopic_url();
                        Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                        intent.putExtra("weburl", topic_url);

                        mContext.startActivity(intent);
                    }
                }
            });

            fourTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!listBeanX.getTwo().getTopic_url().trim().equals("")) {
                        String topic_url = listBeanX.getTwo().getTopic_url();
                        Log.e("TAG", "==========" + listBeanX.getTwo().getTopic_url());
                        Intent intent = new Intent(mContext, WebShowInfoActivity.class);
                        intent.putExtra("weburl", topic_url);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }

}
