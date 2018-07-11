package com.nguyenminh.learn_english.modul.grammar;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
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
 * Created by Big Boss on 07/06/2018.
 */

public class Fragment_ItemGrammar extends Fragment {
    private List<ItemGrammar>itemGrammars;
    private TextView tvItemGrammar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.grammar,container,false);
        tvItemGrammar=(TextView)view.findViewById(R.id.tv_itemgrammar);
        Bundle bundle =getArguments();
        int id=bundle.getInt("ID");
        String title=bundle.getString("TITLE");
        try {
            init(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
        
    }

    private void init(int idc) throws IOException {
        itemGrammars=new ArrayList<>();
        AssetManager assetManager = ((MainActivity)getActivity()).getAssets();
        InputStream inputStream = assetManager.open("grammar.xml");
        XmlToJson xmlToJson = new XmlToJson.Builder(inputStream, null).build();

        inputStream.close();
        JSONObject jsonObject = xmlToJson.toJson();
        if (jsonObject != null) {

            ItemGrammar itemGram;
            try {

                JSONArray jsonArray = jsonObject.getJSONObject("grammars").getJSONArray("grammar");
                int le = jsonArray.length();
                for (int i = 0; i < le; i++) {
                    JSONObject o = (JSONObject) jsonArray.get(i);
                    String title = o.getString("title");
                    int id = o.getInt("id");
                    String content = o.getString("content");
//                        tvText.setText(Html.fromHtml(
//                                title));
                    itemGram = new ItemGrammar(id, title, content);

                    itemGrammars.add(itemGram);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i=0;i<itemGrammars.size();i++){
                if(idc==itemGrammars.get(i).getId()){
                    tvItemGrammar.setText(Html.fromHtml(itemGrammars.get(i).getContent()));

                    tvItemGrammar.setVerticalScrollBarEnabled(true);
                    tvItemGrammar.setMovementMethod(new ScrollingMovementMethod());
                }
        }
    }
    }
}
