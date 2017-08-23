package com.example.admin.pandatv.model.networkutils;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/8/23.
 */

public class RetrofitManage {
    private static RetrofitManage retrofitManage;

    private RetrofitManage(String url) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(50, TimeUnit.SECONDS).readTimeout(50, TimeUnit.SECONDS).writeTimeout(50, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder().client(client).baseUrl(url).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
    }

    public synchronized static RetrofitManage getInstance(String url) {
        if (retrofitManage == null) {
            retrofitManage = new RetrofitManage(url);
        }
        return retrofitManage;
    }


}
