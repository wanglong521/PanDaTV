package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.LiveMBean;
import com.example.admin.pandatv.model.entity.PandaFilesBean;
import com.example.admin.pandatv.model.entity.SplendidBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LvieChina;

import io.reactivex.Observer;

/**
 * Created by Administrator on 2017/8/23.
 */

public interface NetWorkManger {

    void requestGet(Observer<BroadcastBean> observer);

    void requestGetItem(Observer<BoradcastBeanitem> observer);

    //这里是熊猫直播里面直播的网络请求的方法
    void requestlivembean(Observer<LiveMBean> observer);

    //这里是熊猫直播里面精彩一刻的网络请求的方法
    void requestsplendidbean(Observer<SplendidBean> observer, Map<String,String> map);

    void getChiTabList(Observer<ChinaTabList> observer);

    void getLvieChina(Observer<LvieChina> observer, String url);

    void requestGetRlling(Observer<RllingBean> observer);

    //这里是熊猫直播里面当熊不让的网络请求的方法
    void requestWhenBreadbean(Observer<WhenBreadBean> observer,Map<String,String> map);

    //这是熊猫直播里面熊猫档案的网络请求的方法
    void requestPandaFiles(Observer<PandaFilesBean> observer,Map<String,String> map);

    void requestSupersbean(Observer<SupersBean> observer,Map<String,String> map);
}
