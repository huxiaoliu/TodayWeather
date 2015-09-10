package com.example.huxiaoliu.todayweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.huxiaoliu.todayweather.service.AutoUpdateService;

/**
 * Created by huxiaoliu on 2015/9/10.
 * 激活自动更新天气的广播
 */
public class AutoUpdateReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context,AutoUpdateService.class);
        context.startService(i);
    }
}
