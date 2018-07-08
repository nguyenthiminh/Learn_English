package com.nguyenminh.learn_english.modul.video;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

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
 * Created by hieph on 7/7/2018.
 */

public class Fragment_Video extends Fragment {
    private List<ITemVideo> itvideos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video,container,false);

        Bundle bundle = getArguments();
        String item = bundle.getString("ITEM");
        try {
            init(item);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }

    private void init(String idc) throws IOException{
        itvideos = new ArrayList<>();
        AssetManager assetManager = ((MainActivity)getActivity()).getAssets();
        InputStream input = assetManager.open("video_lessons_vi.xml");
        XmlToJson xmlToJson = new XmlToJson.Builder(input,null).build();

        input.close();
        JSONObject jsonObject = xmlToJson.toJson();

        if (jsonObject == null){
            try {
                JSONArray jsonArray = jsonObject.getJSONObject("root").getJSONArray("lesson");
                int ab = jsonArray.length();
                for (int i = 0; i < ab;i++){

                    JSONObject o = (JSONObject) jsonArray.get(i);
                    String item = o.getString("item");
                    String vd = o.getString("local_text");
                    String tieude=o.getString("en_text");
                    String mp3 = o.getString("mp3_slow");
                    itvideos.add(new ITemVideo(item,mp3,tieude,vd));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }
}
