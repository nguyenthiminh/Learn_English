package com.nguyenminh.learn_english.modul.word;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.ISClick;
import com.nguyenminh.learn_english.R;
import com.nguyenminh.learn_english.modul.phrase.Phrase;

import java.util.List;

/**
 * Created by Big Boss on 07/04/2018.
 */

public class WordAdapter extends BaseAdapter {
    private ISClick isClick;
    private List<Word>words;

    public WordAdapter(List<Word> words,ISClick isClick) {
        this.words = words;
        this.isClick=isClick;
    }

    @Override
    public int getCount() {
        if(words==null) {
            return 0;
        }
        return words.size();
    }

    @Override
    public Object getItem(int position) {
        return words.get(position);
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

        Word word=words.get(position);
        tvid.setText(word.getId()+"");
        tvlocaltitle.setText(word.getLocalTitle());
        tventitle.setText(word.getEnTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClick.isClick(position);
            }
        });


        return view;
    }
}
