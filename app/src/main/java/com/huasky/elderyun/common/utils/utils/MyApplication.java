package com.huasky.elderyun.common.utils.utils;

import android.content.Context;

import com.huasky.elderyun.app.BaseApplication;
import com.iflytek.cloud.Setting;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * Created by ywh on 2017-09-01.
 */
public class MyApplication extends BaseApplication{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SpeechUtility.createUtility(context, SpeechConstant.APPID +"=59a8fdb1");
        // 以下语句用于设置日志开关（默认开启），设置成false时关闭语音云SDK日志打印
        Setting.setShowLog(false);
        TTSUtils.getInstance().init();
    }

    public static Context getContext() {
        return context;
    }

}
