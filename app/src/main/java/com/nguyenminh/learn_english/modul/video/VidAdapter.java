package com.nguyenminh.learn_english.modul.video;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguyenminh.learn_english.ISClick;
import com.nguyenminh.learn_english.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by hieph on 7/8/2018.
 */

public class VidAdapter extends BaseAdapter{
    private Context context;
    private List<ITemVideo> itvideos;
    private String link = "";
    private ISClick intern;
    private String url="";


    public VidAdapter(List<ITemVideo> itvideos, ISClick intern,Context context) {
        this.itvideos = itvideos;
        this.intern = intern;
        this.context=context;

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
        //TextView tventitle = (TextView) view.findViewById(R.id.tv_TV);
        ImageView imvImage = (ImageView) view.findViewById(R.id.imv_loadanh);



        ITemVideo ivideo = itvideos.get(position);
        tvid.setText(ivideo.getItem() + "");
        tvid.setTextSize(14);
        tvlocaltitle.setText(ivideo.getText());
        tvlocaltitle.setTextSize(14);
        link = ivideo.getLink();
        String url = "http://img.youtube.com/vi/" + ivideo.getLink().substring(31, 42) + "/0.jpg";
        Log.d("abc",url);
        Picasso.with(context).load(url).placeholder(R.drawable.abab).into(imvImage);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intern.isClick(position);
            }
        });
        return view;
    }
}