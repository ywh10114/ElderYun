package com.huasky.elderyun.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.alivc.player.AccessKey;
import com.alivc.player.AccessKeyCallback;
import com.alivc.player.AliVcMediaPlayer;
import com.huasky.elderyun.common.utils.utils.Utils;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.NoEncryption;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.SavePowerConfig;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.Unicorn;
import com.qiyukf.unicorn.api.UnicornImageLoader;
import com.qiyukf.unicorn.api.YSFOptions;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by cj on 2017/4/14.
 */

public class BaseApplication extends Application {
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication=this;
        init();
        initQiYu();
        initAliPlayer();
        LeakCanary.install(this);
    }

    private void initAliPlayer() {
        AliVcMediaPlayer.init(getApplicationContext(), "businessId", new AccessKeyCallback() {
            @Override
            public AccessKey getAccessToken() {
                return new AccessKey("LTAI1A1iVXT7JaFA","IKjJ0SAwgrzPXurZ2plSvzPPcSkwfj");
            }
        });
    }

    private void initQiYu() {  //七鱼客服
        Unicorn.init(this, "448d0ee02a551278ab86046b02d61208", options(), new UnicornImageLoader() {
            @Nullable
            @Override
            public Bitmap loadImageSync(String uri, int width, int height) {
                return null;
            }

            @Override
            public void loadImage(String uri, int width, int height, ImageLoaderListener listener) {

            }
        });
    }

    private YSFOptions options() {
        YSFOptions options=new YSFOptions();
        options.statusBarNotificationConfig=new StatusBarNotificationConfig();
        options.savePowerConfig=new SavePowerConfig();
        options.uiCustomization=new UICustomization();
        options.uiCustomization.hideKeyboardOnEnterConsult=true;
        return options;
    }

    private void init() {
        Hawk.init(getContext())
                .setEncryption(new NoEncryption())
                .build();
        Utils.init(getContext().getApplicationContext());
    }

    public static Context getContext(){
        return baseApplication;
    }
}
