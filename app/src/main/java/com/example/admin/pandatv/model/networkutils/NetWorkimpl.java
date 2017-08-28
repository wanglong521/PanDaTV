package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LvieChina;

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

    @Override
    public void getChiTabList(Observer<ChinaTabList> observer) {
        RetrofitManage.getInstance().getChiTabList(observer);
    }

    @Override
    public void getLvieChina(Observer<LvieChina> observer, String url) {
        RetrofitManage.getInstance().getLvieChina(observer,url);
    }


}
