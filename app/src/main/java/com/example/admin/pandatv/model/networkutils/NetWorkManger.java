package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.livapandabean.PandaTOPBean;
import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.livapandabean.LiveMBean;
import com.example.admin.pandatv.model.entity.LvieChina;
import com.example.admin.pandatv.model.entity.livapandabean.PandaFilesBean;
import com.example.admin.pandatv.model.entity.livapandabean.PandaThingBean;
import com.example.admin.pandatv.model.entity.livapandabean.PrimarynewBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.entity.livapandabean.SpecialBean;
import com.example.admin.pandatv.model.entity.livapandabean.SplendidBean;
import com.example.admin.pandatv.model.entity.livapandabean.SupersBean;
import com.example.admin.pandatv.model.entity.livapandabean.WhenBreadBean;

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

    void getChiTabList(Observer<ChinaTabList> observer);

    void getLvieChina(Observer<LvieChina> observer, String url);

    void requestGetRlling(Observer<RllingBean> observer);

    //这里是熊猫直播里面当熊不让的网络请求的方法
    void requestWhenBreadbean(Observer<WhenBreadBean> observer, Map<String,String> map);

    //这是熊猫直播里面熊猫档案的网络请求的方法
    void requestPandaFiles(Observer<PandaFilesBean> observer,Map<String,String> map);
   //这里是熊猫直播里超萌滚滚秀的网络请求
    void requestSupersbean(Observer<SupersBean> observer, Map<String,String> map);

    //这是熊猫直播里面熊猫TOP榜的网络请求
    void requestPandaTOP(Observer<PandaTOPBean> observer,Map<String,String> map);

    //这是熊猫直播里面熊猫那些事的网络请求
    void requstPandaThing(Observer<PandaThingBean> observer,Map<String,String> map);

    //这是熊猫直播里面特别节目的网络请求
    void requestSpecial(Observer<SpecialBean> observer,Map<String,String> map);

    //这是熊猫直播里面原创新闻的网络请求
    void requestPrimary(Observer<PrimarynewBean> observer,Map<String,String> map);
}
