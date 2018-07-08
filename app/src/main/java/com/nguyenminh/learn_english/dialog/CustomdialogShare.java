package com.nguyenminh.learn_english.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguyenminh.learn_english.R;

/**
 * Created by hieph on 7/6/2018.
 */

public class CustomdialogShare extends Dialog implements View.OnClickListener{


    public Activity c;
    public Dialog d;
    public Button btnjusceone, btnallways;
    public TextView tvfb,tvmessaging;
    public ImageView imvFb,imvmess;


    public CustomdialogShare(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_share);
        imvFb = (ImageView)findViewById(R.id.imv_bluetooth);
        imvmess = (ImageView)findViewById(R.id.imv_messenger);
        tvfb = (TextView)findViewById(R.id.tv_bltooth);
        tvmessaging=(TextView)findViewById(R.id.tv_messaging);
        btnjusceone = (Button) findViewById(R.id.btn_ok);
        btnallways = (Button) findViewById(R.id.btn_allways);
        tvfb.setOnClickListener(this);
        tvmessaging.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_bltooth :
                btnjusceone.setEnabled(true);
                btnallways.setEnabled(true);
                if (btnjusceone.isEnabled() && btnallways.isEnabled()) {
                    btnjusceone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                            c.startActivity(browserIntent);
                        }
                    });
                    btnallways.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                            c.startActivity(browserIntent);
                        }
                    });

                }
                break;
            case R.id.tv_messaging :
                btnjusceone.setEnabled(true);
                btnallways.setEnabled(true);

                break;
            default:
                break;
        }
    }
}

