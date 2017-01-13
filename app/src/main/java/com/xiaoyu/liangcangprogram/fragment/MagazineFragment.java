package com.xiaoyu.liangcangprogram.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoyu.liangcangprogram.ConstantUtils.NetUrl;
import com.xiaoyu.liangcangprogram.R;
import com.xiaoyu.liangcangprogram.base.BaseFragment;
import com.xiaoyu.liangcangprogram.data.Data;
import com.xiaoyu.liangcangprogram.magazine.activity.showTopActivity;
import com.xiaoyu.liangcangprogram.magazine.adapter.MagazineAdapter;
import com.xiaoyu.liangcangprogram.magazine.bean.MagazineBean;
import com.xiaoyu.liangcangprogram.magazine.bean.MagazineItemBean;
import com.xiaoyu.liangcangprogram.magazine.bean.Meat;
import com.xiaoyu.liangcangprogram.okHttpUtils.GetNetData;
import com.xiaoyu.liangcangprogram.okHttpUtils.OnGetDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yuxiaobai on 2017/1/6.
 */

public class MagazineFragment extends BaseFragment implements View.OnClickListener {
    @InjectView(R.id.mian_search)
    TextSwitcher mianSearch;
    @InjectView(R.id.main_title)
    TextView mainTitle;
    @InjectView(R.id.magazine_listview)
    ListView magazineListview;
    private LayoutInflater inflater;
    private List<MagazineItemBean> magazineItems;
    private List<String> items;
    private boolean hasMore;
    private List<List<MagazineItemBean>> magazineItemBeens;
    private MagazineBean magazineBean;

    @Override
    protected View initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.magazine_fragment, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        initTextSwitcher();
        getDataFromNet();
        initOnClickListener();
    }

    private void initOnClickListener() {
        mainTitle.setOnClickListener(this);

    }

    private void getDataFromNet() {

        GetNetData.get(NetUrl.MAGAZINE, null, new OnGetDataListener() {
            @Override
            public void onSuccess(String json) {
                parseData(json);
            }

            @Override
            public void onError(String e) {
                Toast.makeText(mContext, "联网错误" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 解析json数据
     *
     * @param json
     */
    private void parseData(String json) {
        magazineBean = new MagazineBean();
        JSONObject jsonObject = JSON.parseObject(json);

        String meta = jsonObject.getString("meta");
        Log.e("TAG", "-------》" + meta);
        Meat meat = JSON.parseObject(meta, Meat.class);
        magazineBean.setMeat(meat);
        String data = jsonObject.getString("data");
        JSONObject jsonObject1 = JSONObject.parseObject(data);

        Boolean has_more = jsonObject1.getBoolean("has_more");
        magazineBean.getData().setHas_more(has_more);
        Integer num_items = jsonObject1.getInteger("num_items");
        magazineBean.getData().setNum_items(num_items);

        String items = jsonObject1.getString("items");
        JSONObject jsonObject2 = JSONObject.parseObject(items);
        String keys = jsonObject2.getString("keys");
        List<String> keysArr = JSONArray.parseArray(keys, String.class);
        magazineBean.getData().setKeys(keysArr);
        Log.e("TAG", "keysArr" + keysArr);
        /**
         * 各个itemlist的数据
         */
        String infos = jsonObject2.getString("infos");
        JSONObject jsonObject4 = JSONObject.parseObject(infos);
        List<List<MagazineItemBean>> list = new ArrayList<>();
        for (int i = 0; i < keysArr.size(); i++) {
            String string = jsonObject4.getString(keysArr.get(i));

            List<MagazineItemBean> magazineItems = null;
            magazineItems = JSONArray.parseArray(string, MagazineItemBean.class);
            list.add(magazineItems);
            magazineBean.getData().setMagazineItemBeens(list);
            Data.getInstance().magazineBean = magazineBean;
            AnalysisData();
        }
    }

    private void AnalysisData() {
        if (magazineBean != null) {
            MagazineBean.Data data = magazineBean.getData();
            items = data.getKeys();
            magazineItemBeens = data.getMagazineItemBeens();
            hasMore = data.isHas_more();
            showViewOfGridView();
        }
    }



    private void showViewOfGridView() {
        if (items != null && items.size() > 0) {
            mianSearch.setText(items.get(0));
            magazineListview.setAdapter(new MagazineAdapter(mContext, magazineBean));
            magazineListview.setOnScrollListener(new AbsListView.OnScrollListener() {
                public int item;

                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (item != firstVisibleItem) {
                        mianSearch.setText(items.get(firstVisibleItem));
                        item = firstVisibleItem;

                    }
                }
            });
        }
    }


    private void initTextSwitcher() {
        mianSearch.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(mContext);
                textView.setSingleLine();
                textView.setTextSize(15);
                textView.setTextColor(Color.parseColor("#688EB6"));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
                lp.gravity = Gravity.CENTER;
                textView.setLayoutParams(lp);
                mianSearch.setInAnimation(mContext,R.anim.top_out);
                mianSearch.setOutAnimation(mContext,R.anim.bottom_in);
                return textView;
            }
        });
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, showTopActivity.class);
//         设置Activity的启动动画
        intent.setClassName(mContext, "com.xiaoyu.liangcangprogram.magazine.activity.showTopActivity");
        mContext.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.activity_open, 0);
    }
}
