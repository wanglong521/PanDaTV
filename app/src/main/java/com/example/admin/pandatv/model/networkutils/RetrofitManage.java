package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LvieChina;
import com.example.admin.pandatv.model.entity.LiveMBean;
import com.example.admin.pandatv.model.entity.SplendidBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/8/23.
 */

public class RetrofitManage {
    private static RetrofitManage retrofitManage;
    private  RetrofitServices retrofitServices;


    private RetrofitManage() {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(50, TimeUnit.SECONDS).readTimeout(50, TimeUnit.SECONDS).writeTimeout(50, TimeUnit.SECONDS).build();
        retrofitServices = new Retrofit.Builder().client(client).baseUrl("https://www.baidu.com/").addConverterFactory(GsonConverterFactory.create(new Gson())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(RetrofitServices.class);
    }

    public synchronized static RetrofitManage getInstance() {
        if (retrofitManage == null) {
            retrofitManage = new RetrofitManage();
        }
        return retrofitManage;
    }

    public void GetNetwork( Observer<BroadcastBean> observer) {
        Observable<BroadcastBean> beanObservable = retrofitServices.sendGet();
        beanObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void GetNetworkItem(Observer<BoradcastBeanitem> observer) {
        Observable<BoradcastBeanitem> beanObserver = retrofitServices.sendGetItem();
        beanObserver.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //这里是熊猫直播里面直播的网络请求的方法
    public void GetNetWorkLiveMBean(Observer<LiveMBean> observer){
        Observable<LiveMBean> getlivembean = retrofitServices.getlivembean();

        getlivembean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);


    }

    //这里是熊猫直播里面精彩一刻的网络请求的方法

    public void GetNetWorkSplendidbean(Observer<SplendidBean> observer){

        Observable<SplendidBean> getsplendidbean=retrofitServices.getsplendidbean();

       getsplendidbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }
    public void GetNetworkRlling(Observer<RllingBean> observer) {
        Observable<RllingBean> beanObserver = retrofitServices.sendGetRlling();
        beanObserver.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getChiTabList(Observer<ChinaTabList> observer) {
        Observable<ChinaTabList> beanObserver = retrofitServices.getChiTabList();
        beanObserver.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getLvieChina(Observer<LvieChina> observer,String url) {
        Observable<LvieChina> beanObserver = retrofitServices.getLvieChina(url);
        beanObserver.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

}
