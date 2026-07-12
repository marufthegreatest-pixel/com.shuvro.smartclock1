package com.example.clockapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class AlarmReceiver extends BroadcastReceiver {
    TextToSpeech tts;
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        tts = new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.ENGLISH);
                tts.speak(msg != null ? msg : "অ্যালার্ম বেজেছে!", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });
    }
}
