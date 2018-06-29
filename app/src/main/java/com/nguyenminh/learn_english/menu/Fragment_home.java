package com.nguyenminh.learn_english.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nguyenminh.learn_english.MainActivity;
import com.nguyenminh.learn_english.R;
import com.nguyenminh.learn_english.tab_main.Menu_Tab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hieph on 6/26/2018.
 */

public class Fragment_home extends Fragment implements ItemAdapter.IMenu {
    private List<ItemHome> item;
    private ItemAdapter adapter;
    private ListView listView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }

    public void init(View view) {
        item = new ArrayList<>();
        item.add(new ItemHome(R.drawable.ic_account_circle_black_24dp, "account"));
        item.add(new ItemHome(R.drawable.ic_file_download_black_24dp, "download"));
        item.add(new ItemHome(R.drawable.ic_settings_black_24dp, "setting"));
        item.add(new ItemHome(R.drawable.ic_favorite_black_24dp, "favourite"));
        item.add(new ItemHome(R.drawable.ic_info_black_24dp, "share"));

        listView = (ListView) view.findViewById(R.id.lv_home);
        adapter = new ItemAdapter(item, this);
        listView.setAdapter(adapter);



    }

    @Override
    public void open(int position) {
        hintFragment();
        ((MainActivity)getContext()).openItem_Home(item.get(position).getName());
    }
    public void hintFragment(){
        FragmentTransaction ft = getFragmentManager ().beginTransaction ();
        ft.hide (this);
        ft.commit ();
    }


}
