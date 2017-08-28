package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.LiveMBean;
import com.example.admin.pandatv.model.entity.SplendidBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.entity.WhenBreadBean;

import java.util.Map;

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

    void requestGetRlling(Observer<RllingBean> observer);

    //这里是熊猫直播里面当熊不让的网络请求的方法
    void requestWhenBreadbean(Observer<WhenBreadBean> observer,Map<String,String> map);
}
