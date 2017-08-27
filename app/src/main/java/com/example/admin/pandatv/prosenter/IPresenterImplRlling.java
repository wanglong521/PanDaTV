package com.example.admin.pandatv.prosenter;

import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.view.base.IView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/27.
 */

public class IPresenterImplRlling implements IPresenter, Observer<RllingBean> {

    private NetWorkimpl netWorkimpl;
    private IView iView;

    public IPresenterImplRlling(IView iView) {
        this.iView = iView;
        this.netWorkimpl = new NetWorkimpl();
    }

    @Override
    public void Getcontroller() {

    }

    @Override
    public void GetcontrollerItem() {

    }

    @Override
    public void GetcontrollerRlling() {
        netWorkimpl.requestGetRlling(this);
    }

    @Override
    public void onDestroy() {
        iView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull RllingBean rllingBean) {
        iView.OnSucceedRlling(rllingBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        iView.OnDefeatedRlling();
    }

    @Override
    public void onComplete() {

    }
}
