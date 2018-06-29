package com.nguyenminh.learn_english.tab_main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.nguyenminh.learn_english.R;
import com.nguyenminh.learn_english.menu.Dialog_Item_Home;
import com.nguyenminh.learn_english.menu.Fragment_home;

/**
 * Created by Big Boss on 06/26/2018.
 */

public class Menu_Tab extends Fragment implements View.OnClickListener {
    private ImageView imvhome;
    private ViewPager vpEnglish;
    private TabLayout tab;
    private Main_Adapter main_adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.menu_main,container,false);
        initView(view);
        imvhome = (ImageView) view.findViewById(R.id.imv_home);
        imvhome.setOnClickListener(this);

        return view;


    }

    private void initView(View view) {
        vpEnglish=(ViewPager)view.findViewById(R.id.vp_english);
        main_adapter=new Main_Adapter(getChildFragmentManager());
        vpEnglish.setAdapter(main_adapter);
        tab=(TabLayout)view.findViewById(R.id.tab);
        tab.setupWithViewPager(vpEnglish);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imv_home:
                openFragmenthome();
                break;
                default:
                    break;
        }

    }

    private void openFragmenthome() {
        Fragment_home home=new Fragment_home();
        FragmentManager m=getChildFragmentManager();
        FragmentTransaction tr=m.beginTransaction();
        tr.replace(R.id.menu, home,Fragment_home.class.getName());
        tr.addToBackStack(null);
        tr.commit();
    }


}
