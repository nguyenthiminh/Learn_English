package com.nguyenminh.learn_english;

import android.content.res.AssetManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nguyenminh.learn_english.tab_main.Menu_Tab;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

public class MainActivity extends AppCompatActivity {
//    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            convertXMLTOJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        openMenu_Main();
    }
    public void openMenu_Main(){
        Menu_Tab music_tap=new Menu_Tab();
        FragmentManager m=getSupportFragmentManager();
        FragmentTransaction tr=m.beginTransaction();
        tr.replace(R.id.mainContent, music_tap,Menu_Tab.class.getName());
        tr.addToBackStack(null);
        tr.commit();
    }

//    public List<File> getFileAsset(){
//        List
//    }
    public void convertXMLTOJSON() throws IOException {
        AssetManager assetManager = getAssets();
        InputStream inputStream = assetManager.open("grammar.xml");
        XmlToJson xmlToJson = new XmlToJson.Builder(inputStream, null).build();
        inputStream.close();
        JSONObject jsonObject = xmlToJson.toJson();
        if(jsonObject!=null){
            Toast.makeText(this,"thành công",Toast.LENGTH_SHORT).show();
        }


//        database=FirebaseDatabase.getInstance();
//        DatabaseReference myRef =database.getReferenceFromUrl("https://nguyenminh-f2037.firebaseio.com/");
//
//        myRef.setValue(jsonObject);

    }
}
