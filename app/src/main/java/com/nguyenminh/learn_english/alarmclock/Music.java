package com.nguyenminh.learn_english.alarmclock;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.nguyenminh.learn_english.MainActivity;
import com.nguyenminh.learn_english.R;

/**
 * Created by Big Boss on 07/11/2018.
 */

public class Music extends Service {
    private MediaPlayer mediaPlayer;
    private int id;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Tôi trong servise", "hello");

        String dataKey = intent.getExtras().getString("key");
        Log.e("Tôi trong servise", dataKey);

        if (dataKey.equals("on")) {
            id = 1;

        } else if (dataKey.equals("off")) {
            id = 0;
        }
        if (id == 1) {
            mediaPlayer = MediaPlayer.create(this, R.raw.abc_song);
            mediaPlayer.start();
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.ic_alarm_clock)
                            .setContentTitle("Báo Thức")
                            .setContentText("Học tiếng anh giao tiếp!");

            // Creates an explicit intent for an Activity in your app
            Intent resultIntent = new Intent(this, MainActivity.class);

            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(MainActivity.class);

            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mBuilder.setAutoCancel(true);
            mBuilder.build().flags |= Notification.FLAG_AUTO_CANCEL;
//             id allows you to update the notification later on.
            mNotificationManager.notify(0, mBuilder.build());
            mBuilder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;
            id = 0;
        } else if (id == 0) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        return START_NOT_STICKY;
    }
}
