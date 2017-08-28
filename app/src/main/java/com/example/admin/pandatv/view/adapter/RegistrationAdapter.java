package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/28.
 */

public class RegistrationAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> list = new ArrayList<Fragment>();
    private Context context;
    private ArrayList<String> str = new ArrayList<String>();

    public RegistrationAdapter(FragmentManager fm, ArrayList<Fragment> list, Context context, ArrayList<String> str) {
        super(fm);
        this.list = list;
        this.context = context;
        this.str = str;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str.get(position);
    }
}
