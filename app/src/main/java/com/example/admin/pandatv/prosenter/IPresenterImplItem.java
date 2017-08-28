package com.example.admin.pandatv.prosenter;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.view.base.IView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/25.
 */

public class IPresenterImplItem implements IPresenter, Observer<BoradcastBeanitem> {

    private NetWorkimpl netWorkimpl;
    private IView iView;

    public IPresenterImplItem(IView iView) {
        this.iView = iView;
        this.netWorkimpl = new NetWorkimpl();
    }

    @Override
    public void Getcontroller() {

    }

    @Override
    public void GetcontrollerItem() {
        netWorkimpl.requestGetItem(this);
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
        iView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull BoradcastBeanitem beanitem) {
        iView.OnSucceedItem(beanitem);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        iView.OnDefeatedItem();
    }

    @Override
    public void onComplete() {

    }
}
