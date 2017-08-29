package com.example.admin.pandatv.prosenter.livepandaimpl;

import com.example.admin.pandatv.model.entity.livapandabean.SplendidBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.prosenter.IPresenter;
import com.example.admin.pandatv.view.base.SplendidView;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/27.
 */

public class IPresenterImplSplendid implements IPresenter,Observer<SplendidBean>{

    private NetWorkimpl netWorkimpl;
    private SplendidView splenddidView;


    public IPresenterImplSplendid(SplendidView splenddidView) {

        this.splenddidView=splenddidView;
        this.netWorkimpl=new NetWorkimpl();
    }

    @Override
    public void Getcontroller() {

    }

    @Override
    public void GetcontrollerItem() {

    }

    @Override
    public void GetcontrollerRlling() {

    }

    @Override
    public void GetcontrollerSplendid(int a) {
        Map<String,String> map = new TreeMap<String, String>();
        map.put("vsid","VSET100167216881");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",a+"");
        netWorkimpl.requestsplendidbean(this,map);
    }

    @Override
    public void GetcontrollerWhenBread(int a) {

    }


    @Override
    public void onDestroy() {

        splenddidView=null;

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull SplendidBean splendidBean) {
        splenddidView.OnSucceed(splendidBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {

        splenddidView.OnDefeated();

    }

    @Override
    public void onComplete() {

    }
}
