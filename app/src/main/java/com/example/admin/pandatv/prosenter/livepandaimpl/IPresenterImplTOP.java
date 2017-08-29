package com.example.admin.pandatv.prosenter.livepandaimpl;

import com.example.admin.pandatv.model.entity.livapandabean.PandaTOPBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.prosenter.IPresenterPandaTop;
import com.example.admin.pandatv.view.base.PandaTOPView;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/28.
 */

public class IPresenterImplTOP implements IPresenterPandaTop,Observer<PandaTOPBean> {

    private NetWorkimpl netWorkimpl;

    private PandaTOPView pandaTOPView;

    public IPresenterImplTOP(PandaTOPView pandaTOPView) {
        this.netWorkimpl=new NetWorkimpl();
        this.pandaTOPView = pandaTOPView;
    }

    @Override
    public void GetcontrollerPanTOP(int a) {


        Map<String,String> map=new TreeMap<String,String>();

        map.put("vsid","VSET100284428835");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",a+"");

        netWorkimpl.requestPandaTOP(this,map);
    }

    @Override
    public void onDestroy() {

        pandaTOPView=null;

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull PandaTOPBean pandaTOPBean) {

        pandaTOPView.OnSucceed(pandaTOPBean);

    }

    @Override
    public void onError(@NonNull Throwable e) {

        pandaTOPView.OnDefeated();

    }

    @Override
    public void onComplete() {

    }
}
