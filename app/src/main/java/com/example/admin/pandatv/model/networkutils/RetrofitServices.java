package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LvieChina;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/8/23.
 */

public interface RetrofitServices {


    @GET("http://www.ipanda.com/kehuduan/news/index.json")
    Observable<BroadcastBean> sendGet();

    @GET("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda")
    Observable<BoradcastBeanitem> sendGetItem();

    @GET("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json")
    Observable<ChinaTabList> getChiTabList();

    @FormUrlEncoded
    @POST("{url}")
    Observable<LvieChina> getLvieChina(@Path("url")String url);
}
