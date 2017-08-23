package com.example.admin.pandatv.model.modelutils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;

/**
 * 王龙
 * Fragment的管理类
 *
 */

public class FragmentBuilder {

    private static FragmentBuilder builder;
    private  FragmentManager manager;
    private  FragmentTransaction transaction;
    private int id;
    private String name;
    private Fragment tag;
    private BaseFragment instance;
    private BaseFragment nowFragment;
    private Fragment lastFragment;
    private Fragment nowFragment1;


    public static FragmentBuilder getInstance() {
        if (builder == null) {
            synchronized (FragmentBuilder.class){
                builder=new FragmentBuilder();
            }
        }
        return builder;
    }


    public FragmentBuilder() {
        init();
    }
    //初始化Fragmentmanager 和transaction
    public FragmentBuilder init() {
        manager = App.mBaseActivity.getSupportFragmentManager();
        transaction = manager.beginTransaction();
        return this;
    }

    //设置一个Fragment的容器
    public FragmentBuilder initContainId(int id){
        this.id=id;
        return this;
    }

    //参数fragment相当于你需要传递一个Fragment1.class
    public FragmentBuilder add(Class<? extends  BaseFragment> fragment){
        name = fragment.getSimpleName();
        nowFragment = (BaseFragment) manager.findFragmentByTag(name);
        if (nowFragment ==null){
            try {
                //获取Fragment的对象
                nowFragment = fragment.newInstance();
                //把Fragment添加到事物里面去
                transaction.add(id, nowFragment,name);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //隐藏fragment
        if (App.mBaseFragment != null) {
            transaction.hide(App.mBaseFragment);
        }
        //显示当前的Fragment
        if ( nowFragment != null) {
            transaction.show(nowFragment);
        }
        return this;

    }


    //参数fragment相当于你需要传递一个Fragment1.class
    public FragmentBuilder replace(Class<? extends  BaseFragment> fragment){
        name = fragment.getSimpleName();
        nowFragment = (BaseFragment) manager.findFragmentByTag(name);
        if (nowFragment ==null){
            try {
                //获取Fragment的对象
                nowFragment = fragment.newInstance();
                //把Fragment添加到事物里面去
                transaction.replace(id, nowFragment,name);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //显示当前的Fragment
        if ( nowFragment != null) {
            transaction.show(nowFragment);
        }
        return this;

    }


    //添加到回退栈并提交transaction
    public void build(){
        transaction.addToBackStack(name);
        App.mBaseFragment = nowFragment;
        transaction.commit();
    }


}
