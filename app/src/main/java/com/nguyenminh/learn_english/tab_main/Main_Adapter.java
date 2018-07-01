package com.nguyenminh.learn_english.tab_main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nguyenminh.learn_english.fragment.Fragment_BaiHoc;
import com.nguyenminh.learn_english.fragment.Fragment_CumTu;
import com.nguyenminh.learn_english.fragment.Fragment_NguPhapCoBan;
import com.nguyenminh.learn_english.fragment.Fragment_ThanhNgu;
import com.nguyenminh.learn_english.fragment.Fragment_TuCoBan;
import com.nguyenminh.learn_english.fragment.Fragment_Video;

/**
 * Created by Big Boss on 06/26/2018.
 */

public class Main_Adapter extends FragmentPagerAdapter {

    public Main_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Fragment_BaiHoc();
        } else if (position == 1) {
            return new Fragment_Video();
        } else  if (position == 2) {
            return new Fragment_CumTu();
        } else if (position == 3) {
            return new Fragment_TuCoBan();
        } else if (position == 4) {
            return new Fragment_NguPhapCoBan();
        } else return new Fragment_ThanhNgu();

    }


    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "100 Bài Học";

            case 1:
                return "Học Qua Video";

            case 2:
                return "Cụm Từ";

            case 3:
                return "Từ Cơ Bản";

            case 4:
                return "Ngữ Pháp Cơ Bản";

            case 5:
                return "Thành Ngữ Hay";

            default:
                return null;

        }

    }
}
