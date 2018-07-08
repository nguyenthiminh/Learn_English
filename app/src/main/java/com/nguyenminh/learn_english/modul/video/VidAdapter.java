package com.nguyenminh.learn_english.modul.video;

import android.graphics.Color;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.ISClick;
import com.nguyenminh.learn_english.R;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by hieph on 7/8/2018.
 */

public class VidAdapter extends BaseAdapter {
    private List<ITemVideo> itvideos;;
    private ISClick intern;

    public VidAdapter(List<ITemVideo> itvideos,ISClick intern) {
        this.itvideos = itvideos;
        this.intern = intern;

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
        tvid.setTextSize(14);
        tvlocaltitle.setText(ivideo.getText());
        tvlocaltitle.setTextSize(14);
        tventitle.setText(ivideo.getLink());
        tventitle.setTextColor(Color.BLUE);
        tventitle.setTextSize(12);
        tventitle.setInputType(InputType.TYPE_TEXT_VARIATION_FILTER);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intern.isClick(position);
            }
        });
        return view;
    }
}

