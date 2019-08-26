package com.risonaza.os.risonaza;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MyAlarm extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayer player=MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        player.start();
    }
}
