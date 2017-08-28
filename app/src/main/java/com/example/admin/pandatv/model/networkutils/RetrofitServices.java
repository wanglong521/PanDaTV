package com.example.admin.pandatv.model.networkutils;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.entity.ChinaTabList;
import com.example.admin.pandatv.model.entity.LiveMBean;
import com.example.admin.pandatv.model.entity.RllingBean;
import com.example.admin.pandatv.model.entity.SplendidBean;
import com.example.admin.pandatv.model.entity.WhenBreadBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

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

    //这里是熊猫直播里面直播的网络请求的方法
    @GET("http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json")
    Observable<LiveMBean> getlivembean();

    //这里是熊猫直播里面精彩一刻网络请求的方法
    //?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1

    @POST("http://api.cntv.cn/video/videolistById")
    Observable<SplendidBean> getsplendidbean(@QueryMap Map<String,String> map);

    //这里是熊猫直播里面当熊不让的网络请求的方法

    @POST("http://api.cntv.cn/video/videolistById")
    Observable<WhenBreadBean> getwhenbreadbean(@QueryMap Map<String,String> map);


    @GET("http://www.ipanda.com/kehuduan/video/index.json")
    Observable<RllingBean> sendGetRlling();

}
