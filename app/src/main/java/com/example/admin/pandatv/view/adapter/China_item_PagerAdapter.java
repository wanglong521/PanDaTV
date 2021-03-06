package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/28.
 */

public class China_item_PagerAdapter extends FragmentPagerAdapter{
    private Context context;
    private ArrayList<Fragment> fragments;
    public China_item_PagerAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments) {
        super(fm);
        this.context=context;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
    }
}
