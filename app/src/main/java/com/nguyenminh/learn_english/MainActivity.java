package com.nguyenminh.learn_english;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.firebase.database.FirebaseDatabase;
import com.nguyenminh.learn_english.tab_main.Menu_Tab;

import java.io.IOException;

//import fr.arnaudguyon.xmltojsonlib.XmlToJson;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBar actionBar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);

        drawerToggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        try {
            convertXMLTOJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        openMenu_Main();
    }

    public void openMenu_Main() {
        Menu_Tab music_tap = new Menu_Tab();
        FragmentManager m = getSupportFragmentManager();
        FragmentTransaction tr = m.beginTransaction();
        tr.replace(R.id.mainContent, music_tap, Menu_Tab.class.getName());
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account:


                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.download:


                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.setting:


                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.favourite:


                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.share:


                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            default:
                break;
        }
        return true;
    }
}
