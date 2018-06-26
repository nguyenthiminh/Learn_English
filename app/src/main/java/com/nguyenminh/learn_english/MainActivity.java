package com.nguyenminh.learn_english;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nguyenminh.learn_english.tab_main.Menu_Tab;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
