package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.livapandabean.LiveMBean;
import com.example.admin.pandatv.model.entity.LvieChina;
import com.example.admin.pandatv.model.entity.livapandabean.PandaFilesBean;
import com.example.admin.pandatv.model.entity.livapandabean.PandaTOPBean;
import com.example.admin.pandatv.model.entity.livapandabean.PandaThingBean;
import com.example.admin.pandatv.model.entity.livapandabean.PrimarynewBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.entity.livapandabean.SpecialBean;
import com.example.admin.pandatv.model.entity.livapandabean.SplendidBean;
import com.example.admin.pandatv.model.entity.livapandabean.SupersBean;
import com.example.admin.pandatv.model.entity.livapandabean.WhenBreadBean;
import com.google.gson.Gson;

import java.util.Map;
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

    public void GetNetWorkSplendidbean(Observer<SplendidBean> observer, Map<String,String> map){

        Observable<SplendidBean> getsplendidbean=retrofitServices.getsplendidbean(map);

       getsplendidbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }
    public void GetNetworkRlling(Observer<RllingBean> observer) {
        Observable<RllingBean> beanObserver = retrofitServices.sendGetRlling();
        beanObserver.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //这里是熊猫直播里面当熊不让的网络请求的方法

    public void GetNetworkWhenBreadbean(Observer<WhenBreadBean> observer,Map<String,String> map){
        Observable<WhenBreadBean> getwhenbreadbean = retrofitServices.getwhenbreadbean(map);

        getwhenbreadbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }
    //这里是熊猫直播里面超萌滚滚秀网络请求的方法

    public void GetNetworkSupersbean(Observer<SupersBean> observer,Map<String,String> map){
        Observable<SupersBean> supersbean = retrofitServices.getSupersbean(map);

        supersbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }

    //这是熊猫直播里面熊猫档案的网络请求的方法
    public void GetNetworkPandaFilesbean(Observer<PandaFilesBean> observer,Map<String,String> map){

        Observable<PandaFilesBean> pandaFilesbean = retrofitServices.getPandaFilesbean(map);

        pandaFilesbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }
    //这是熊猫直播里面熊猫TOP榜的网络请求

    public void getPandaTOP(Observer<PandaTOPBean> observer,Map<String,String> map){

        Observable<PandaTOPBean> pandaTOPBeanObservable = retrofitServices.getpandaTOPbean(map);

        pandaTOPBeanObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }

    //这是熊猫直播里面熊猫那些事的网络请求

    public void getPandaThing(Observer<PandaThingBean> observer,Map<String,String> map){

        Observable<PandaThingBean> pandaThingBeanObservable = retrofitServices.getpandaThing(map);

        pandaThingBeanObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);


    }

    //这是熊猫直播里面特别节目的网络请求
    public void getSpecial(Observer<SpecialBean> observer,Map<String,String> map){

        Observable<SpecialBean> getspcialbean = retrofitServices.getspcialbean(map);

        getspcialbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //这是熊猫直播里面原创新闻的网络请求

    public void getPrimarynew(Observer<PrimarynewBean> observer,Map<String,String> map){

        Observable<PrimarynewBean> getprimarybean = retrofitServices.getprimarybean(map);

        getprimarybean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

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
