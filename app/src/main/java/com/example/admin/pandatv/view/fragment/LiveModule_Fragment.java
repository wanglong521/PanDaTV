package com.example.admin.pandatv.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.customview.NonSwipeableViewPager;
import com.example.admin.pandatv.view.fragment.livefragment.Livetelecast_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.PandaFiles_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.PandaTOP_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Pandathing_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Primarynew_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Special_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Splendid_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Supersprout_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.WhenBear_Fragment;

import java.util.ArrayList;
import java.util.List;
//这是小媛荣的代码
/**
 * Created by admin on 2017/8/23.
 */

public class LiveModule_Fragment  extends BaseFragment {

    private ImageView my;

    private NonSwipeableViewPager mViewPager;
    private List<Fragment> fraglist=new ArrayList<Fragment>();
    private List<String> titlelist=new ArrayList<String>();
    private TabLayout mTablayout;


    @Override
    public int getLayout() {
        return R.layout.livemodule_fragment;
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {





    }

    @Override
    protected void initView(View view) {

        my = view.findViewById(R.id.my);

        mTablayout = view.findViewById(R.id.mTableyout);

        mViewPager = view.findViewById(R.id.mViewPager);

        titlelist.add("直播");
        titlelist.add("精彩一刻");
        titlelist.add("当熊不让");
        titlelist.add("超萌滚滚秀");
        titlelist.add("熊猫档案");
        titlelist.add("熊猫TOP榜");
        titlelist.add("熊猫那些事");
        titlelist.add("特别节目");
        titlelist.add("原创新闻");

        fraglist.add(new Livetelecast_Fragment());
        fraglist.add(new Splendid_Fragment());
        fraglist.add(new WhenBear_Fragment());
        fraglist.add(new Supersprout_Fragment());
        fraglist.add(new PandaFiles_Fragment());
        fraglist.add(new PandaTOP_Fragment());
        fraglist.add(new Pandathing_Fragment());
        fraglist.add(new Special_Fragment());
        fraglist.add(new Primarynew_Fragment());


        /**
         * 这个方法是设置viewpager不能左右滑动
         */

        MyAdapter adapter=new MyAdapter(App.mBaseActivity.getSupportFragmentManager(),fraglist,titlelist);

        mTablayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(titlelist.size());
        mViewPager.setAdapter(adapter);
    }

    public  class MyAdapter extends FragmentPagerAdapter {


        private List<Fragment> fraglist;
        private List<String> titlelist;

        public MyAdapter(FragmentManager fm, List<Fragment> fraglist, List<String> titlelist) {
            super(fm);
            this.fraglist = fraglist;
            this.titlelist = titlelist;
        }

        @Override//返回对应位置的
        public Fragment getItem(int position) {

            return fraglist.get(position);
        }

        @Override//赶回viewpage总条目数
        public int getCount() {

            return fraglist.size();
        }

        @Override
        //给TabLayout加标题与TabLayout起使用
        public CharSequence getPageTitle(int position)
        {
            return titlelist.get(position);
        }
    }



}
