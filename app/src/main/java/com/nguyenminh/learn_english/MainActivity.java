package com.nguyenminh.learn_english;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.nguyenminh.learn_english.menu.Dialog_Item_Home;
import com.nguyenminh.learn_english.tab_main.Menu_Tab;

import java.io.IOException;

//import fr.arnaudguyon.xmltojsonlib.XmlToJson;

public class MainActivity extends AppCompatActivity {
//    FirebaseDatabase database;

    private FrameLayout home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home=(FrameLayout)findViewById(R.id.fragment_home);
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
//        AssetManager assetManager = getAssets();
//        InputStream inputStream = assetManager.open("grammar.xml");
//        XmlToJson xmlToJson = new XmlToJson.Builder(inputStream, null).build();
//        inputStream.close();
//        JSONObject jsonObject = xmlToJson.toJson();
//        if(jsonObject!=null){
//            Toast.makeText(this,"thành công",Toast.LENGTH_SHORT).show();
//        }
//
//
//        database=FirebaseDatabase.getInstance();
//        DatabaseReference myRef =database.getReferenceFromUrl("https://nguyenminh-f2037.firebaseio.com/");
//
//        myRef.setValue(jsonObject);

    }
    public void openItem_Home(String name) {


        new Dialog_Item_Home(this,name).show();


    }


}
