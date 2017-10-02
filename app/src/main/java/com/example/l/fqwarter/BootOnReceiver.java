package com.example.l.fqwarter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootOnReceiver extends BroadcastReceiver {

    static final String ACTION = "android.intent.action.BOOT_COMPLETED";
    private final static String TAG = "BootOnReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "BootOnReceiver  ---onReceive!!");

//        if (intent.getAction().equals(ACTION)){
//            Intent mainAtyIntent = new Intent(context, MainActivity.class);
//            mainAtyIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(mainAtyIntent);
//        }
    }
}
