package com.example.admin.pandatv.view.base;

import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;

/**
 *
 * Class Note:登陆View的接口，实现类也就是登陆的activity
 *
 *
 */
public interface IView {

    void OnSucceed(BroadcastBean succed);

    void OnDefeated();

    void OnSucceedItem(BoradcastBeanitem beanitem);

    void OnDefeatedItem();
}
