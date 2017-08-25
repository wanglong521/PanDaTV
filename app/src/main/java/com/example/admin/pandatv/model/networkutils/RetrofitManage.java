package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.ChinaTabList;
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
    private final RetrofitServices retrofitServices;


    private RetrofitManage(String url) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(50, TimeUnit.SECONDS).readTimeout(50, TimeUnit.SECONDS).writeTimeout(50, TimeUnit.SECONDS).build();
        retrofitServices = new Retrofit.Builder().client(client).baseUrl(url).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(new Gson())).build()
                .create(RetrofitServices.class);
    }

    public synchronized static RetrofitManage getInstance(String url) {
        if (retrofitManage == null) {
            retrofitManage = new RetrofitManage(url);
        }
        return retrofitManage;
    }
    public void getChinaTabList(Observer observer){
        Observable<ChinaTabList> chiTabList = retrofitServices.getChiTabList();
        chiTabList.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
