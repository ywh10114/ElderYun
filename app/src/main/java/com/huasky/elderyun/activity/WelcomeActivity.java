package com.huasky.elderyun.activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.huasky.elderyun.R;
import com.huasky.elderyun.adapter.StartViewPagerAdapter;

/**
 * 启动欢迎页面
 */
public class WelcomeActivity extends AppCompatActivity {
    private ImageView welcome_icon;
    private AlphaAnimation alphaAnim;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        welcome_icon= (ImageView) findViewById(R.id.welcome_icon);
        alphaAnim=(AlphaAnimation) AnimationUtils.loadAnimation(WelcomeActivity.this,R.anim.welcome_alpha);
        Handler handler = new Handler();
        welcome_icon.setAnimation(alphaAnim);
        handler.postDelayed(new Runnable() {
            public void run() {
                // TODO Auto-generated method stub
                runOnUiThread(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(WelcomeActivity.this, StartActivity.class);
                        startActivity(intent);
                        WelcomeActivity.this.finish();
                    }
                });
            }
        },2000);

    }

    }




