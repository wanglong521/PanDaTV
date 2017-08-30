package com.example.admin.pandatv.prosenter.livepandaimpl;

import com.example.admin.pandatv.model.entity.livapandabean.SupersBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.prosenter.IPresenterSupers;
import com.example.admin.pandatv.view.base.SupersView;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/28.
 */

public class IPresenterImolSupers implements IPresenterSupers,Observer<SupersBean> {

    private NetWorkimpl netWorkimpl;

    private SupersView supersView;

    public IPresenterImolSupers(SupersView supersView) {

        this.netWorkimpl=new NetWorkimpl();
        this.supersView = supersView;
    }

    @Override
    public void GetcontrollerSupers(int a) {

        Map<String,String> map=new TreeMap<String,String>();

        map.put("vsid","VSET100272959126");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",a+"");

        netWorkimpl.requestSupersbean(this,map);
    }

    @Override
    public void onDestroy() {

        supersView=null;

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull SupersBean supersBean) {

        supersView.OnSucceed(supersBean);


    }

    @Override
    public void onError(@NonNull Throwable e) {

        supersView.OnDefeated();

    }

    @Override
    public void onComplete() {

    }
}
