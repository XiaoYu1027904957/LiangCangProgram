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
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initfragment();
        setOnCheckedListener();
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
                Fragment currentfragment = getFragmet(position);
                SwitchFragment(currentfragment);
            }
        });
        mainRg.check(R.id.main_shopping);
    }

    private void SwitchFragment(Fragment currentfragment) {
        if (temfragment != currentfragment) {
            if (currentfragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
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
    private Fragment getFragmet(int position) {
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
}
