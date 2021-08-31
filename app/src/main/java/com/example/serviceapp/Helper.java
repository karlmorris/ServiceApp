package com.example.serviceapp;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class Helper {

    /**
     * Helper method to provide Pending Intent to launch internal activity
     * @param context
     * @return PendingIntent
     */
    public static PendingIntent getLaunchPendingIntent(Context context) {
        Intent launchIntent = new Intent(context, SecondActivity.class);
        return PendingIntent.getActivity(context, 0, launchIntent, 0);
    }
}
