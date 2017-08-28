package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.LiveMBean;
import com.example.admin.pandatv.model.entity.PandaFilesBean;
import com.example.admin.pandatv.model.entity.SplendidBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.entity.SupersBean;
import com.example.admin.pandatv.model.entity.WhenBreadBean;

import java.util.Map;

import io.reactivex.Observer;

/**
 * Created by Administrator on 2017/8/23.
 */

public class NetWorkimpl implements NetWorkManger {
    @Override
    public void requestGet(Observer<BroadcastBean> observer) {
        RetrofitManage.getInstance().GetNetwork(observer);
    }

    @Override
    public void requestGetItem(Observer<BoradcastBeanitem> observer) {
        RetrofitManage.getInstance().GetNetworkItem(observer);
    }

    //这里是熊猫直播里面直播的网络请求的方法
    @Override
    public void requestlivembean(Observer<LiveMBean> observer) {

        RetrofitManage.getInstance().GetNetWorkLiveMBean(observer);

    }

    @Override
    public void requestsplendidbean(Observer<SplendidBean> observer, Map<String, String> map) {
        RetrofitManage.getInstance().GetNetWorkSplendidbean(observer,map);
    }

    //这里是熊猫直播里面精彩一刻的网络请求的方法


    @Override
    public void requestGetRlling(Observer<RllingBean> observer) {
        RetrofitManage.getInstance().GetNetworkRlling(observer);
    }
    //这里是熊猫直播里面当熊不让的网络请求的方法
    @Override
    public void requestWhenBreadbean(Observer<WhenBreadBean> observer, Map<String, String> map) {

        RetrofitManage.getInstance().GetNetworkWhenBreadbean(observer,map);

    }
    //这里是熊猫直播里面熊猫档案的网络请求的方法
    @Override
    public void requestPandaFiles(Observer<PandaFilesBean> observer, Map<String, String> map) {

        RetrofitManage.getInstance().GetNetworkPandaFilesbean(observer,map);

    }
    //这里是熊猫直播里面超萌滚滚秀的网络请求的方法
    @Override
    public void requestSupersbean(Observer<SupersBean> observer, Map<String, String> map) {

        RetrofitManage.getInstance().GetNetworkSupersbean(observer,map);

    }


}
