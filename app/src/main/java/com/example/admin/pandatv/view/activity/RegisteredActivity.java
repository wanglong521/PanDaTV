package com.example.admin.pandatv.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.adapter.RegistrationAdapter;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseActivity;
import com.example.admin.pandatv.view.fragment.registration.EmailRegistration;
import com.example.admin.pandatv.view.fragment.registration.PhoneRegistration;

import java.util.ArrayList;

/**
 * 注册
 */
public class RegisteredActivity extends BaseActivity{

    private ImageView registeredBackwards;
    private TabLayout RegisteredTabLayout;
    private ViewPager RegisteredViewPager;

    @Override
    protected void initListener() {
        RegisteredViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        RegisteredViewPager.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        RegisteredViewPager.requestDisallowInterceptTouchEvent(false);
                    default:
                        break;
                }
                return true;
            }
        });
        registeredBackwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.mBaseActivity.finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        registeredBackwards = (ImageView) findViewById(R.id.RegisteredBackwards);
        RegisteredTabLayout = (TabLayout) findViewById(R.id.RegisteredTabLayout);
        RegisteredViewPager = (ViewPager) findViewById(R.id.RegisteredViewPager);
        ArrayList<Fragment> list = new ArrayList<Fragment>();
        EmailRegistration emailRegistration = new EmailRegistration();
        PhoneRegistration phoneRegistration = new PhoneRegistration();
        list.add(phoneRegistration);
        list.add(emailRegistration);
        ArrayList<String> str = new ArrayList<String>();
        str.add("手机注册");
        str.add("邮箱注册");
        RegistrationAdapter adapter = new RegistrationAdapter(getSupportFragmentManager(),list, App.mBaseActivity,str);
        RegisteredTabLayout.setupWithViewPager(RegisteredViewPager);
        RegisteredTabLayout.setTabMode(TabLayout.MODE_FIXED);
        RegisteredViewPager.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_registered;
    }
}
