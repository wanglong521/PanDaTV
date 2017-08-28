package com.example.admin.pandatv.view.base;

import com.example.admin.pandatv.model.entity.SplendidBean;

/**
 * Created by LiYRong on 2017/8/27.
 *
 * 这里是熊猫直播里面精彩一刻网络请求view
 */

public interface SplendidView {

    void OnSucceed(SplendidBean succed);

    void OnDefeated();
}
