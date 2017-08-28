package com.example.admin.pandatv.prosenter;

import com.example.admin.pandatv.model.entity.PandaThingBean;
import com.example.admin.pandatv.model.networkutils.NetWorkimpl;
import com.example.admin.pandatv.view.base.PandatingView;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by LiYRong on 2017/8/28.
 */

public class IPresenterImplThing implements IPresenterPTing,Observer<PandaThingBean> {

    private NetWorkimpl netWorkimpl;
    private PandatingView pandatingView;

    public IPresenterImplThing(PandatingView pandatingView) {
        this.netWorkimpl=new NetWorkimpl();
        this.pandatingView = pandatingView;
    }

    @Override
    public void GetcontrollerPanTing(int a) {

        Map<String,String> map=new TreeMap<String,String>();

        map.put("vsid","VSET100237714751");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",a+"");
        netWorkimpl.requstPandaThing(this,map);

    }

    @Override
    public void onDestroy() {

        pandatingView=null;

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull PandaThingBean pandaThingBean) {

        pandatingView.OnSucceed(pandaThingBean);

    }

    @Override
    public void onError(@NonNull Throwable e) {

        pandatingView.OnDefeated();

    }

    @Override
    public void onComplete() {

    }
}
