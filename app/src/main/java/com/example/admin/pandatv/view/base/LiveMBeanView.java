package com.example.admin.pandatv.view.base;

import com.example.admin.pandatv.model.entity.livapandabean.LiveMBean;

/**
 * Created by LiYRong on 2017/8/26.
 *
 *
 * 这里是熊猫直播里面直播网络请求view
 */

public interface LiveMBeanView {

    void OnSucceed(LiveMBean succed);

    void OnDefeated();


}
