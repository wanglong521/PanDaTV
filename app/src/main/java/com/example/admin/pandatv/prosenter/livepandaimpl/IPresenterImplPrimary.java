package com.example.admin.pandatv.prosenter.livepandaimpl;

import com.example.admin.pandatv.model.entity.livapandabean.PrimarynewBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.prosenter.IPersenterPrimary;
import com.example.admin.pandatv.view.base.PrimaryView;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/28.
 */

public class IPresenterImplPrimary implements IPersenterPrimary,Observer<PrimarynewBean> {

    private NetWorkimpl netWorkimpl;
    private PrimaryView primaryView;

    public IPresenterImplPrimary(PrimaryView primaryView) {
        this.netWorkimpl=new NetWorkimpl();
        this.primaryView = primaryView;
    }

    @Override
    public void GetcontrollerPrimary(int a) {

        Map<String,String> map=new TreeMap<String,String>();

        map.put("vsid","VSET100219009515");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",a+"");

        netWorkimpl.requestPrimary(this,map);

    }

    @Override
    public void onDestroy() {

        primaryView=null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull PrimarynewBean primarynewBean) {

        primaryView.OnSucceed(primarynewBean);

    }

    @Override
    public void onError(@NonNull Throwable e) {

        primaryView.OnDefeated();
    }

    @Override
    public void onComplete() {

    }
}
