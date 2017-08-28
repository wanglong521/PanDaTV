package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.PandaTOPBean;
import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LiveMBean;
import com.example.admin.pandatv.model.entity.LvieChina;
import com.example.admin.pandatv.model.entity.PandaFilesBean;
import com.example.admin.pandatv.model.entity.PandaThingBean;
import com.example.admin.pandatv.model.entity.PrimarynewBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.entity.SpecialBean;
import com.example.admin.pandatv.model.entity.SplendidBean;
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
    //这里是熊猫直播里面精彩一刻的网络请求的方法
    @Override
    public void requestsplendidbean(Observer<SplendidBean> observer, Map<String, String> map) {
        RetrofitManage.getInstance().GetNetWorkSplendidbean(observer,map);
    }

    @Override
    public void requestGetRlling(Observer<RllingBean> observer) {
        RetrofitManage.getInstance().GetNetworkRlling(observer);
    }
    @Override
    public void getChiTabList(Observer<ChinaTabList> observer) {
        RetrofitManage.getInstance().getChiTabList(observer);
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
    //这是熊猫直播里面熊猫TOP榜的网络请求
    @Override
    public void requestPandaTOP(Observer<PandaTOPBean> observer, Map<String, String> map) {

        RetrofitManage.getInstance().getPandaTOP(observer,map);

    }
    //这是熊猫直播里面熊猫那些事的网络请求
    @Override
    public void requstPandaThing(Observer<PandaThingBean> observer, Map<String, String> map) {

        RetrofitManage.getInstance().getPandaThing(observer,map);
    }

    //这是熊猫直播里面特别节目的网络请求
    @Override
    public void requestSpecial(Observer<SpecialBean> observer, Map<String, String> map) {

        RetrofitManage.getInstance().getSpecial(observer,map);

    }
    //这是熊猫直播里面原创新闻的网络请求
    @Override
    public void requestPrimary(Observer<PrimarynewBean> observer, Map<String, String> map) {

        RetrofitManage.getInstance().getPrimarynew(observer,map);
    }


    @Override
    public void getLvieChina(Observer<LvieChina> observer, String url) {
        RetrofitManage.getInstance().getLvieChina(observer,url);
    }

}
