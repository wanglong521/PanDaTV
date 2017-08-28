package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.LiveMBean;
import com.example.admin.pandatv.model.entity.SplendidBean;

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

    //这里是熊猫直播里面精彩一刻的网络请求的方法
    @Override
    public void requestsplendidbean(Observer<SplendidBean> observer) {
        RetrofitManage.getInstance().GetNetWorkSplendidbean(observer);
    }



}
