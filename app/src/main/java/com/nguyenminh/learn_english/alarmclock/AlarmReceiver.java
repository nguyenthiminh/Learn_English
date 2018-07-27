package com.nguyenminh.learn_english.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Big Boss on 07/10/2018.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Tôi khong receiver ","hello");

        String data=intent.getExtras().getString("key");
        Log.e("Tôi khong receiver ",data);

        Intent myIntent=new Intent(context,Music.class);

        myIntent.putExtra("key",data);
        context.startService(myIntent);
    }
}
