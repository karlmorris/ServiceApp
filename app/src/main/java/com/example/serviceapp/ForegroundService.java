package com.example.serviceapp;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class ForegroundService extends Service {

    Notification n;

    public ForegroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        n = (new NotificationCompat.Builder(this, "AccountInfo"))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Service is Running")
                .setContentText("Please note that this service will continue to run unil you explicitly exit")
                .setChannelId("AccountInfo")
                .setContentIntent(Helper.getLaunchPendingIntent(this))
                .build();

        startForeground(123, n);

        return super.onStartCommand(intent, flags, startId);
    }
}