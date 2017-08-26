package com.example.admin.pandatv.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2017/8/23.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(App.mBaseActivity, getLayout(), null);


        return view;
    }
    /**
     * 加载布局
     */
    public abstract int getLayout();

    @Override//可以查一下onViewCreated方法执行的顺序
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        initListener();

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
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
    protected abstract void initView(View view);


}
