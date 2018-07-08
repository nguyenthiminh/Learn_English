package com.nguyenminh.learn_english.modul.phrase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.R;
import com.nguyenminh.learn_english.modul.word.ItemWord;

import java.util.List;

/**
 * Created by Big Boss on 07/08/2018.
 */

public class ItemPhraseAdapter extends BaseAdapter{
    private List<ItemPhrase>itemPhrases;

    public ItemPhraseAdapter(List<ItemPhrase> itemPhrases) {
        this.itemPhrases = itemPhrases;
    }

    @Override
    public int getCount() {
        if(itemPhrases==null) {
            return 0;
        }
        else
            return itemPhrases.size();
    }

    @Override
    public Object getItem(int position) {
        return itemPhrases.get(position);
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

        ItemPhrase itemPhrase=itemPhrases.get(position);
        tvid.setText(itemPhrase.getStt()+"");
        tvlocaltitle.setText(itemPhrase.getEn_text());
        tventitle.setText(itemPhrase.getLocal_text());
        return view;
    }
}
