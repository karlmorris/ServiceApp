package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        // Needs API 23 to use class type argument - otherwise Context.ALARM_SERVICE
        alarmManager = getSystemService(AlarmManager.class);

        findViewById(R.id.startServiceButton).setOnClickListener(v -> {
            startService(new Intent(this, ForegroundService.class));
        });

        findViewById(R.id.stopServiceButton).setOnClickListener(v -> {
            stopService(new Intent(this, ForegroundService.class));
        });

        findViewById(R.id.setAlarmButton).setOnClickListener(v -> {
            alarmManager.set(AlarmManager.RTC, 5000, Helper.getLaunchPendingIntent(this));
        });
    }

    /**
     * Notification chanel creation is idempotent
     */
    private void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(
                "AccountInfo"
                , "Account Notifications"
                , NotificationManager.IMPORTANCE_DEFAULT
        );

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(notificationChannel);

    }

}