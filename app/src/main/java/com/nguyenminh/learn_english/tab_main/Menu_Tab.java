package com.nguyenminh.learn_english.tab_main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nguyenminh.learn_english.R;

/**
 * Created by Big Boss on 06/26/2018.
 */

public class Menu_Tab extends Fragment {
    private ViewPager vpEnglish;
    private TabLayout tab;
    private Main_Adapter main_adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.menu_main,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        vpEnglish=(ViewPager)view.findViewById(R.id.vp_english);
        main_adapter=new Main_Adapter(getChildFragmentManager());
        vpEnglish.setAdapter(main_adapter);
        tab=(TabLayout)view.findViewById(R.id.tab);
        tab.setupWithViewPager(vpEnglish);
    }
}
