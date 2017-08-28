package com.example.admin.pandatv.prosenter;

import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LvieChina;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.view.base.ChinaViewImpl;
import com.example.admin.pandatv.view.base.IView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by lenovo on 2017/8/25.
 */

public class ChinaPersenter implements ChinaPersenterImpl{

    private NetWorkimpl netWorkimpl;
    private ChinaViewImpl chinaView;

    public ChinaPersenter(ChinaViewImpl chinaView) {
        this.chinaView = chinaView;
        this.netWorkimpl =new NetWorkimpl();
    }


    @Override
    public void getChinaTabList() {
        netWorkimpl.getChiTabList(new Observer<ChinaTabList>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ChinaTabList chinaTabList) {
                chinaView.OnSucceedChinaTabList(chinaTabList);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getLvieChina(String url) {
            netWorkimpl.getLvieChina(new Observer<LvieChina>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull LvieChina lvieChina) {
                        chinaView.OnSucceedLvieChina(lvieChina);
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            },url);
    }
}
