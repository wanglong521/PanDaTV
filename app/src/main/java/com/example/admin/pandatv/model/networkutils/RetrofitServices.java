package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by admin on 2017/8/23.
 */

public interface RetrofitServices {

    @GET("http://www.ipanda.com/kehuduan/news/index.json")
    Observable<BroadcastBean> sendGet();

    @GET("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda")
    Observable<BoradcastBeanitem> sendGetItem();

}
