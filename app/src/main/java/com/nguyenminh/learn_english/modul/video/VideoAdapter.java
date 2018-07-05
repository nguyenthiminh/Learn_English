package com.nguyenminh.learn_english.modul.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.R;
import com.nguyenminh.learn_english.modul.phrase.Phrase;

import java.util.List;

/**
 * Created by Big Boss on 07/04/2018.
 */

public class VideoAdapter extends BaseAdapter {
    List<Video>videos;

    public VideoAdapter(List<Video> phrases) {
        this.videos = phrases;
    }

    @Override
    public int getCount() {
        if(videos==null) {
            return 0;
        }
        return videos.size();
    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
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

        Video video=videos.get(position);
        tvid.setText(video.getId()+"");
        tvlocaltitle.setText(video.getLocalTitle());
        tventitle.setText(video.getEnTitle());
        return view;
    }
}
