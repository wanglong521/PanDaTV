package com.example.admin.pandatv.prosenter;

import com.example.admin.pandatv.model.entity.SplendidBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.view.base.SplendidView;

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


      netWorkimpl.requestsplendidbean(this);

    }

    @Override
    public void GetcontrollerItem() {

    }

    @Override
    public void GetcontrollerRlling() {

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
