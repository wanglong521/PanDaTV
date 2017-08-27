package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.RllingBean;

import io.reactivex.Observer;

/**
 * Created by Administrator on 2017/8/23.
 */

public interface NetWorkManger {

    void requestGet(Observer<BroadcastBean> observer);

    void requestGetItem(Observer<BoradcastBeanitem> observer);

    void requestGetRlling(Observer<RllingBean> observer);
}
