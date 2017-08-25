package com.example.admin.pandatv.view.fragment;

import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.FrameLayout;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by admin on 2017/8/23.
 */

public class ChinaModule_Fragment  extends BaseFragment {

    private TabLayout china_tab;
    private FrameLayout china_frame;
    @Override
    public int getLayout() {
        return R.layout.chinamodule_fragment;
    }

    @Override
    protected void initListener() {
        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("八达岭");
        titleList.add("泰山");
        titleList.add("黄山");
        titleList.add("凤凰古城");
        titleList.add("中央电视塔");
        for (int i = 0; i < titleList.size() ; i++) {
            china_tab.addTab(china_tab.newTab().setText(titleList.get(i)));
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        china_tab = view.findViewById(R.id.china_tab);
        china_frame = view.findViewById(R.id.china_frame);
    }
}
