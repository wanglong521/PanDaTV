package com.example.admin.pandatv.prosenter;


import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.view.base.IView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class IPresenterImpl implements IPresenter,Observer<BroadcastBean> {

    private NetWorkimpl netWorkimpl;
    private IView iView;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        this.netWorkimpl =new NetWorkimpl();
    }

    @Override
    public void Getcontroller() {
        netWorkimpl.requestGet(this);
    }

    @Override
    public void GetcontrollerItem() {

    }


    @Override
    public void onDestroy() {
        iView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull BroadcastBean broadcastBean) {
        iView.OnSucceed(broadcastBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        iView.OnDefeated();
    }

    @Override
    public void onComplete() {

    }
}
