package com.example.admin.pandatv.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LvieChina;
import com.example.admin.pandatv.prosenter.ChinaPersenter;
import com.example.admin.pandatv.view.adapter.China_item_PagerAdapter;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.ChinaViewImpl;
import com.example.admin.pandatv.view.fragment.ChinaModule.China_Item_Fragment;

import java.util.ArrayList;

/**
 * Created by admin on 2017/8/23.
 */

public class ChinaModule_Fragment  extends BaseFragment implements ChinaViewImpl{
    private TabLayout china_tab;
    private ChinaPersenter chinaPersenter;
    private ViewPager china_viewpager;

    @Override
    public int getLayout() {
        return R.layout.chinamodule_fragment;
    }

    @Override
    protected void initListener() {
        chinaPersenter = new ChinaPersenter(this);
        chinaPersenter.getChinaTabList();
    }
    @Override
    protected void initData() {
    }
    @Override
    protected void initView(View view) {
        china_tab = view.findViewById(R.id.china_tab);
        china_viewpager = view.findViewById(R.id.china_viewpager);
    }

    @Override
    public void OnSucceedChinaTabList(final ChinaTabList chinaTabList) {
        for (int i = 0; i < chinaTabList.getTablist().size(); i++) {
            china_tab.addTab(china_tab.newTab().setText(chinaTabList.getTablist().get(i).getTitle()));
            china_tab.setTag(china_tab.newTab().setText(chinaTabList.getTablist().get(i).getTitle()));
        }
        chinaPersenter.getLvieChina(chinaTabList.getTablist().get(0).getUrl());
        china_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int size = tab.getPosition() + 1;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < chinaTabList.getAlllist().size(); j++) {
                        String title = tab.getText().toString();
                        Log.e("onTabSelected: ", title);
                        if (title .equals(chinaTabList.getAlllist().get(j).getTitle())){
                            chinaPersenter.getLvieChina(chinaTabList.getAlllist().get(j).getUrl());
                        }
                    }
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    @Override
    public void OnSucceedLvieChina(LvieChina lvieChina) {
        ArrayList<String> briefList = new ArrayList();
        ArrayList<String> imageList = new ArrayList();
        ArrayList<String> titleList = new ArrayList();
        for (int i = 0; i < lvieChina.getLive().size(); i++) {
               briefList.add(lvieChina.getLive().get(i).getBrief());
               imageList.add(lvieChina.getLive().get(i).getImage());
               titleList.add(lvieChina.getLive().get(i).getTitle());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("brief",briefList);
        bundle.putStringArrayList("image",imageList);
        bundle.putStringArrayList("title",titleList);
        Log.e("OnSucceedLvieChina: ", briefList.get(0));
//        setArguments(bundle);
//        china_item_fragment = new China_Item_Fragment();
//        china_item_fragment.setArguments(bundle);
        Intent intent = new Intent();
        intent.setAction("aaa");
        intent.putExtra("bundle",bundle);
        getActivity().sendBroadcast(intent);
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < china_tab.getTabCount() ; i++) {
                fragments.add(new China_Item_Fragment());
        }
        china_viewpager.setAdapter(new China_item_PagerAdapter(getActivity().getSupportFragmentManager()
        ,getActivity(),fragments));
    }
}
