package com.nguyenminh.learn_english.modul.lesson;

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

public class LessonAdapter extends BaseAdapter {


    public LessonAdapter(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    List<Lesson>lessons;
    @Override
    public int getCount() {
        if(lessons==null) {
            return 0;
        }
        return lessons.size();
    }

    @Override
    public Object getItem(int position) {
        return lessons.get(position);
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

        Lesson lesson=lessons.get(position);
        tvid.setText(lesson.getId()+"");
        tvlocaltitle.setText(lesson.getLocalTitle());
        tventitle.setText(lesson.getEnTitle());
        return view;
    }
}
