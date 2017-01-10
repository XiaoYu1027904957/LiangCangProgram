package com.xiaoyu.liangcangprogram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 16/6/6.
 */
public class SimpleFragment extends Fragment {
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        list = new ArrayList<>();
//        list.add(new FenLeiFragment());
//        list.add(new PinPaiFragment());
//        list.add(new ShouYeFragment());
//        list.add(new ZhuanTiFragment());
//        list.add(new LiWuFragment());

        return new TextView(getActivity());
    }
}
