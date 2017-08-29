package com.example.admin.pandatv.prosenter.livepandaimpl;

import com.example.admin.pandatv.model.entity.PandaFilesBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.prosenter.IPresenterPanFiles;
import com.example.admin.pandatv.view.base.PandaFilesView;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/28.
 */

public class IPresenterImplPanFiles implements IPresenterPanFiles,Observer<PandaFilesBean>{

    private NetWorkimpl netWorkimpl;
    private PandaFilesView pandaFilesView;

    public IPresenterImplPanFiles(PandaFilesView pandaFilesView) {

        this.netWorkimpl=new NetWorkimpl();
        this.pandaFilesView = pandaFilesView;
    }


    @Override
    public void GetcontrollerPanfiles(int a) {

        Map<String,String> map=new TreeMap<String,String>();

        map.put("vsid","VSET100340574858");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",a+"");

        netWorkimpl.requestPandaFiles(this,map);

    }

    @Override
    public void onDestroy() {

        pandaFilesView=null;

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull PandaFilesBean pandaFilesBean) {

        pandaFilesView.OnSucceed(pandaFilesBean);

    }

    @Override
    public void onError(@NonNull Throwable e) {

        pandaFilesView.OnDefeated();

    }

    @Override
    public void onComplete() {

    }
}
