package com.example.admin.pandatv.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 2017/8/23.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.mBaseActivity = this;
        setContentView(getLayoutId());

        initView();
        initData();
        initListener();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //一定要在onResume方法中保存Activity的最新状态
        App.mBaseActivity = this;
    }

    /**
     * 加载点击事件
     */
    protected abstract void initListener();

    /**
     * 加载数据
     */
    protected abstract void initData();

    /**
     * 加载控件
     */

    protected abstract void initView();

    /**
     * 加载布局
     */
    public abstract int getLayoutId();


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
