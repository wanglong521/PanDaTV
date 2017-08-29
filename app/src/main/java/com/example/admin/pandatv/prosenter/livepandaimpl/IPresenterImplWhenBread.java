package com.example.admin.pandatv.prosenter.livepandaimpl;

import com.example.admin.pandatv.model.entity.WhenBreadBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.prosenter.IPresenter;
import com.example.admin.pandatv.view.base.WhenBreadView;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/28.
 */

public class IPresenterImplWhenBread implements IPresenter,Observer<WhenBreadBean>{

    private NetWorkimpl netWorkimpl;
    private WhenBreadView whenBreadView;

    public IPresenterImplWhenBread(WhenBreadView whenBreadView) {
        this.netWorkimpl = new NetWorkimpl();
        this.whenBreadView = whenBreadView;
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

    }

    @Override
    public void GetcontrollerWhenBread(int a) {

        Map<String,String> map=new TreeMap<String,String>();

        map.put("vsid","VSET100332640004");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",a+"");

        netWorkimpl.requestWhenBreadbean(this,map);

    }

    @Override
    public void onDestroy() {

        whenBreadView=null;

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull WhenBreadBean whenBreadBean) {

        whenBreadView.OnSucceed(whenBreadBean);

    }

    @Override
    public void onError(@NonNull Throwable e) {

        whenBreadView.OnDefeated();
    }

    @Override
    public void onComplete() {

    }
}
