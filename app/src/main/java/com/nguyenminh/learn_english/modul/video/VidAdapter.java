package com.nguyenminh.learn_english.modul.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.ISClick;
import com.nguyenminh.learn_english.R;

import java.util.List;

/**
 * Created by hieph on 7/8/2018.
 */

public class VidAdapter extends BaseAdapter {
    private List<ITemVideo> itvideos;;

    public VidAdapter(List<ITemVideo> itvideos) {
        this.itvideos = itvideos;

    }

    @Override
    public int getCount() {
        if (itvideos == null) {
            return 0;
        }
        return itvideos.size();
    }

    @Override
    public Object getItem(int position) {
        return itvideos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.item_video, viewGroup, false);
        }

        TextView tvid = (TextView) view.findViewById(R.id.tv_video);
        TextView tvlocaltitle = (TextView) view.findViewById(R.id.tv_TA);
        TextView tventitle = (TextView) view.findViewById(R.id.tv_TV);

        ITemVideo ivideo = itvideos.get(position);
        tvid.setText(ivideo.getItem() + "");
        tvlocaltitle.setText(ivideo.getText());
        tventitle.setText(ivideo.getContent());
        

        return view;
    }
}

