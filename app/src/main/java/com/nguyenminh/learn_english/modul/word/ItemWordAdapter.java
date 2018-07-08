package com.nguyenminh.learn_english.modul.word;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.R;
import com.nguyenminh.learn_english.modul.lesson.ItemLesson;

import java.util.List;

/**
 * Created by Big Boss on 07/08/2018.
 */

public class ItemWordAdapter extends BaseAdapter {
    public ItemWordAdapter(List<ItemWord> itemWords) {
        this.itemWords = itemWords;
    }

    private List<ItemWord> itemWords;
    @Override
    public int getCount() {
        if(itemWords==null) {
            return 0;
        }

        return itemWords.size();
    }

    @Override
    public Object getItem(int position) {
        return itemWords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
            view=inflater.inflate(R.layout.item_one,viewGroup,false);

        }


        TextView tvid=(TextView)view.findViewById(R.id.tv_id);
        TextView tvlocaltitle=(TextView)view.findViewById(R.id.tv_loacaltitle);
        TextView tventitle=(TextView)view.findViewById(R.id.tv_entitle);

        ItemWord itemword=itemWords.get(position);
        tvid.setText(itemword.getStt()+"");
        tvlocaltitle.setText(itemword.getEn_text());
        tventitle.setText(itemword.getLocal_text());
        return view;
    }
}
