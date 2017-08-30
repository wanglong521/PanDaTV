package com.example.admin.pandatv.prosenter.livepandaimpl;

import com.example.admin.pandatv.model.entity.livapandabean.LiveMBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.prosenter.IPresenter;
import com.example.admin.pandatv.view.base.LiveMBeanView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/26.
 *
 * 这里是熊猫直播里面直播的网络请求的方法
 *
 */

public class IPresenterImplLivemBean implements IPresenter,Observer<LiveMBean>{

    private NetWorkimpl netWorkimpl;
    private LiveMBeanView liveMBeanView;

    public IPresenterImplLivemBean( LiveMBeanView liveMBeanView) {
        this.netWorkimpl = new NetWorkimpl();
        this.liveMBeanView = liveMBeanView;
    }


    @Override
    public void Getcontroller() {

        netWorkimpl.requestlivembean(this);

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

    }


    @Override
    public void onDestroy() {
        liveMBeanView=null;

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {



    }

    @Override
    public void onNext(@NonNull LiveMBean liveMBean) {

        liveMBeanView.OnSucceed(liveMBean);

    }

    @Override
    public void onError(@NonNull Throwable e) {

        liveMBeanView.OnDefeated();

    }

    @Override
    public void onComplete() {

    }
}
