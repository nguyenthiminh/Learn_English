package com.nguyenminh.learn_english.alarmclock;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.nguyenminh.learn_english.MainActivity;
import com.nguyenminh.learn_english.R;

import java.util.Calendar;

/**
 * Created by Big Boss on 07/10/2018.
 */

public class TimeClock extends Dialog {
    private Activity c;
    private TimePicker timePicker;
    private Button btnStart,btnStop;
    private TextView tvHour;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;


    public TimeClock(Activity a) {
        super(a);
        this.c=a;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.timepicker);
        tvHour=(TextView)findViewById(R.id.tv_hour);

        btnStart=(Button)findViewById(R.id.btn_datgio);
        btnStop=(Button)findViewById(R.id.btn_dung);
        timePicker=(TimePicker)findViewById(R.id.timepicker);

        alarmManager=(AlarmManager)c.getSystemService(Context.ALARM_SERVICE);
        final Intent intent=new Intent(c,AlarmReceiver.class);

        calendar=Calendar.getInstance();



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());


                int gio=timePicker.getCurrentHour();
                int phut=timePicker.getCurrentMinute();


                String hour=String.valueOf(gio);
                String minu=String.valueOf(phut);

                if(gio>12){
                    hour=String.valueOf(gio-12);
                }
                if(phut<10){
                    minu="0"+String.valueOf(phut);
                }

                intent.putExtra("key","on");

                pendingIntent =PendingIntent.getBroadcast(c,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                tvHour.setText(hour+" : "+minu +(gio>12?" PM":" AM"));

            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHour.setText("Dừng");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("key","off");

                c.sendBroadcast(intent);
            }
        });

    }
}
