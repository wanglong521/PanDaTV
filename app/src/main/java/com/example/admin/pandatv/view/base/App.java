package com.example.admin.pandatv.view.base;

import android.app.Application;

import com.yixia.weibo.sdk.VCamera;

/**
 * Created by admin on 2017/8/23.
 */

public class App extends Application {
    public static BaseActivity mBaseActivity;
    public static BaseFragment mBaseFragment;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
