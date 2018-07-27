package com.nguyenminh.learn_english;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.nguyenminh.learn_english.dialog.CustomdialogShare;
import com.nguyenminh.learn_english.alarmclock.TimeClock;
import com.nguyenminh.learn_english.modul.grammar.Fragment_ItemGrammar;

import com.nguyenminh.learn_english.modul.grammar.Grammar;

import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.nguyenminh.learn_english.modul.video.Fragment_Video;

import com.nguyenminh.learn_english.modul.lesson.Fragment_ItemLesson;
import com.nguyenminh.learn_english.modul.phrase.Fragment_ItemPhrase;
import com.nguyenminh.learn_english.modul.word.Fragment_ItemWord;
import com.nguyenminh.learn_english.tab_main.Menu_Tab;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private int i=0;
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
                if (i == 0) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                if (i == 1) {
                    onBackPressed();
                    i = 0;
                    actionBar.setTitle("LearnEnglish");
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    Drawable drawable = getResources().getDrawable(R.drawable.ic_menu);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setHomeAsUpIndicator(drawable);

                }

            }
        });
        openMenu_Main();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clock:
                TimeClock timeClock=new TimeClock(MainActivity.this);
                timeClock.show();
                break;
            case R.id.like:

                break;
            case R.id.store:

                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }






    public void openMenu_Main() {
        Menu_Tab music_tap = new Menu_Tab();
        FragmentManager m = getSupportFragmentManager();
        FragmentTransaction tr = m.beginTransaction();
        tr.replace(R.id.mainContent, music_tap, Menu_Tab.class.getName());
        tr.addToBackStack(null);
        tr.commit();
    }

    public List convertXMLTOJSON(String link) throws IOException {
        AssetManager assetManager = getAssets();
        InputStream inputStream = assetManager.open(link + ".xml");
        XmlToJson xmlToJson = new XmlToJson.Builder(inputStream, null).build();

        inputStream.close();
        JSONObject jsonObject = xmlToJson.toJson();
        if (jsonObject != null) {
            switch (link) {
                case "grammar_title":
                    List<Grammar> data = new ArrayList<>();
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

                            data.add(gram);

                        }

                        return data;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
                case "grammar":
                    break;
                default:
                    break;

            }
        }
        return null;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account:


                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.download:
                Intent ggplay = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store"));
                startActivity(ggplay);

                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.setting:
                showAlterdialogSetting();

                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.favourite:
                Intent fovourite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store"));
                startActivity(fovourite);

                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.share:
                showDialogShare();

                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            default:
                break;
        }
        return true;
    }


    public void openItemGrammar(int id, String localTitle) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment_ItemGrammar fragment = new Fragment_ItemGrammar();
        Bundle bundle = new Bundle();
        bundle.putInt("ID", id);
        bundle.putString("TITLE", localTitle);
        fragment.setArguments(bundle);
        transaction.replace(R.id.mainContent, fragment,
                Fragment_ItemGrammar.class.getName());
        transaction.addToBackStack(null);
        actionBar.setTitle(Fragment_ItemGrammar.class.getName() + "");
        actionBar.setTitle(id + "." + localTitle + "");
        backMenu();
        transaction.commit();

    }

    public void backMenu() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        i = i + 1;
    }

    private void showAlterdialogSetting() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("abcdef");
        builder.setMessage("ban co muon...");
        builder.setCancelable(false);
        builder.setPositiveButton("hihi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("ahihi minh meo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void showDialogShare() {
        CustomdialogShare cdd = new CustomdialogShare(MainActivity.this);
        cdd.show();
    }

    public void openVideo(int id,String localTitle) {
        Fragment_Video fragment = new Fragment_Video();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("LOCALTITLE",localTitle);
        bundle.putInt("ID", id);
        fragment.setArguments(bundle);
        transaction.replace(R.id.mainContent, fragment, Fragment_Video.class.getName());
        transaction.addToBackStack(null);
        actionBar.setTitle(id + "." + localTitle + "");
        backMenu();
        transaction.commit();
    }

    public void openItemLesson(int id, String localTitle) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment_ItemLesson fragment = new Fragment_ItemLesson();
        Bundle bundle = new Bundle();
        bundle.putInt("ID", id);
        bundle.putString("LOCALTITLE",localTitle);
        fragment.setArguments(bundle);
        transaction.replace(R.id.mainContent, fragment,
                Fragment_ItemLesson.class.getName());
        transaction.addToBackStack(null);
        actionBar.setTitle(id + "." + localTitle + "");
        backMenu();
        transaction.commit();
    }

    public void openItemWord(int id, String localTitle) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment_ItemWord fragment = new Fragment_ItemWord();
        Bundle bundle = new Bundle();
        bundle.putInt("ID", id);
        bundle.putString("LOCALTITLE",localTitle);
        fragment.setArguments(bundle);
        transaction.replace(R.id.mainContent, fragment,
                Fragment_ItemWord.class.getName());
        transaction.addToBackStack(null);
        actionBar.setTitle(id + "." + localTitle + "");
        backMenu();

        transaction.commit();
    }

    public void openItemPhrase(int id, String localTitle) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment_ItemPhrase fragment = new Fragment_ItemPhrase();
        Bundle bundle = new Bundle();
        bundle.putInt("ID", id);
        bundle.putString("LOCALTITLE",localTitle);
        fragment.setArguments(bundle);
        transaction.replace(R.id.mainContent, fragment,
                Fragment_ItemPhrase.class.getName());
        transaction.addToBackStack(null);
        actionBar.setTitle(id + "." + localTitle + "");
        backMenu();

        transaction.commit();
    }

}
