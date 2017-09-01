package com.huasky.elderyun.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.huasky.elderyun.R;
import com.huasky.elderyun.activity.LoginActivity;

import java.util.List;


/**
 * 引导页面
 * Created by pokermman on 2017/2/9.
 */

public class StartViewPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    private Context mContext;

    public StartViewPagerAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    public StartViewPagerAdapter(Context context, List<View> viewList) {
        this.viewList = viewList;
        this.mContext = context;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
        //        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        View view = viewList.get(position);
        if (position == 4) {
            Button btn = (Button) view.findViewById(R.id.start_viewpager_btn);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(mContext,LoginActivity.class);
                    SharedPreferences preferences=mContext.getSharedPreferences("user", mContext.MODE_PRIVATE);
                    preferences.edit().putBoolean("first",true).commit();
                    mContext.startActivity(intent);
                    ((Activity)mContext).finish();
                }
            });

        }
        container.addView(view, 0);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
