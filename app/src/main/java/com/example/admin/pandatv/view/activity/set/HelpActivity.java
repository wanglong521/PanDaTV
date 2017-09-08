package com.example.admin.pandatv.view.activity.set;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseActivity;
import com.example.admin.pandatv.view.fragment.sethelp.Common_Fragmnet;
import com.example.admin.pandatv.view.fragment.sethelp.Encounter_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiYRong on 2017/9/7.
 */

public class HelpActivity extends BaseActivity {

    private TabLayout help_tablayout;
    private ViewPager help_viewpager;
    private ImageView mLoginBackwards;
    private List<String> tablist=new ArrayList<String>();

    private List<Fragment> fralisit=new ArrayList<Fragment>();
    @Override
    protected void initListener() {

        mLoginBackwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }

    @Override
    protected void initData() {

        tablist.add("遇到的问题");
        tablist.add("常见问题");

        fralisit.add(new Encounter_Fragment());
        fralisit.add(new Common_Fragmnet());

        help_tablayout.addTab(help_tablayout.newTab().setText(tablist.get(0)));
        help_tablayout.addTab(help_tablayout.newTab().setText(tablist.get(1)));

        FragmentManager manager = getSupportFragmentManager();

        MyAdapter adapter=new MyAdapter(manager);

        help_viewpager.setAdapter(adapter);

        help_tablayout.setupWithViewPager(help_viewpager);
    }

    @Override
    protected void initView() {

        help_tablayout = (TabLayout) findViewById(R.id.help_tablayout);
        help_viewpager = (ViewPager) findViewById(R.id.help_viewpager);
        mLoginBackwards = (ImageView) findViewById(R.id.LoginBackwards);

    }

    @Override
    public int getLayoutId() {
        return R.layout.help_item;
    }
      public  class MyAdapter extends FragmentPagerAdapter {

              public MyAdapter(FragmentManager fm) {
                  super(fm);
              }

              @Override//返回对应位置的
              public Fragment getItem(int position) {

                  return fralisit.get(position);
              }

              @Override//赶回viewpage总条目数
              public int getCount() {

                  return fralisit.size();
              }

              @Override
              //给TabLayout加标题   与TabLayout起使用
              public CharSequence getPageTitle(int position)
              {
         return tablist.get(position);
              }
            }
}
