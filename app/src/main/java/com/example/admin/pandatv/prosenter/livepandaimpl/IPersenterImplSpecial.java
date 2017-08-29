package com.example.admin.pandatv.prosenter.livepandaimpl;

import com.example.admin.pandatv.model.entity.SpecialBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.prosenter.IPresenterSpecial;
import com.example.admin.pandatv.view.base.SpecialView;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/28.
 */

public class IPersenterImplSpecial implements IPresenterSpecial,Observer<SpecialBean> {

    private NetWorkimpl netWorkimpl;
    private SpecialView specialView;

    public IPersenterImplSpecial(SpecialView specialView) {
        this.netWorkimpl=new NetWorkimpl();

        this.specialView = specialView;
    }

    @Override
    public void GetcontrollerSpecial(int a) {

        Map<String,String> map=new TreeMap<String,String>();

        map.put("vsid","VSET100167308855");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",a+"");

        netWorkimpl.requestSpecial(this,map);
    }

    @Override
    public void onDestroy() {

        specialView=null;

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull SpecialBean specialBean) {

        specialView.OnSucceed(specialBean);

    }

    @Override
    public void onError(@NonNull Throwable e) {

        specialView.OnDefeated();

    }

    @Override
    public void onComplete() {

    }
}