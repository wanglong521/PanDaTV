package com.example.admin.pandatv.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LvieChina;
import com.example.admin.pandatv.model.modelutils.FragmentBuilder;
import com.example.admin.pandatv.prosenter.ChinaPersenter;
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
    private China_Item_Fragment china_item_fragment;

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
    }

    @Override
    public void OnSucceedChinaTabList(final ChinaTabList chinaTabList) {
        for (int i = 0; i < chinaTabList.getTablist().size(); i++) {
            china_tab.addTab(china_tab.newTab().setText(chinaTabList.getTablist().get(i).getTitle()));
        }
        chinaPersenter.getLvieChina(chinaTabList.getTablist().get(0).getUrl());
        china_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int size = tab.getPosition() + 1;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < chinaTabList.getAlllist().size(); j++) {
                        String title = tab.getText().toString();
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
        setArguments(bundle);
        china_item_fragment = new China_Item_Fragment();
        china_item_fragment.setArguments(bundle);
        FragmentBuilder.getInstance().init().initContainId(R.id.china_frame).add(China_Item_Fragment.class).build();
    }
}
