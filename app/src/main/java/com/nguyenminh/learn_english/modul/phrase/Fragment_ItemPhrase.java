package com.nguyenminh.learn_english.modul.phrase;

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
import com.nguyenminh.learn_english.modul.lesson.ItemLesson;
import com.nguyenminh.learn_english.modul.lesson.ItemLessonAdapter;
import com.nguyenminh.learn_english.modul.lesson.ItemLessons;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

/**
 * Created by Big Boss on 07/08/2018.
 */

public class Fragment_ItemPhrase extends Fragment {
    private LinearLayout ln;
    private ItemPhraseAdapter adapter;
    private List<ItemPhrase> itemPhrases;
    private List<ItemPhrases> phrasess;
    private View vTab;
    private ListView lv;
    private ImageView imvPlay;
    private MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        lv = (ListView) view.findViewById(R.id.lv_grammar);
        vTab = (View) view.findViewById(R.id.v_tab);
        vTab.setVisibility(View.VISIBLE);
        ln = (LinearLayout) view.findViewById(R.id.ln_playmp3);
        ln.setVisibility(View.VISIBLE);
        imvPlay = (ImageView) view.findViewById(R.id.imv_play);

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
        itemPhrases = new ArrayList<>();
        phrasess = new ArrayList<>();
        AssetManager assetManager = ((MainActivity) getActivity()).getAssets();
        InputStream inputStream = assetManager.open("phrases.xml");
        XmlToJson xmlToJson = new XmlToJson.Builder(inputStream, null).build();

        inputStream.close();
        JSONObject jsonObject = xmlToJson.toJson();
        if (jsonObject != null) {

            ItemPhrase itemPhrase;
            ItemPhrases phrases;
            try {

                JSONArray jsonArray = jsonObject.getJSONObject("root").getJSONArray("phrases");
                int le = jsonArray.length();
                for (int i = 0; i < le; i++) {
                    JSONObject o = (JSONObject) jsonArray.get(i);
                    int id = o.getInt("id");
                    if (id == idc) {
                        JSONArray o1 = o.getJSONArray("item");
                        for (int j = 0; j < o1.length(); j++) {
                            JSONObject o11 = (JSONObject) o1.get(j);
                            String enText = o11.getString("en_text");
                            String localText = o11.getString("local_text");
                            String mp3Normal = o11.getString("mp3_normal");
                            String mp3Slow = o11.getString("mp3_slow");
                            itemPhrase = new ItemPhrase(j + 1, enText, localText, mp3Normal, mp3Slow);
                            itemPhrases.add(itemPhrase);
                            phrases = new ItemPhrases(id, itemPhrases);
                            phrasess.add(phrases);



                        }
                    }
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


//                 Id của file mp3.

//                 Tạo đối tượng MediaPlayer.


                imvPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i = 0; i < itemPhrases.size(); i++) {
                            int mp3Id = getRawResIdByName(itemPhrases.get(i).getMp3_normal() + "");
                            imvPlay.setImageResource(R.drawable.ic_music_pause);
                            mediaPlayer = MediaPlayer.create(getContext(), mp3Id);

                            if (mediaPlayer.isPlaying()) {
                                imvPlay.setImageResource(R.drawable.ic_music_play);
                                pauseMusic();
                            } else {
                                imvPlay.setImageResource(R.drawable.ic_music_pause);
                                startMusic();
                            }
                        }
                    }
                });
            adapter = new ItemPhraseAdapter(itemPhrases);
            lv.setAdapter(adapter);

        }
    }

    public int getRawResIdByName(String resName) {
        String pkgName = getContext().getPackageName();
        // Return 0 if not found.
        // Trả về 0 nếu không tìm thấy.
        int resID = getResources().getIdentifier(resName, "raw", pkgName);
        return resID;
    }


    private void stopMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = new MediaPlayer();
        }
    }

    /**
     * Hàm bắt đầu chơi nhạc lại
     */
    private void startMusic() {
        mediaPlayer.start();

    }

    /**
     * Hàm tạm dừng chơi nhạc
     */
    private void pauseMusic() {
        mediaPlayer.pause();
    }

}
