package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
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

    public void GetNetworkRlling(Observer<RllingBean> observer) {
        Observable<RllingBean> beanObserver = retrofitServices.sendGetRlling();
        beanObserver.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }


}
