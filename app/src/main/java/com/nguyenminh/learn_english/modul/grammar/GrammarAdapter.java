package com.nguyenminh.learn_english.modul.grammar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.R;

import java.util.List;

/**
 * Created by Big Boss on 07/04/2018.
 */

public class GrammarAdapter extends BaseAdapter {

    public GrammarAdapter(List<Grammar> grammars) {
        this.grammars = grammars;
    }

    List<Grammar>grammars;
    @Override
    public int getCount() {
        if(grammars==null) {
            return 0;
        }
        return grammars.size();
    }

    @Override
    public Object getItem(int position) {
        return grammars.get(position);
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

        Grammar grammar=grammars.get(position);
        tvid.setText(grammar.getId()+"");
        tvlocaltitle.setText(grammar.getLocalTitle());
        tventitle.setText(grammar.getEnTitle());
        return view;
    }
}
