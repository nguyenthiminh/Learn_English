package com.nguyenminh.learn_english.modul.phrase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.ISClick;
import com.nguyenminh.learn_english.R;

import java.util.List;

/**
 * Created by Big Boss on 07/04/2018.
 */

public class PhraseAdapter extends BaseAdapter {
    private List<Phrase>phrases;
    private ISClick isClick;

    public PhraseAdapter(List<Phrase> phrases,ISClick isClick) {
        this.phrases = phrases;
        this.isClick=isClick;
    }

    @Override
    public int getCount() {
        if(phrases==null) {
            return 0;
        }
        return phrases.size();
    }

    @Override
    public Object getItem(int position) {
        return phrases.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
            view=inflater.inflate(R.layout.item_one,viewGroup,false);
        }

        TextView tvid=(TextView)view.findViewById(R.id.tv_id);
        TextView tvlocaltitle=(TextView)view.findViewById(R.id.tv_loacaltitle);
        TextView tventitle=(TextView)view.findViewById(R.id.tv_entitle);

        Phrase phrase=phrases.get(position);
        tvid.setText(phrase.getId()+"");
        tvlocaltitle.setText(phrase.getLocalTitle());
        tventitle.setText(phrase.getEnTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClick.isClick(position);
            }
        });
        return view;
    }
}
