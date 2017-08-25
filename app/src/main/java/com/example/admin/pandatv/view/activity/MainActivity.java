package com.example.admin.pandatv.view.activity;

import android.support.annotation.IdRes;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.BoradcastBeanitem;
import com.example.admin.pandatv.model.entity.BroadcastBean;
import com.example.admin.pandatv.model.modelutils.FragmentBuilder;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseActivity;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.IView;
import com.example.admin.pandatv.view.fragment.BroadcastModule_Fragment;
import com.example.admin.pandatv.view.fragment.ChinaModule_Fragment;
import com.example.admin.pandatv.view.fragment.HomeModule_Fragment;
import com.example.admin.pandatv.view.fragment.LiveModule_Fragment;
import com.example.admin.pandatv.view.fragment.RollingModule_Fragment;

import static com.example.admin.pandatv.R.id.mBroadcastModule;
import static com.example.admin.pandatv.R.id.mChinaModule;
import static com.example.admin.pandatv.R.id.mHomeModule;
import static com.example.admin.pandatv.R.id.mLiveModule;
import static com.example.admin.pandatv.R.id.mRollingModule;

public class MainActivity extends BaseActivity implements IView{
    private android.support.v4.app.FragmentManager supportFragmentManager;
    RadioGroup   HomeRadioGroup;
    private double mExitTime;

    @Override
    protected void initListener() {
        HomeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i) {
                    case mHomeModule:
                        /**
                         * 首页
                         */
                        FragmentBuilder.getInstance().init().initContainId(R.id.homeframe).add(HomeModule_Fragment.class).build();
                        break;
                    case mLiveModule:
                        /**
                         * 熊猫直播
                         */

                        FragmentBuilder.getInstance().init().initContainId(R.id.homeframe).add(LiveModule_Fragment.class).build();
                        break;
                    case mRollingModule:
                        /**
                         * 滚滚视频
                         *
                         *
                         */

                        FragmentBuilder.getInstance().init().initContainId(R.id.homeframe).add(RollingModule_Fragment.class).build();
                        break;
                    case mBroadcastModule:
                        /**
                         * 熊猫播报
                         */

                        FragmentBuilder.getInstance().init().initContainId(R.id.homeframe).add(BroadcastModule_Fragment.class).build();
                        break;
                    case mChinaModule:
                        /**
                         * 直播中国
                         */

                        FragmentBuilder.getInstance().init().initContainId(R.id.homeframe).add(ChinaModule_Fragment.class).build();
                        break;
                }
            }
        });

    }

    @Override
    protected void initData() {
        /**
         * 用来添加Fragment
         */
    supportFragmentManager= App.mBaseActivity.getSupportFragmentManager();
        FragmentBuilder.getInstance().init().initContainId(R.id.homeframe).add(HomeModule_Fragment.class).build();
    }

    @Override
    protected void initView() {
        HomeRadioGroup=   (RadioGroup) findViewById(R.id.HomeRadioGroup);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void OnSucceed(BroadcastBean succed) {

    }

    @Override
    public void OnDefeated() {

    }

    @Override
    public void OnSucceedItem(BoradcastBeanitem beanitem) {

    }

    @Override
    public void OnDefeatedItem() {

    }

    /**
     * 自定义回退栈管理；
     * 获取栈顶的fragment的名字，判断名字是否和主页的名字是否一样，
     * 如果一样就退出应用，如果不是就回退上一个fragment；
     */
   @Override
    public void onBackPressed() {
        //通过FragmentManger来获取回退栈中位于栈顶的Fregment的名字


        String simpleName = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName();
        if ("HomeModule_Fragment".equals(simpleName)|"LiveModule_Fragment".equals(simpleName)
                |"RollingModule_Fragment".equals(simpleName)|"BroadcastModule_Fragment".equals(simpleName)
                |"ChinaModule_Fragment".equals(simpleName)) {
            finish();
        } else {
            if (supportFragmentManager.getBackStackEntryCount() > 1) {
                supportFragmentManager.popBackStackImmediate();//
                String name = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName();
                App.mBaseFragment = (BaseFragment) supportFragmentManager.findFragmentByTag(name);
            }
        }
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //通过FragmentManger来获取回退栈中位于栈顶的Fregment的名字
        //supportFragmentManager.getBackStackEntryCount()  该方法获取fragment栈里面Fragment的总数
        String  simpleName = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName();

        if ("HomeModule_Fragment".equals(simpleName)|"LiveModule_Fragment".equals(simpleName)|"RollingModule_Fragment".equals(simpleName)
                |"BroadcastModule_Fragment".equals(simpleName)|"ChinaModule_Fragment".equals(simpleName)) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {//back键被按下了
                if ((System.currentTimeMillis() - mExitTime) > 2000) {//第二次点击判断是否在两秒内完成，是的话Finish掉（退出）
                    Toast.makeText(this, "连续点击两次退出程序", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    finish();
                    System.exit(0);
                }
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
