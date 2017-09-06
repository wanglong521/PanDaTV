package com.example.admin.pandatv.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LvieChina;
import com.example.admin.pandatv.model.modelutils.chinalive_greendao.DaoMaster;
import com.example.admin.pandatv.model.modelutils.chinalive_greendao.DaoSession;
import com.example.admin.pandatv.model.modelutils.chinalive_greendao.GreenDao_China_Tab;
import com.example.admin.pandatv.model.modelutils.chinalive_greendao.GreenDao_China_TabDao;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.DaoMaster;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.DaoSession;
import com.example.admin.pandatv.prosenter.ChinaPersenter;
import com.example.admin.pandatv.view.activity.DialogActivity;
import com.example.admin.pandatv.view.adapter.China_item_PagerAdapter;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.ChinaViewImpl;
import com.example.admin.pandatv.view.fragment.ChinaModule.China_Item_Fragment;

import java.util.ArrayList;
import java.util.List;

import static com.umeng.socialize.a.b.d.i;

/**
 * Created by admin on 2017/8/23.
 */

public class ChinaModule_Fragment extends BaseFragment implements ChinaViewImpl {
    private TabLayout china_tab;
    private ChinaPersenter chinaPersenter;
    private ViewPager china_viewpager;
    private ArrayList<Fragment> fragments;
    private ImageView china_login;
    private ImageView china_iv_add;
    private GreenDao_China_TabDao dao;
    private List<GreenDao_China_Tab> list;
    ChinaTabList chinaTabList;
    @Override
    public int getLayout() {
        return R.layout.chinamodule_fragment;
    }

    @Override
    protected void initListener() {
        // 通过persenter层获取网络数据
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
        china_login = view.findViewById(R.id.china_login);
        china_iv_add = view.findViewById(R.id.china_iv_add);

        // 跳转到个人界面
        china_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });
    }

    @Override
    public void OnSucceedChinaTabList(final ChinaTabList chinaTabList) {
        this.chinaTabList = chinaTabList;
        //  获取数据库中的信息

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "hdm.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        dao = daoSession.getGreenDao_China_TabDao();
//        dao.deleteAll();
        list = dao.queryBuilder().list();
        //  判断数据库中有没有数据，如没有，在网络请求中获取
        if (list.size() != 0){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getABoolean()){
                    china_tab.addTab(china_tab.newTab().setText(list.get(i).getTabtitle()));

                }
            }
        }else{
            for (int i = 0; i < chinaTabList.getTablist().size(); i++) {
                china_tab.addTab(china_tab.newTab().setText(chinaTabList.getTablist().get(i).getTitle()));
                china_tab.setTag(china_tab.newTab().setText(chinaTabList.getTablist().get(i).getTitle()));
            }
        }

        // 创建一个Fragment  绑定Viewpager
        fragments = new ArrayList<>();
        fragments.add(new China_Item_Fragment());
        china_viewpager.setAdapter(new China_item_PagerAdapter(getActivity().getSupportFragmentManager()
                , getActivity(), fragments));

        // 给tab设置可滑动
        china_tab.setTabMode(china_tab.MODE_SCROLLABLE);

        // 刚打开时,默认的数据
        for (int i = 0; i < chinaTabList.getAlllist().size(); i++) {
            if (china_tab.getTabAt(0).getText().toString().equals(chinaTabList.getAlllist().get(i).getTitle())){
                chinaPersenter.getLvieChina(chinaTabList.getAlllist().get(i).getUrl());
            }
        }
        china_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int size = tab.getPosition() + 1;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < chinaTabList.getAlllist().size(); j++) {
                        String title = tab.getText().toString();

                        //   通过tab监听，设置点击状态
                        if (title.equals(chinaTabList.getAlllist().get(j).getTitle())) {
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

        china_iv_add.setOnClickListener(new View.OnClickListener() {

            private ArrayList<String> titles;
            private ArrayList<String> tabtitle;

            @Override
            public void onClick(View view) {
//                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setView(LayoutInflater.from(getActivity()
//                ).inflate(R.layout.baseedit,null)).show();
                tabtitle = new ArrayList<String>();
                titles = new ArrayList<String>();
//                for (int i = 0; i < chinaTabList.getAlllist().size(); i++) {
//                    Log.e( "55555555555555555: ", chinaTabList.getAlllist().get(i).getTitle());
//                }
                Intent intent = new Intent(getActivity(), DialogActivity.class);
                if (list.size() != 0){
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getABoolean()){
                            tabtitle.add(list.get(i).getTabtitle());
                        }else{
                            titles.add(list.get(i).getTabtitle());
                        }
                    }
                }else{
                    for (int i = 0; i < china_tab.getTabCount(); i++) {
                        tabtitle.add(china_tab.getTabAt(i).getText().toString());
                    }
                    for (int i = 0; i < chinaTabList.getAlllist().size(); i++) {
                            titles.add(chinaTabList.getAlllist().get(i).getTitle());
                    }

                }
                for (int i = 0; i < tabtitle.size(); i++) {
                    Log.e("666666666: ",tabtitle.get(i));
                } for (int i = 0; i < titles.size(); i++) {
                    Log.e("666666666: ",titles.get(i));
                }
                intent.putExtra("tabtitle", tabtitle);
                intent.putExtra("titles",titles);

                startActivityForResult(intent,20);
            }
        });
    }

    @Override
    public void OnSucceedLvieChina(LvieChina lvieChina) {
//        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> briefList = new ArrayList();
        ArrayList<String> imageList = new ArrayList();
        ArrayList<String> titleList = new ArrayList();
        ArrayList<String> idList = new ArrayList();
        for (int i = 0; i < lvieChina.getLive().size(); i++) {
            briefList.add(lvieChina.getLive().get(i).getBrief());
            imageList.add(lvieChina.getLive().get(i).getImage());
            titleList.add(lvieChina.getLive().get(i).getTitle());
            idList.add(lvieChina.getLive().get(i).getId());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("brief", briefList);
        bundle.putStringArrayList("image", imageList);
        bundle.putStringArrayList("title", titleList);
        bundle.putStringArrayList("id", idList);
        Log.e("OnSucceedLvieChina: ", briefList.get(0));
//        fragments.add(new China_Item_Fragment());
        Intent intent = new Intent();
        intent.setAction("aaa");
        intent.putExtra("bundle", bundle);
        getActivity().sendBroadcast(intent);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        List<GreenDao_China_Tab> list = dao.queryBuilder().list();
        china_tab.removeAllTabs();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getABoolean()){
                china_tab.addTab(china_tab.newTab().setText(list.get(i).getTabtitle()));
            }
        }
        for (int i = 0; i < chinaTabList.getAlllist().size(); i++) {
            if (china_tab.getTabAt(0).getText().toString().equals(chinaTabList.getAlllist().get(i).getTitle())){
                chinaPersenter.getLvieChina(chinaTabList.getAlllist().get(i).getUrl());
            }
        }


        super.onActivityResult(requestCode, resultCode, data);

    }
}
