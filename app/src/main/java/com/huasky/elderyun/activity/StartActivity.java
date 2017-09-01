package com.huasky.elderyun.activity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import com.huasky.elderyun.R;
import com.huasky.elderyun.adapter.StartViewPagerAdapter;


import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class StartActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator mCircleIndicator;
    private List<View> viewPagerList;
    private Button returnBtn;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
        if(preferences.getBoolean("first",false)){
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
            this.finish();
        }

        //状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        initView();
        init();

    }

    @SuppressLint("InflateParams")
    private void init() {
        viewPagerList = new ArrayList<>();
        View view1 = getLayoutInflater().inflate(R.layout.activity_start_viewpager_one, null);
        View view2 = getLayoutInflater().inflate(R.layout.activity_start_viewpager_two, null);
        View view3 = getLayoutInflater().inflate(R.layout.activity_start_viewpager_three, null);
        View view4 = getLayoutInflater().inflate(R.layout.activity_start_viewpager_four, null);
        View view5 = getLayoutInflater().inflate(R.layout.activity_start_viewpager_five, null);

        viewPagerList.add(view2);
        viewPagerList.add(view1);
        viewPagerList.add(view4);
        viewPagerList.add(view5);
        viewPagerList.add(view3);
        StartViewPagerAdapter adapter = new StartViewPagerAdapter(this, viewPagerList);
        viewPager.setAdapter(adapter);
        mCircleIndicator.setViewPager(viewPager);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_start);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator_start);
        returnBtn = (Button) findViewById(R.id.start_return_btn);

    }
}
