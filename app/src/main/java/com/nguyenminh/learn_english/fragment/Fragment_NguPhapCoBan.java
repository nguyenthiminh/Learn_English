package com.nguyenminh.learn_english.fragment;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nguyenminh.learn_english.ISClick;
import com.nguyenminh.learn_english.MainActivity;
import com.nguyenminh.learn_english.R;
import com.nguyenminh.learn_english.modul.grammar.Grammar;
import com.nguyenminh.learn_english.modul.grammar.GrammarAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

/**
 * Created by Big Boss on 06/26/2018.
 */

public class Fragment_NguPhapCoBan extends Fragment implements ISClick {
    private List<Grammar> grammars;
    private GrammarAdapter adapter;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        try {
            init(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    public void init(View view) throws IOException {
        grammars=new ArrayList<>();
        AssetManager assetManager = ((MainActivity)getActivity()).getAssets();
        InputStream inputStream = assetManager.open("grammar_titles.xml");
        XmlToJson xmlToJson = new XmlToJson.Builder(inputStream, null).build();

        inputStream.close();
        JSONObject jsonObject = xmlToJson.toJson();
        if (jsonObject != null) {

            Grammar gram;
            try {

                JSONArray jsonArray = jsonObject.getJSONObject("grammars").getJSONArray("grammar");
                int le = jsonArray.length();
                for (int i = 0; i < le; i++) {
                    JSONObject o = (JSONObject) jsonArray.get(i);
                    String localtitle = o.getString("local_title");
                    int id = o.getInt("id");
                    String entitle = o.getString("en_title");
//                        tvText.setText(Html.fromHtml(
//                                title));
                    gram = new Grammar(id, localtitle, entitle);

                    grammars.add(gram);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


            lv = (ListView) view.findViewById(R.id.lv_grammar);
            adapter = new GrammarAdapter(grammars,this);
            lv.setAdapter(adapter);

        }
    }

    @Override
    public void isClick(int position) {
        ((MainActivity)getActivity()).openItemGrammar(grammars.get(position).getId(),grammars.get(position).getLocalTitle());
    }
}
