package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.ChinaTabList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by admin on 2017/8/23.
 */

public interface RetrofitServices {
    @GET("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json")
    Observable<ChinaTabList> getChiTabList();

}
