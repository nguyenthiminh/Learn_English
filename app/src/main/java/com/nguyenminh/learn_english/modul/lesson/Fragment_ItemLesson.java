package com.nguyenminh.learn_english.modul.lesson;

import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.nguyenminh.learn_english.MainActivity;
import com.nguyenminh.learn_english.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

/**
 * Created by Big Boss on 07/06/2018.
 */

public class Fragment_ItemLesson extends Fragment {
    private LinearLayout ln;
    private ItemLessonAdapter adapter;
    private List<ItemLesson> itemLessons;
    private List<ItemLessons> lessonss;
    private View vTab;
    private ListView lv;
    private ImageView imvPlay;
    private MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        ln = (LinearLayout) view.findViewById(R.id.ln_playmp3);
        lv = (ListView) view.findViewById(R.id.lv_grammar);
        ln.setVisibility(View.VISIBLE);
        vTab=(View)view.findViewById(R.id.v_tab);
        vTab.setVisibility(View.VISIBLE);
        imvPlay=(ImageView)view.findViewById(R.id.imv_play);


        Bundle bundle = getArguments();
        int id = bundle.getInt("ID");
        try {
            init(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    private void init(int idc) throws IOException {
        itemLessons = new ArrayList<>();
        lessonss = new ArrayList<>();
        AssetManager assetManager = ((MainActivity) getActivity()).getAssets();
        InputStream inputStream = assetManager.open("lesson.xml");
        XmlToJson xmlToJson = new XmlToJson.Builder(inputStream, null).build();

        inputStream.close();
        JSONObject jsonObject = xmlToJson.toJson();
        if (jsonObject != null) {

            ItemLesson itemLesson;
            ItemLessons lessons;
            try {

                JSONArray jsonArray = jsonObject.getJSONObject("root").getJSONArray("lesson");
                int le = jsonArray.length();
                for (int i = 0; i < le; i++) {
                    JSONObject o = (JSONObject) jsonArray.get(i);
                    int id = o.getInt("id");
                    if(id==idc){
                        JSONArray o1=o.getJSONArray("item");
                        for(int j=0;j<o1.length();j++){
                            JSONObject o11=(JSONObject)o1.get(j);
                            String person = o11.getString("person");
                            String enText = o11.getString("en_text");
                            String localText = o11.getString("local_text");
                            String mp3Normal = o11.getString("mp3_normal");
                            String mp3Slow = o11.getString("mp3_slow");
                            itemLesson = new ItemLesson(j+1, person, enText, localText, mp3Normal, mp3Slow);
                            itemLessons.add(itemLesson);
                            lessons = new ItemLessons(id, itemLessons);
                            lessonss.add(lessons);

                            // Id của file mp3.
                            int mp3Id =getRawResIdByName("lesson_"+id);

                            // Tạo đối tượng MediaPlayer.
//                            mediaPlayer=   MediaPlayer.create(getContext(), mp3Id);
//                            imvPlay.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//
//                                    imvPlay.setImageResource(R.drawable.ic_music_pause);
//                                    doPlay();
//                                }
//                            });

                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            adapter = new ItemLessonAdapter(itemLessons);
            lv.setAdapter(adapter);

        }
    }

    public int getRawResIdByName(String resName)  {
        String pkgName =getContext().getPackageName();
        // Return 0 if not found.
        // Trả về 0 nếu không tìm thấy.
        int resID =getResources().getIdentifier(resName, "raw", pkgName);
        return resID;
    }

    public void doPlay(){
        mediaPlayer.start();
    }

}
