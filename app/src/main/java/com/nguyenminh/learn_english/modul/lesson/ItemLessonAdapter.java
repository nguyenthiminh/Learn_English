package com.nguyenminh.learn_english.modul.lesson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenminh.learn_english.R;

import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Big Boss on 07/06/2018.
 */

public class ItemLessonAdapter extends BaseAdapter {
    private List<ItemLesson>itemLessons;
    public ItemLessonAdapter(List<ItemLesson> itemLessons) {
        this.itemLessons = itemLessons;
    }




    @Override
    public int getCount() {
        if(itemLessons==null) {
            return 0;
        }
        return itemLessons.size();
    }

    @Override
    public Object getItem(int position) {
        return itemLessons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
            view=inflater.inflate(R.layout.item_lesson,viewGroup,false);
        }
        TextView tvid=(TextView)view.findViewById(R.id.tv_id);
        TextView tvperson=(TextView)view.findViewById(R.id.tv_name);
        TextView tventext=(TextView)view.findViewById(R.id.tv_entext);
        TextView tvlocaltext=(TextView)view.findViewById(R.id.tv_localtext);

        ItemLesson itemLesson=itemLessons.get(position);
        tvid.setText(itemLesson.getStt()+"");
        tvperson.setText(itemLesson.getPerson());
        tventext.setText(itemLesson.getEn_text());
        tvlocaltext.setText(itemLesson.getLocal_text());



        return view;
    }
}
