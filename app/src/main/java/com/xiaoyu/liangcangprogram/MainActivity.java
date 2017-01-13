package com.xiaoyu.liangcangprogram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xiaoyu.liangcangprogram.fragment.DaRenFragment;
import com.xiaoyu.liangcangprogram.fragment.MagazineFragment;
import com.xiaoyu.liangcangprogram.fragment.PersonalFragment;
import com.xiaoyu.liangcangprogram.fragment.ShareFragment;
import com.xiaoyu.liangcangprogram.fragment.ShopFragment;
import com.xiaoyu.liangcangprogram.shopping.detials.ShowDetialsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.main_framelayout)
    FrameLayout mainFramelayout;
    @InjectView(R.id.main_shopping)
    RadioButton mainShopping;
    @InjectView(R.id.main_magazine)
    RadioButton mainMagazine;
    @InjectView(R.id.main_doyen)
    RadioButton mainDoyen;
    @InjectView(R.id.main_share)
    RadioButton mainShare;
    @InjectView(R.id.main_personal)
    RadioButton mainPersonal;
    @InjectView(R.id.main_rg)
    RadioGroup mainRg;
    private List<Fragment> fragments;
    /**
     * 正在显示的fragment
     */
    private Fragment temfragment;
    private Fragment lastfragment;
    private int position;
    private Fragment currentfragment;
    int currentfragmentposition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initfragment();
        setOnCheckedListener();
//        getCurrentFragment();
    }

    /**
     * 对Radio设置监听
     */
    private void setOnCheckedListener() {
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_shopping:
                        position = 0;
                        break;
                    case R.id.main_magazine:
                        position = 1;
                        break;
                    case R.id.main_doyen:
                        position = 2;
                        break;
                    case R.id.main_share:
                        position = 3;
                        break;
                    case R.id.main_personal:
                        position = 4;
                        break;
                }
//                得到当前需要显示的fragment

                currentfragment = getFragmet(position);
                SwitchFragment(currentfragment);
            }
        });
        mainRg.check(R.id.main_shopping);
    }

    public void SwitchFragment(Fragment currentfragment) {
        if (temfragment != currentfragment) {
            if (currentfragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (currentfragment == fragments.get(5)) {
                    transaction.setCustomAnimations(R.anim.right_in, R.anim.left_out);
                } else if (temfragment == fragments.get(5)) {
                    transaction.setCustomAnimations(R.anim.left_in, R.anim.right_out);
                }
                if (!currentfragment.isAdded()) {
                    if (temfragment != null) {
                        transaction.hide(temfragment);
                    }
                    transaction.add(R.id.main_framelayout, currentfragment);
                } else {
                    if (temfragment != null) {
                        transaction.hide(temfragment);
                    }

                    transaction.show(currentfragment);
                }
                transaction.commit();
                lastfragment = temfragment;
                temfragment = currentfragment;
            }
        }
    }

    /**
     * 选择显示的fragment
     *
     * @param position
     * @return
     */
    public Fragment getFragmet(int position) {
        if (fragments.size() > 0 && fragments != null) {
            return fragments.get(position);
        }
        return null;
    }

    /**
     * 添加fragment
     */
    private void initfragment() {
        fragments = new ArrayList<>();
        fragments.add(new ShopFragment());
        fragments.add(new MagazineFragment());
        fragments.add(new DaRenFragment());
        fragments.add(new ShareFragment());
        fragments.add(new PersonalFragment());
        fragments.add(new ShowDetialsFragment());
//         设置默认显示
        defultFragent(fragments.get(0));
    }

    /**
     * 设置默认显示
     *
     * @param fragment
     */
    private void defultFragent(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_framelayout, fragment);
        transaction.commit();
        temfragment = fragment;
    }

    public int getCurrentFragment() {
        for (int i = 0; i < fragments.size(); i++) {
            if (currentfragment == fragments.get(i)) {
                currentfragmentposition = i;
                return currentfragmentposition;
            }
        }
        return 0;
    }

//    /**
//     * 隐藏商品详情页面，显示上一个页面
//     */
//    public void hideShopGoods() {
//
//        SwitchFragment(lastfragment);
//    }
//
//    /**
//     * 显示商品详情页面
//     */
//    public void showShopGoods() {
//        SwitchFragment(fragments.get(5));
////        getGoodsInfoFromNet();
//    }


}
