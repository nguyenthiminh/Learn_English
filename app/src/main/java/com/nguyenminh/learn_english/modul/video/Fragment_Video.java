package com.nguyenminh.learn_english.modul.video;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
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

import com.nguyenminh.learn_english.ISClick;
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

public class Fragment_Video extends Fragment implements ISClick{
    private List<ITemVideo> itvideos;
    private List<Videos> videos;
    private ListView lvvideo;
    private VidAdapter vidAdapter;
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        lvvideo = (ListView)view.findViewById(R.id.lv_grammar);
        v=(View)view.findViewById(R.id.v_tab);
        v.setVisibility(View.VISIBLE);
        Bundle bundle = getArguments();
        int id = bundle.getInt("ID");
        try {
            init(id);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }

    private void init(int idc) throws IOException{
        itvideos = new ArrayList<>();
        videos=new ArrayList<>();
        AssetManager assetManager = ((MainActivity)getActivity()).getAssets();
        InputStream input = assetManager.open("video_lessons_vi.xml");
        XmlToJson xmlToJson = new XmlToJson.Builder(input,null).build();

        input.close();
        JSONObject jsonObject = xmlToJson.toJson();
        if (jsonObject != null){
            try {
                JSONArray jsonArray = jsonObject.getJSONObject("root").getJSONArray("lesson");
                int ab = jsonArray.length();
                for (int i = 0; i < ab; i++) {
                    JSONObject o = (JSONObject) jsonArray.get(i);
                    int id = o.getInt("id");
                    JSONArray o1=o.getJSONArray("item");
                    if(id==idc){

                        for(int j=0;j<o1.length();j++){
                            JSONObject o11=(JSONObject)o1.get(j);
                            String localtext = o11.getString("local_text");
                            String entext = o11.getString("en_text");
                            String mp3 = o11.getString("mp3_normal");
                            String abc = o11.getString("mp3_slow");
                            itvideos.add(new ITemVideo(localtext,entext,mp3,abc));
                            videos.add(new Videos(id,itvideos));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        vidAdapter = new VidAdapter(itvideos,this);
        lvvideo.setAdapter(vidAdapter);

    }

    @Override
    public void isClick(int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(itvideos.get(position).getLink()));
        startActivity(browserIntent);
    }
}
